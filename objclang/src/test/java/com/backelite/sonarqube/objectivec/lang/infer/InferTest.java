package com.backelite.sonarqube.objectivec.lang.infer;

import com.backelite.sonarqube.objectivec.issues.infer.InferRulesDefinition;
import org.junit.Test;
import org.sonar.api.SonarQubeSide;
import org.sonar.api.SonarRuntime;
import org.sonar.api.internal.SonarRuntimeImpl;
import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.api.utils.Version;

/**
 * @author Harry
 * @date 2020/10/28
 */
public class InferTest {

    @Test
    public void define() {
        SonarRuntime sonarRuntime = SonarRuntimeImpl.forSonarQube(Version.create(7, 3), SonarQubeSide.SERVER);
        InferRulesDefinition rulesDefinition = new InferRulesDefinition(sonarRuntime);
        RulesDefinition.Context context = new RulesDefinition.Context();
        rulesDefinition.define(context);

        RulesDefinition.Repository inferRepository = context.repository("Infer");
        System.out.println(inferRepository.toString());
    }
}
