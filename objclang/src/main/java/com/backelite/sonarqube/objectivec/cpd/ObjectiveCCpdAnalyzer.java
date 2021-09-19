package com.backelite.sonarqube.objectivec.cpd;

import com.backelite.sonarqube.commons.TokenLocation;
import com.backelite.sonarqube.objectivec.lang.api.ObjectiveCKeyword;
import com.google.common.collect.Sets;
import com.sonar.sslr.api.*;
import com.sonar.sslr.impl.Lexer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.sensor.SensorContext;
import org.sonar.api.batch.sensor.cpd.NewCpdTokens;

import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/**
 * @author magaofei
 * @date 2021/4/5
 */
public class ObjectiveCCpdAnalyzer {

    private static final Logger logger = LoggerFactory.getLogger(ObjectiveCCpdAnalyzer.class);

    private final SensorContext context;
    private final Lexer lexer;

    public ObjectiveCCpdAnalyzer(SensorContext context, Lexer lexer) {
        this.context = context;
        this.lexer = lexer;
    }

    public void pushCpdTokens(InputFile inputFile) {
//        NewHighlighting highlighting = context.newHighlighting();

        File file = inputFile.file();
//        highlighting.onFile(inputFile);

        // not support .h file
        if (inputFile.filename().endsWith(".h") || inputFile.filename().endsWith(".mm")) {
            return;
        }

        NewCpdTokens cpdTokens = context.newCpdTokens();
        cpdTokens.onFile(inputFile);

        Iterator<Token> iterator = lexer.lex(file).iterator();

        while (iterator.hasNext()) {
            Token token = iterator.next();
            TokenType tokenType = token.getType();

            if (!tokenType.equals(GenericTokenType.EOF)) {
                TokenLocation tokenLocation = new TokenLocation(token);
                cpdTokens.addToken(tokenLocation.startLine(), tokenLocation.startCharacter(), tokenLocation.endLine(), tokenLocation.endCharacter(), token.getValue());
            }
//            if (tokenType.equals(GenericTokenType.LITERAL)) {
//                highlight(highlighting, token, TypeOfText.STRING);
//            } else if (KEYWORDS.contains(tokenType)) {
//                highlight(highlighting, token, TypeOfText.KEYWORD);
//            }
//            for (Trivia trivia : token.getTrivia()) {
//                highlight(highlighting, trivia.getToken(), TypeOfText.COMMENT);
//            }
        }

//        highlighting.save();
        cpdTokens.save();
    }

//    private static void highlight(NewHighlighting highlighting, Token token, TypeOfText typeOfText) {
//        TokenLocation tokenLocation = new TokenLocation(token);
//        highlighting.highlight(tokenLocation.startLine(), tokenLocation.startCharacter(), tokenLocation.endLine(), tokenLocation.endCharacter(), typeOfText);
//    }

}
