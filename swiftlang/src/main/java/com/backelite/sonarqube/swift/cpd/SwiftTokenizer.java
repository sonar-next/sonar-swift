//package com.backelite.sonarqube.swift.cpd;
//
//import com.backelite.sonarqube.swift.lang.SwiftConfiguration;
//import com.backelite.sonarqube.swift.lang.lexer.SwiftLexer;
//import com.sonar.sslr.api.Token;
//import com.sonar.sslr.impl.Lexer;
//import net.sourceforge.pmd.cpd.SourceCode;
//import net.sourceforge.pmd.cpd.TokenEntry;
//import net.sourceforge.pmd.cpd.Tokenizer;
//import net.sourceforge.pmd.cpd.Tokens;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.List;
///**
// * @author magaofei
// * @date 2021/4/5
// */
//public class SwiftTokenizer implements Tokenizer {
//
//    private final Charset charset;
//
//    public SwiftTokenizer(Charset charset) {
//        this.charset = charset;
//    }
//
//    public void tokenize(SourceCode source, Tokens cpdTokens) throws IOException {
//
//        Lexer lexer = SwiftLexer.create(new SwiftConfiguration(charset));
//        String fileName = source.getFileName();
//        List<Token> tokens = lexer.lex(new File(fileName));
//        for (Token token : tokens) {
//            TokenEntry cpdToken = new TokenEntry(getTokenImage(token), fileName, token.getLine());
//            cpdTokens.add(cpdToken);
//        }
//        cpdTokens.add(TokenEntry.getEOF());
//    }
//
//    private String getTokenImage(Token token) {
//        return token.getValue();
//    }
//}