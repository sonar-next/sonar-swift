package com.backelite.sonarqube.objectivec.issues.infer;

import com.backelite.sonarqube.commons.Constants;
import com.backelite.sonarqube.objectivec.issues.fauxpas.FauxPasReportParser;
import com.backelite.sonarqube.objectivec.lang.core.ObjectiveC;
import org.apache.tools.ant.DirectoryScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.Sensor;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.SensorDescriptor;

import java.io.File;

/**
 * @author Harry
 * @date 2020/10/27
 */
public class InferSensor implements Sensor {

    private static final Logger logger = LoggerFactory.getLogger(InferSensor.class);
    public static final String REPORT_PATH_KEY = Constants.PROPERTY_PREFIX + ".infer.report";
    public static final String DEFAULT_REPORT_PATH = "sonar-reports/*infer_report.json";

    private final SensorContext context;

    public InferSensor(SensorContext context) {
        this.context = context;
    }

    @Override
    public void describe(SensorDescriptor descriptor) {
        descriptor
                .onlyOnLanguage(ObjectiveC.KEY)
                .name("Infer")
                .onlyOnFileType(InputFile.Type.MAIN);
    }

    @Override
    public void execute(SensorContext context) {
        final String projectBaseDir = context.fileSystem().baseDir().getAbsolutePath();

        InferReportParser parser = new InferReportParser(context);
        parseReportIn(projectBaseDir, parser);
    }


    private void parseReportIn(final String baseDir, final InferReportParser parser) {
        DirectoryScanner scanner = new DirectoryScanner();
        scanner.setIncludes(new String[]{reportPath()});
        scanner.setBasedir(baseDir);
        scanner.setCaseSensitive(false);
        scanner.scan();
        String[] files = scanner.getIncludedFiles();

        for (String filename : files) {
            logger.info("Processing Infer report {}", filename);
            parser.parseReport(new File(filename));
        }
    }

    private String reportPath() {
        return context.config()
                .get(REPORT_PATH_KEY)
                .orElse(DEFAULT_REPORT_PATH);
    }

}
