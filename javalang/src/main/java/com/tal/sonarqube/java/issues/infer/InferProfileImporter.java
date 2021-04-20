package com.tal.sonarqube.java.issues.infer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.profiles.ProfileImporter;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.profiles.XMLProfileParser;
import org.sonar.api.utils.ValidationMessages;

import java.io.Reader;

/**
 * @author magaofei
 * @date 2021/04/11
 */
public class InferProfileImporter extends ProfileImporter {

    private static final Logger logger = LoggerFactory.getLogger(InferProfileImporter.class);

    private static final String UNABLE_TO_LOAD_DEFAULT_PROFILE = "Unable to load default infer profile";

    private final XMLProfileParser profileParser;

    public InferProfileImporter(final XMLProfileParser xmlProfileParser) {
        super(InferRulesDefinition.REPOSITORY_KEY, InferRulesDefinition.REPOSITORY_KEY);
        setSupportedLanguages("java");
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
