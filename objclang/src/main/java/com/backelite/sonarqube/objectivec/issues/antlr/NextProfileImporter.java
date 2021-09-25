package com.backelite.sonarqube.objectivec.issues.antlr;

import com.backelite.sonarqube.objectivec.issues.infer.InferRulesDefinition;
import com.backelite.sonarqube.objectivec.lang.core.ObjectiveC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.profiles.ProfileImporter;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.utils.ValidationMessages;

import java.io.Reader;

/**
 * @author
 * @date 2020/10/27
 */
public class NextProfileImporter extends ProfileImporter {

    private static final Logger logger = LoggerFactory.getLogger(NextProfileImporter.class);

    private static final String UNABLE_TO_LOAD_DEFAULT_PROFILE = "Unable to load default next profile";

    private final XMLProfileParser profileParser;

    public NextProfileImporter(final XMLProfileParser xmlProfileParser) {
        super(InferRulesDefinition.REPOSITORY_KEY, InferRulesDefinition.REPOSITORY_KEY);
        setSupportedLanguages(ObjectiveC.KEY);
        profileParser = xmlProfileParser;
    }

    @Override
    public RulesProfile importProfile(Reader reader, ValidationMessages messages) {
        final RulesProfile profile = profileParser.parse(reader, messages);

        if (null == profile) {
            messages.addErrorText(UNABLE_TO_LOAD_DEFAULT_PROFILE);
            logger.error(UNABLE_TO_LOAD_DEFAULT_PROFILE);
        }
        return profile;
    }
}
