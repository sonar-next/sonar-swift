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
package com.backelite.sonarqube.objectivec.issues;

import com.backelite.sonarqube.commons.profile.XmlProfileRulesParser;
import com.backelite.sonarqube.commons.profile.XmlProfileRulesParser.ProfileRule;
import com.backelite.sonarqube.objectivec.issues.fauxpas.FauxPasProfile;
import com.backelite.sonarqube.objectivec.issues.infer.InferProfile;
import com.backelite.sonarqube.objectivec.issues.oclint.OCLintProfile;
import com.backelite.sonarqube.objectivec.lang.core.ObjectiveC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.server.profile.BuiltInQualityProfilesDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ObjectiveCProfile implements BuiltInQualityProfilesDefinition {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectiveCProfile.class);

    @Override
    public void define(Context context) {
        LOGGER.info("Creating Objective-C Profile");

        NewBuiltInQualityProfile nbiqp = context.createBuiltInQualityProfile("Objective-C", ObjectiveC.KEY);
        nbiqp.setDefault(true);

        try (InputStream config = getClass().getResourceAsStream(OCLintProfile.PROFILE_PATH)) {
            if (config == null) {
                LOGGER.error("Missing OCLint profile resource: {}", OCLintProfile.PROFILE_PATH);
            } else {
                List<ProfileRule> rules = XmlProfileRulesParser.parse(config);
                for (ProfileRule rule : rules) {
                    nbiqp.activateRule(rule.getRepositoryKey(), rule.getRuleKey());
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Error Creating Objective-C Profile", ex);
        }

        try (InputStream config = getClass().getResourceAsStream(FauxPasProfile.PROFILE_PATH)) {
            if (config == null) {
                LOGGER.error("Missing FauxPas profile resource: {}", FauxPasProfile.PROFILE_PATH);
            } else {
                List<ProfileRule> rules = XmlProfileRulesParser.parse(config);
                for (ProfileRule rule : rules) {
                    nbiqp.activateRule(rule.getRepositoryKey(), rule.getRuleKey());
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Error Creating Objective-C Profile", ex);
        }

        try (InputStream config = getClass().getResourceAsStream(InferProfile.PROFILE_PATH)) {
            if (config == null) {
                LOGGER.error("Missing Infer profile resource: {}", InferProfile.PROFILE_PATH);
            } else {
                List<ProfileRule> rules = XmlProfileRulesParser.parse(config);
                for (ProfileRule rule : rules) {
                    nbiqp.activateRule(rule.getRepositoryKey(), rule.getRuleKey());
                }
            }
        } catch (IOException ex) {
            LOGGER.error("Error Creating Objective-C Profile", ex);
        }
        nbiqp.done();
    }
}
