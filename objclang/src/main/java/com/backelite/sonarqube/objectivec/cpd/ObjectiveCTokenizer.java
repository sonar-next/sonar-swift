package com.backelite.sonarqube.objectivec.cpd;

import com.backelite.sonarqube.objectivec.lang.ObjectiveCConfiguration;
import com.backelite.sonarqube.objectivec.lang.lexer.ObjectiveCLexer;
import com.sonar.sslr.api.Token;
import com.sonar.sslr.impl.Lexer;
import net.sourceforge.pmd.cpd.SourceCode;
import net.sourceforge.pmd.cpd.TokenEntry;
import net.sourceforge.pmd.cpd.Tokenizer;
import net.sourceforge.pmd.cpd.Tokens;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author magaofei
 * @date 2021/4/5
 */
public class ObjectiveCTokenizer implements Tokenizer {

    private final Charset charset;

    public ObjectiveCTokenizer(Charset charset) {
        this.charset = charset;
    }

    public void tokenize(SourceCode source, Tokens cpdTokens) throws IOException {
        Lexer lexer = ObjectiveCLexer.create(new ObjectiveCConfiguration(charset));
        String fileName = source.getFileName();
        List<Token> tokens = lexer.lex(new File(fileName));
        for (Token token : tokens) {
            TokenEntry cpdToken = new TokenEntry(getTokenImage(token), fileName, token.getLine());
            cpdTokens.add(cpdToken);
        }
        cpdTokens.add(TokenEntry.getEOF());
    }

    private String getTokenImage(Token token) {
        return token.getValue();
    }

}
