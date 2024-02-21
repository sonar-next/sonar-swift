package com.github.sonar.next.sonarqube.java.issues.infer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.FilePredicates;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.rule.RuleKey;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author magaofei
 * @date 2021/04/11
 * infer parser
 */
public class InferReportParser {

    private static final Logger logger = LoggerFactory.getLogger(InferReportParser.class);
    public static final String LINE_NUMBER = "line_number";

    private final SensorContext context;

    public InferReportParser(final SensorContext context) {
        this.context = context;
    }

    public void parseReport(File jsonFile) {

        try (FileReader fr = new FileReader(jsonFile)) {
            // Read and parse report
            Object reportObj = JSONValue.parse(fr);

            // Record issues
            if (reportObj != null) {
                JSONArray reportJson = (JSONArray) reportObj;
                for (Object obj : reportJson) {
                    this.recordIssue((JSONObject) obj);
                }
            }

        } catch (IOException e) {
            logger.error("Failed to parse Infer report file", e);

        }
    }

    protected void recordIssue(final JSONObject jsonObject) {

        String filePath = (String) jsonObject.get("file");
        logger.debug("record issue for java, path = {}", filePath);
        if (filePath != null) {

            JSONArray bugTraceJsonArray = (JSONArray) jsonObject.get("bug_trace");
            int lineNum = Integer.parseInt(String.valueOf(jsonObject.get("line")));
            if (bugTraceJsonArray.size() == 1) {
                JSONObject bugTraceObject = (JSONObject) bugTraceJsonArray.get(0);
                Object lineNumber = bugTraceObject.get(LINE_NUMBER);
                filePath = (String) bugTraceObject.get("filename");
                if (lineNumber == null) {
                    logger.error("bug_trace line_number is null, bugTraceObject = {}", bugTraceObject);
                    return;
                }
                lineNum = Integer.parseInt(String.valueOf(lineNumber));
            }

            if (lineNum == 0) {
                logger.error("line number == 0, {}", jsonObject);
                return;
            }


            FilePredicates predicates = context.fileSystem().predicates();
            FilePredicate fp = predicates.or( predicates.hasAbsolutePath( filePath ),
                predicates.hasRelativePath( filePath ) );

            InputFile inputFile = null;
            if (!context.fileSystem().hasFiles( fp )) {
                logger.debug("fileSystem hasFiles filePath:{}", filePath);
                FileSystem fs = context.fileSystem();
                //Search for path _ending_ with the filename
                for (InputFile f : fs.inputFiles( fs.predicates().hasType( InputFile.Type.MAIN ) )) {
                    if (filePath.endsWith( f.relativePath() )) {
                        inputFile = f;
                        break;
                    }
                }
            } else {
                logger.debug("fileSystem inputFile filePath:{}", filePath);
                inputFile = context.fileSystem().inputFile( fp );
            }
            if (inputFile == null) {
                logger.warn( "file not included in sonar {}", filePath );
                return;
            }

            String info = (String) jsonObject.get("qualifier");
            String rule = jsonObject.get("bug_type").toString();
            try {
                RuleKey ruleKey = RuleKey.of(InferRulesDefinition.REPOSITORY_KEY, rule);
                NewIssue newIssue = context.newIssue()
                        .forRule(ruleKey);
                NewIssueLocation dil = newIssue.newLocation()
                        .on(inputFile)
                        .at(inputFile.selectLine(lineNum))
                        .message(info);
                List<NewIssueLocation> newIssueLocations = this.composeLocationList(newIssue, bugTraceJsonArray);
                        newIssue
                        .addFlow(newIssueLocations)
                        .at(dil)
                        .save();
            } catch (IllegalArgumentException e) {
                logger.error("infer error, jsonObject = {}", jsonObject, e);
            }

        }
    }

    private List<NewIssueLocation> composeLocationList(NewIssue newIssue, JSONArray bugTraceJsonArray) {
        List<NewIssueLocation> locations = new ArrayList<>();
        for (int i = bugTraceJsonArray.size() - 1; i >= 0; i--) {
            JSONObject bugTraceObject = (JSONObject) bugTraceJsonArray.get(i);
            String filePath = (String) bugTraceObject.get("filename");
            if (filePath != null) {
//                if (!filePath.equals(parentFilePath)) {
//                    continue;
//                }
                FilePredicate fp = context.fileSystem().predicates().hasRelativePath(filePath);
                InputFile inputFile = null;
                if (!context.fileSystem().hasFiles(fp)) {
                    FileSystem fs = context.fileSystem();
                    //Search for path _ending_ with the filename
                    for (InputFile f : fs.inputFiles(fs.predicates().hasType(InputFile.Type.MAIN))) {
                        if (filePath.endsWith(f.relativePath())) {
                            inputFile = f;
                            break;
                        }
                    }
                } else {
                    inputFile = context.fileSystem().inputFile(fp);
                }
                if (inputFile == null) {
                    logger.warn("bug_trace to location file not included in sonar {}", filePath);
                    continue;
                }

                String description = (String) bugTraceObject.get("description");
                Object lineNumber = bugTraceObject.get(LINE_NUMBER);
                int lineNum = Integer.parseInt(String.valueOf(lineNumber));
                if (lineNum == 0) {
                    logger.error("bug_trace to location line number == 0, {}", bugTraceObject);
                    continue;
                }
                assert inputFile != null;
                try {
                    NewIssueLocation newIssueLocation = newIssue.newLocation()
                            .on(inputFile)
                            .at(inputFile.selectLine(lineNum))
                            .message(description);
                    locations.add(newIssueLocation);
                } catch (IllegalArgumentException e) {
                    logger.error("infer error, bugTraceObject = {}", bugTraceObject, e);
                }
            }
        }

        return locations;
    }

}
