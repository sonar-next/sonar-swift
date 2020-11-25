package com.backelite.sonarqube.objectivec.issues.infer;

import com.backelite.sonarqube.objectivec.lang.core.ObjectiveC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.ActiveRule;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;
import org.sonar.api.utils.ValidationMessages;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author wuwenguang magaofei
 * @date 2020/10/27
 * infer
 */
public class InferProfile implements BuiltInQualityProfilesDefinition {

    private static final Logger logger = LoggerFactory.getLogger(InferProfile.class);

    public static final String PROFILE_PATH = "/org/sonar/plugins/infer/profile-infer.xml";

    private final InferProfileImporter profileImporter;

    public InferProfile(final InferProfileImporter profileImporter) {
        this.profileImporter = profileImporter;
    }

    @Override
    public void define(Context context) {
        logger.info("Creating Infer Profile");
        NewBuiltInQualityProfile nbiqp = context.createBuiltInQualityProfile(InferRulesDefinition.REPOSITORY_KEY, ObjectiveC.KEY);

        try(Reader config = new InputStreamReader(getClass().getResourceAsStream(InferProfile.PROFILE_PATH))) {
            RulesProfile ocLintRulesProfile = profileImporter.importProfile(config, ValidationMessages.create());
            for (ActiveRule rule : ocLintRulesProfile.getActiveRules()) {
                nbiqp.activateRule(rule.getRepositoryKey(), rule.getRuleKey());
            }
        } catch (IOException ex){
            logger.error("Error Creating Infer Profile",ex);
        }
        nbiqp.done();
    }
}
