package com.backelite.sonarqube.objectivec.issues.infer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.batch.sensor.issue.internal.DefaultIssueLocation;
import org.sonar.api.rule.RuleKey;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuwenguang magaofei
 * @date 2020/10/27
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

    private void recordIssue(final JSONObject jsonObject) {

        String filePath = (String) jsonObject.get("file");
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

            FilePredicate fp = context.fileSystem().predicates().hasRelativePath(filePath);

            if (!context.fileSystem().hasFiles(fp)) {
                logger.warn("file not included in sonar {}", filePath);
                return;
            }

            String info = (String) jsonObject.get("qualifier");

            InputFile inputFile = context.fileSystem().inputFile(fp);
            assert inputFile != null;
            try {
                NewIssueLocation dil = new DefaultIssueLocation()
                        .on(inputFile)
                        .at(inputFile.selectLine(lineNum))
                        .message(info);
                context.newIssue()
                        .forRule(RuleKey.of(InferRulesDefinition.REPOSITORY_KEY, (String) jsonObject.get("bug_type")))
                        .addFlow(this.composeLocationList(filePath, bugTraceJsonArray))
                        .at(dil)
                        .save();
            } catch (IllegalArgumentException e) {
                logger.error("infer error, jsonObject = {}", jsonObject, e);
            }

        }
    }

    private List<NewIssueLocation> composeLocationList(String parentFilePath, JSONArray bugTraceJsonArray) {
        List<NewIssueLocation> locations = new ArrayList<>();
        for (int i = bugTraceJsonArray.size() - 1; i >= 0; i--) {
            JSONObject bugTraceObject = (JSONObject) bugTraceJsonArray.get(i);
            String filePath = (String) bugTraceObject.get("filename");
            if (filePath != null) {
//                if (!filePath.equals(parentFilePath)) {
//                    continue;
//                }
                FilePredicate fp = context.fileSystem().predicates().hasRelativePath(filePath);
                if (!context.fileSystem().hasFiles(fp)) {
                    logger.warn("bug_trace to location file not included in sonar {}", filePath);
                    continue;
                }
                InputFile inputFile = context.fileSystem().inputFile(fp);
                String description = (String) bugTraceObject.get("description");
                Object lineNumber = bugTraceObject.get(LINE_NUMBER);
                int lineNum = Integer.parseInt(String.valueOf(lineNumber));
                if (lineNum == 0) {
                    logger.error("bug_trace to location line number == 0, {}", bugTraceObject);
                    continue;
                }
                assert inputFile != null;
                try {
                    NewIssueLocation newIssueLocation = new DefaultIssueLocation()
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
