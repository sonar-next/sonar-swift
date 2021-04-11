/**
 * Swift SonarQube Plugin - Objective-C module - Enables analysis of Swift and Objective-C projects into SonarQube.
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
package com.tal.sonarqube.java;

import com.backelite.sonarqube.commons.DirectoryScanner;
import com.backelite.sonarqube.commons.MeasureUtil;
import com.tal.sonarqube.java.lang.core.Java;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.rule.CheckFactory;
import org.sonar.api.batch.rule.Checks;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;
import org.sonar.api.batch.sensor.issue.NewIssue;
import org.sonar.api.batch.sensor.issue.NewIssueLocation;
import org.sonar.api.batch.sensor.issue.internal.DefaultIssueLocation;
import org.sonar.api.config.Configuration;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.scan.filesystem.PathResolver;
import org.sonar.api.utils.WildcardPattern;
import org.sonar.squidbridge.AstScanner;
import org.sonar.squidbridge.SquidAstVisitor;
import org.sonar.squidbridge.api.CheckMessage;
import org.sonar.squidbridge.api.SourceCode;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.squidbridge.checks.SquidCheck;
import org.sonar.squidbridge.indexer.QueryByType;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;


public abstract class JavaReportSensor implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(JavaReportSensor.class);

    private final Number[] FUNCTIONS_DISTRIB_BOTTOM_LIMITS = {1, 2, 4, 6, 8, 10, 12, 20, 30};
    private final Number[] FILES_DISTRIB_BOTTOM_LIMITS = {0, 5, 10, 20, 30, 60, 90};


    protected final Configuration conf;
    private final String reportType;

    public JavaReportSensor(Configuration conf, String reportType) {
        this.conf = conf;
        this.reportType = reportType;
    }

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor
                .name(getClass().getSimpleName())
                .onlyOnLanguage(Java.KEY)
                .name("Java Infer Report")
                .onlyOnFileType(InputFile.Type.MAIN);
    }
//
//    @Override
//    public void execute(SensorContext context) {
//        String reportPathPropertyKey = reportPathKey();
//        String reportPath = conf.get(reportPathPropertyKey).orElse(defaultReportPath());
//        try {
//            List<File> reports = getReports(conf, context.fileSystem().baseDir().getPath(), reportPathPropertyKey, reportPath);
//            processReports(context, reports);
//        } catch (Exception e) {
//            LOG.warn("Cannot read report '{}', the following exception occurred: {}", reportPath, e.getMessage());
//        }
//    }

    public static List<File> getReports(Configuration conf, String baseDirPath, String reportPathPropertyKey, String reportPath) {
        LOG.debug("Using pattern '{}' to find reports", reportPath);

        DirectoryScanner scanner = new DirectoryScanner(new File(baseDirPath), WildcardPattern.create(reportPath));
        List<File> includedFiles = scanner.getIncludedFiles();

        if (includedFiles.isEmpty()) {
            if (conf.hasKey(reportPathPropertyKey)) {
                // try absolute path
                File file = new File(reportPath);
                if (!file.exists()) {
                    LOG.warn("No report was found for {} using pattern {}", reportPathPropertyKey, reportPath);
                } else {
                    includedFiles.add(file);
                }
            } else {
                LOG.debug("No report was found for {} using default pattern {}", reportPathPropertyKey, reportPath);
            }
        }
        return includedFiles;
    }

    protected void processReports(SensorContext context, List<File> reports) throws javax.xml.stream.XMLStreamException {
    }

}
