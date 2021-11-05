package com.backelite.sonarqube.objectivec.lang.lexer;

import com.backelite.sonarqube.objectivec.internal.ObjectiveCLexer;
import com.backelite.sonarqube.objectivec.internal.ObjectiveCParser;
import com.backelite.sonarqube.objectivec.issues.antlr.AntlrContext;
import com.backelite.sonarqube.objectivec.issues.antlr.AntlrUtils;
import com.backelite.sonarqube.objectivec.issues.antlr.rule.CustomTreeVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class AntlrVisitTest {

    @Test
    public void visit() throws IOException {

        final CharStream charStream = CharStreams.fromStream(Objects.requireNonNull(this.getClass().getResourceAsStream("/NetworkRequest.m")));
        final ObjectiveCLexer lexer = new ObjectiveCLexer(charStream);
        lexer.removeErrorListeners();
        final CommonTokenStream stream = new CommonTokenStream(lexer);
        stream.fill();
        final ObjectiveCParser parser = new ObjectiveCParser(stream);
        parser.removeErrorListeners();
        final ParseTree root = parser.translationUnit();
        CustomTreeVisitor customTreeVisitor = new CustomTreeVisitor(null);
        customTreeVisitor.visit(root);
        AntlrContext antlrContext = AntlrUtils.getRequest(IOUtils.toString(Objects.requireNonNull(this.getClass().getResourceAsStream("/NetworkRequest.m")), StandardCharsets.UTF_8));
//        customTreeVisitor.fillContext(null, antlrContext);
    }
}
