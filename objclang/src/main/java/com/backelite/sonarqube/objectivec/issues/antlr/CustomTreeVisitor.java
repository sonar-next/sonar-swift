package com.backelite.sonarqube.objectivec.issues.antlr;

import com.backelite.sonarqube.objectivec.internal.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomTreeVisitor extends ObjectiveCParserBaseVisitor {

    private static final Logger logger = LoggerFactory.getLogger(CustomTreeVisitor.class);

    @Override
    public Object visitTranslationUnit(ObjectiveCParser.TranslationUnitContext ctx) {
        logger.info("visitTranslationUnit {}", ctx.getText());
        return super.visitTranslationUnit(ctx);
    }

    @Override
    public Object visitMethodDeclaration(ObjectiveCParser.MethodDeclarationContext ctx) {
        logger.info("visitMethodDeclaration {}", ctx.getText());
        return super.visitMethodDeclaration(ctx);
    }

    @Override
    public Object visitClassMethodDefinition(ObjectiveCParser.ClassMethodDefinitionContext ctx) {
        logger.info("visitClassMethodDefinition {}", ctx.getText());
        return super.visitClassMethodDefinition(ctx);
    }
}
