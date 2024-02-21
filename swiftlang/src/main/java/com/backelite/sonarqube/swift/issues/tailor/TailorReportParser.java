/**
 * Swift SonarQube Plugin - Swift module - Enables analysis of Swift and Objective-C projects into SonarQube.
 * Copyright © 2015 Backelite (${email})
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.backelite.sonarqube.swift.issues.tailor;

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

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by tzwickl on 22/11/2016.
 */

public class TailorReportParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(TailorReportParser.class);

    private final SensorContext context;

    public TailorReportParser(final SensorContext context) {
        this.context = context;
    }

    public void parseReport(final File reportFile) {
        try (Stream<String> lines = Files.lines(reportFile.toPath())) {
            // Read and parse report
            lines.forEach(this::recordIssue);
        } catch (IOException e) {
            LOGGER.error("Failed to parse SwiftLint report file", e);
        }
    }

    private void recordIssue(final String line) {
        LOGGER.debug("record issue {}", line);

        Pattern pattern = Pattern.compile("(.*.swift):(\\w+):(\\w+): (.*): \\[(.*)\\] (.*)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String filePath = matcher.group(1);
            int lineNum = Integer.parseInt(matcher.group(2));
            String ruleId = matcher.group(5);
            String message = matcher.group(6);

            FilePredicates predicates = context.fileSystem().predicates();
            FilePredicate fp = predicates.or(predicates.hasAbsolutePath(filePath), predicates.hasRelativePath(filePath));

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
                LOGGER.warn("file not included in sonar {}", filePath);
                continue;
            }

            NewIssue newIssue = context.newIssue()
                    .forRule(RuleKey.of(TailorRulesDefinition.REPOSITORY_KEY, ruleId));

            NewIssueLocation dil = newIssue.newLocation()
                    .on(inputFile)
                    .at(inputFile.selectLine(lineNum))
                    .message(message);
            newIssue.at(dil).save();
        }
    }
}
