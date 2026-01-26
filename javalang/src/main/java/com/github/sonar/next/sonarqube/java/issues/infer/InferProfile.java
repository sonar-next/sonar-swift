package com.github.sonar.next.sonarqube.java.issues.infer;

import com.backelite.sonarqube.commons.profile.XmlProfileRulesParser;
import com.backelite.sonarqube.commons.profile.XmlProfileRulesParser.ProfileRule;
import com.github.sonar.next.sonarqube.java.lang.core.Java;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author magaofei
 * @date 2021/04/11
 * infer
 */
public class InferProfile implements BuiltInQualityProfilesDefinition {

    private static final Logger logger = LoggerFactory.getLogger(InferProfile.class);

    public static final String PROFILE_PATH = "/org/sonar/plugins/infer/java-profile-infer.xml";

    @Override
    public void define(Context context) {
        logger.info("Creating Infer Java Profile");
        NewBuiltInQualityProfile nbiqp = context.createBuiltInQualityProfile(InferRulesDefinition.REPOSITORY_KEY, Java.KEY);

        try (InputStream config = getClass().getResourceAsStream(InferProfile.PROFILE_PATH)) {
            if (config == null) {
                logger.error("Missing Infer Java profile resource: {}", InferProfile.PROFILE_PATH);
            } else {
                List<ProfileRule> rules = XmlProfileRulesParser.parse(config);
                for (ProfileRule rule : rules) {
                    nbiqp.activateRule(rule.getRepositoryKey(), rule.getRuleKey());
                }
            }
        } catch (IOException ex) {
            logger.error("Error Creating Infer Profile", ex);
        }
        nbiqp.done();
    }
}
