package com.backelite.sonarqube.objectivec.issues.infer;

import com.backelite.sonarqube.objectivec.issues.fauxpas.FauxPasRulesDefinition;
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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Harry
 * @date 2020/10/27
 * infer 解析器
 */
public class InferReportParser {

    private static final Logger logger = LoggerFactory.getLogger(InferReportParser.class);

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
                    recordIssue((JSONObject) obj);
                }
            }

        } catch (FileNotFoundException e) {
            logger.error("Failed to parse Infer report file", e);

        } catch (IOException e) {
            logger.error("Failed to parse Infer report file", e);

        }
    }

    private void recordIssue(final JSONObject jsonObject) {

        String filePath = (String) jsonObject.get("file");
        if (filePath != null){
            FilePredicate fp = context.fileSystem().predicates().hasAbsolutePath(filePath);

            if (!context.fileSystem().hasFiles(fp)) {
                logger.warn("file not included in sonar {}", filePath);
                return;
            }

            String info = (String) jsonObject.get("qualifier");

            int lineNum = (int) jsonObject.get("line");
            if (lineNum == 0) {
                lineNum++;
            }

            InputFile inputFile = context.fileSystem().inputFile(fp);
            NewIssueLocation dil = new DefaultIssueLocation()
                    .on(inputFile)
                    .at(inputFile.selectLine(lineNum))
                    .message(info);
            context.newIssue()
                    .forRule(RuleKey.of(InferRulesDefinition.REPOSITORY_KEY, (String) jsonObject.get("bug_type")))
                    .at(dil)
                    .save();
        }
    }

}
