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
package com.backelite.sonarqube.objectivec.issues.fauxpas;

import com.backelite.sonarqube.objectivec.lang.core.ObjectiveC;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.server.rule.RulesDefinition;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * Created by gillesgrousset on 18/02/2016.
 */
public class FauxPasRulesDefinition implements RulesDefinition {

    public static final String REPOSITORY_KEY = "FauxPas";
    public static final String REPOSITORY_NAME = REPOSITORY_KEY;
    private static final Logger LOGGER = LoggerFactory.getLogger(FauxPasRulesDefinition.class);
    private static final String RULES_FILE = "/org/sonar/plugins/fauxpas/rules.json";


    @Override
    public void define(final Context context) {
        NewRepository repository = context.createRepository(REPOSITORY_KEY, ObjectiveC.KEY).setName(REPOSITORY_NAME);

        try(Reader reader = new InputStreamReader(getClass().getResourceAsStream(RULES_FILE), Charset.forName("UTF-8"))){
            JSONArray slRules = (JSONArray)JSONValue.parse(reader);
            if(slRules != null){
                for (Object obj : slRules) {
                    JSONObject slRule = (JSONObject) obj;
                    repository.createRule((String) slRule.get("key"))
                        .setName((String) slRule.get("name"))
                        .setSeverity((String) slRule.get("severity"))
                        .setHtmlDescription((String) slRule.get("description"));
                }
            }
        } catch (IOException e) {
            LOGGER.error("Failed to load FauxPas rules", e);
        }
        repository.done();
    }
}
