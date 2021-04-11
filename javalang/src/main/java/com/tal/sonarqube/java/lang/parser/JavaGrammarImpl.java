package com.tal.sonarqube.java.lang.parser;

import com.tal.sonarqube.java.lang.api.JavaGrammar;

import static com.sonar.sslr.api.GenericTokenType.EOF;
import static com.sonar.sslr.api.GenericTokenType.LITERAL;
import static com.sonar.sslr.impl.matcher.GrammarFunctions.Standard.o2n;

public class JavaGrammarImpl extends JavaGrammar {

    public JavaGrammarImpl() {

        program.is(o2n(LITERAL), EOF);

    }

}
