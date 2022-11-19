package com.backelite.sonarqube.objectivec.issues.infer;

import com.backelite.sonarqube.objectivec.lang.core.ObjectiveC;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.SonarRuntime;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * @author wuwenguang magaofei
 * @date 2020/10/27
 */
public class InferRulesDefinition implements RulesDefinition {

    private static final Logger logger = LoggerFactory.getLogger(InferRulesDefinition.class);
    public static final String REPOSITORY_KEY = "Infer";
    public static final String REPOSITORY_NAME = REPOSITORY_KEY;
    private static final String RULES_FILE = "/org/sonar/plugins/infer/rules.json";

    private final SonarRuntime sonarRuntime;
    public InferRulesDefinition(SonarRuntime sonarRuntime) {
        this.sonarRuntime = sonarRuntime;
    }

    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository(REPOSITORY_KEY, ObjectiveC.KEY).setName(REPOSITORY_NAME);
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream(RULES_FILE), StandardCharsets.UTF_8)) {
            JSONArray slRules = (JSONArray) JSONValue.parse(reader);
            if (slRules != null) {
                for (Object obj : slRules) {
                    JSONObject slRule = (JSONObject) obj;
                    RuleType ruleType = Optional.of(RuleType.valueOf((String) slRule.get("type"))).orElse(RuleType.CODE_SMELL);
                    NewRule newRule = repository.createRule((String) slRule.get("key"))
                            .setName((String) slRule.get("name"))
                            .setType(ruleType)
                            .setSeverity((String) slRule.get("severity"))
                            .setHtmlDescription((String) slRule.get("description"));
                    newRule.setDebtRemediationFunction(
                        newRule.debtRemediationFunctions().constantPerIssue("10min"));
                }
            }
        } catch (IOException e) {
            logger.error("Failed to load infer rules", e);
        }

        repository.done();

    }
}
