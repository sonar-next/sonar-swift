package com.tal.sonarqube.java;

import com.backelite.sonarqube.commons.MeasureUtil;
import com.tal.sonarqube.java.lang.JavaAstScanner;
import com.tal.sonarqube.java.lang.JavaConfiguration;
import com.tal.sonarqube.java.lang.api.JavaGrammar;
import com.tal.sonarqube.java.lang.api.JavaMetric;
import com.tal.sonarqube.java.lang.checks.CheckList;
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
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.rule.RuleKey;
import org.sonar.api.scan.filesystem.PathResolver;
import org.sonar.java.externalreport.CheckstyleSensor;
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

public class JavaInferReportSensor implements Sensor {

    private static final Logger LOG = LoggerFactory.getLogger(JavaInferReportSensor.class);

    private final Number[] FUNCTIONS_DISTRIB_BOTTOM_LIMITS = {1, 2, 4, 6, 8, 10, 12, 20, 30};
    private final Number[] FILES_DISTRIB_BOTTOM_LIMITS = {0, 5, 10, 20, 30, 60, 90};

    private final PathResolver pathResolver;
    private final Checks<SquidCheck<JavaGrammar>> checks;


    private SensorContext context;
    private AstScanner<JavaGrammar> scanner;

    public JavaInferReportSensor(SensorContext context, PathResolver pathResolver, CheckFactory checkFactory) {
        this.context = context;
        this.pathResolver = pathResolver;
        this.checks = checkFactory.<SquidCheck<JavaGrammar>>create(CheckList.REPOSITORY_KEY).addAnnotatedChecks((Iterable<Class>)CheckList.getChecks());
    }

    private JavaConfiguration createConfiguration() {
        return new JavaConfiguration(context.fileSystem().encoding());
    }

    private void save(Collection<SourceCode> squidSourceFiles) {
        for (SourceCode squidSourceFile : squidSourceFiles) {
            SourceFile squidFile = (SourceFile) squidSourceFile;
            String relativePath = pathResolver.relativePath(context.fileSystem().baseDir(), new java.io.File(squidFile.getKey()));
            InputFile inputFile = context.fileSystem().inputFile(context.fileSystem().predicates().hasRelativePath(relativePath));

            saveIssues(inputFile, squidFile);
        }
    }

    private void saveIssues(InputFile inputFile, SourceFile squidFile) {
        Collection<CheckMessage> messages = squidFile.getCheckMessages();

        if (inputFile != null) {
            for (CheckMessage message : messages) {
                RuleKey ruleKey = checks.ruleKey((SquidCheck<JavaGrammar>) message.getCheck());
                NewIssue issue = context.newIssue()
                        .forRule(ruleKey);
                NewIssueLocation dil = new DefaultIssueLocation()
                        .on(inputFile)
                        .at(inputFile.selectLine(message.getLine()))
                        .message(message.getText(Locale.ENGLISH));
                issue.at(dil);
                if (message.getCost() != null) {
                    issue.gap(message.getCost());
                }
                issue.save();
            }
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor
                .onlyOnLanguage("java")
                .name("Java Infer");
    }

    @Override
    public void execute(SensorContext context) {
        FilePredicate hasJava = context.fileSystem().predicates().hasLanguage("java");
        FilePredicate isMain = context.fileSystem().predicates().hasType(InputFile.Type.MAIN);
        FilePredicate and = context.fileSystem().predicates().and(hasJava, isMain);
        List<File> files = new ArrayList<>();
        for(InputFile inf : context.fileSystem().inputFiles(and)) {
            File file = new File(inf.filename());
            files.add(file);
        }

        List<SquidAstVisitor<JavaGrammar>> visitors = new ArrayList<>(checks.all());
        scanner = JavaAstScanner.create(createConfiguration(), visitors.toArray(new SquidAstVisitor[visitors.size()]));
        scanner.scanFiles(files);

        Collection<SourceCode> squidSourceFiles = scanner.getIndex().search(new QueryByType(SourceFile.class));
        save(squidSourceFiles);
    }

}
