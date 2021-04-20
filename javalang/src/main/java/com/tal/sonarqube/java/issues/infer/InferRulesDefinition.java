package com.tal.sonarqube.java.issues.infer;

import com.tal.sonarqube.java.lang.core.Java;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.SonarRuntime;
import org.sonar.api.rules.RuleType;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.squidbridge.rules.SqaleXmlLoader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * @author magaofei
 * @date 2021/04/11
 */
public class InferRulesDefinition implements RulesDefinition {

    private static final Logger logger = LoggerFactory.getLogger(InferRulesDefinition.class);
    public static final String REPOSITORY_KEY = "infer-java";
    public static final String REPOSITORY_NAME = "Infer Java";
    private static final String RULES_FILE = "/org/sonar/plugins/infer/java-rules.json";

    private final SonarRuntime sonarRuntime;
    public InferRulesDefinition(SonarRuntime sonarRuntime) {
        this.sonarRuntime = sonarRuntime;
    }

    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository(REPOSITORY_KEY, Java.KEY).setName(REPOSITORY_NAME);
        try (Reader reader = new InputStreamReader(getClass().getResourceAsStream(RULES_FILE), StandardCharsets.UTF_8)) {
            JSONArray slRules = (JSONArray) JSONValue.parse(reader);
            if (slRules != null) {
                for (Object obj : slRules) {
                    JSONObject slRule = (JSONObject) obj;
                    RuleType ruleType = Optional.of(RuleType.valueOf((String) slRule.get("type"))).orElse(RuleType.CODE_SMELL);
                    repository.createRule((String) slRule.get("key"))
                            .setName((String) slRule.get("name"))
                            .setType(ruleType)
                            .setSeverity((String) slRule.get("severity"))
                            .setHtmlDescription((String) slRule.get("description"));
                }
            }
        } catch (IOException e) {
            logger.error("Failed to load infer rules", e);
        }

        SqaleXmlLoader.load(repository, "/com/sonar/sqale/java-infer-model.xml");
        repository.done();

    }
}
