package com.backelite.sonarqube.objectivec.issues.antlr;

import com.backelite.sonarqube.objectivec.internal.*;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.sensor.SensorContext;

public class CustomTreeVisitor extends ObjectiveCParserBaseVisitor {

    private static final Logger logger = LoggerFactory.getLogger(CustomTreeVisitor.class);

    private static final int MAX_LENGTH = 12;

    private final SensorContext sensorContext;

    public CustomTreeVisitor(SensorContext sensorContext) {
        this.sensorContext = sensorContext;
    }

    @Override
    public Object visitClassMethodDefinition(ObjectiveCParser.ClassMethodDefinitionContext ctx) {
        logger.debug("visitClassMethodDefinition {}", ctx.getText());
        logger.debug(" length = {}", ctx.getText().split(";").length);
//        String methodName = ctx.methodDefinition().methodSelector().getText();
        return super.visitClassMethodDefinition(ctx);
    }

    static class StatementVisitor extends ObjectiveCParserBaseVisitor {

        private int length = 0;

        @Override
        public Object visitStatement(ObjectiveCParser.StatementContext ctx) {
            length += 1;
            return super.visitStatement(ctx);
        }
    }

    @Override
    public Object visitInstanceMethodDefinition(ObjectiveCParser.InstanceMethodDefinitionContext ctx) {
        StatementVisitor statementVisitor = new StatementVisitor();
        ctx.methodDefinition().accept(statementVisitor);
        int length = statementVisitor.length;
        if (length > MAX_LENGTH) {
            logger.info("report issue {}, methodName = {}", length, ctx.methodDefinition().methodSelector().getText());
        }
//        logger.info(" length = {}", ctx.getText().split(";").length);
        return super.visitInstanceMethodDefinition(ctx);
    }

}
