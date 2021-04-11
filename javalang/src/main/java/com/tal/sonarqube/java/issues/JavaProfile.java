package com.tal.sonarqube.java.issues;

import com.tal.sonarqube.java.issues.infer.InferProfile;
import com.tal.sonarqube.java.issues.infer.InferProfileImporter;
import com.tal.sonarqube.java.lang.core.Java;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class JavaProfile implements BuiltInQualityProfilesDefinition {
    private static final Logger LOGGER = LoggerFactory.getLogger(JavaProfile.class);
    private final InferProfileImporter inferProfileImporter;

    public JavaProfile(final InferProfileImporter inferProfileImporter) {
        this.inferProfileImporter = inferProfileImporter;
    }

    @Override
    public void define(Context context) {
        LOGGER.info("Creating Java Profile");

        NewBuiltInQualityProfile nbiqp = context.createBuiltInQualityProfile("Java", Java.KEY);
        nbiqp.setDefault(true);

        try (Reader config = new InputStreamReader(getClass().getResourceAsStream(InferProfile.PROFILE_PATH))) {
            RulesProfile inferPasRulesProfile = inferProfileImporter.importProfile(config, ValidationMessages.create());
            for (ActiveRule rule : inferPasRulesProfile.getActiveRules()) {
                nbiqp.activateRule(rule.getRepositoryKey(), rule.getRuleKey());
            }
        } catch (IOException ex) {
            LOGGER.error("Error Creating Java Profile", ex);
        }
        nbiqp.done();
    }
}
