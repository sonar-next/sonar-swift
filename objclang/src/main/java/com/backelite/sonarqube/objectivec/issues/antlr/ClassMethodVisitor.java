package com.backelite.sonarqube.objectivec.issues.antlr;

import com.backelite.sonarqube.objectivec.internal.ObjectiveCParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.sensor.SensorContext;

public class ClassMethodVisitor implements ParseTreeItemVisitor {

    private static final Logger logger = LoggerFactory.getLogger(ClassMethodVisitor.class);

    @Override
    public void apply(ParseTree tree) {
        logger.info("apply {}", tree.getText());
    }

    @Override
    public void fillContext(SensorContext context, AntlrContext antlrContext) {
        logger.info("fill {}", antlrContext.getRoot());
    }


//    @Override
//    public Object visitTranslationUnit(ObjectiveCParser.TranslationUnitContext ctx) {
//        logger.info("visitTranslationUnit {}", ctx.getText());
//        return super.visitTranslationUnit(ctx);
//    }
//
//    @Override
//    public Object visitMethodDeclaration(ObjectiveCParser.MethodDeclarationContext ctx) {
//        logger.info("visitMethodDeclaration {}", ctx.getText());
//        return super.visitMethodDeclaration(ctx);
//    }
//
//    @Override
//    public Object visitClassMethodDefinition(ObjectiveCParser.ClassMethodDefinitionContext ctx) {
//        logger.info("visitClassMethodDefinition {}", ctx.getText());
//        return super.visitClassMethodDefinition(ctx);
//    }

}
