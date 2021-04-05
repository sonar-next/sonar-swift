package com.backelite.sonarqube.commons;

import com.sonar.sslr.api.Token;

/**
 * @author magaofei
 * @date 2021/4/5
 */
public class TokenLocation {

    private final int startLine;
    private final int startCharacter;
    private final int endLine;
    private final int endCharacter;

    public TokenLocation(Token token) {
        this.startLine = token.getLine();
        this.startCharacter = token.getColumn();
        final String[] lines = token.getOriginalValue().split("\r\n|\n|\r", -1);
        if (lines.length > 1) {
            this.endLine = token.getLine() + lines.length - 1;
            this.endCharacter = lines[lines.length - 1].length();
        } else {
            this.endLine = startLine;
            this.endCharacter = startCharacter + token.getOriginalValue().length();
        }
    }

    public int startLine() {
        return startLine;
    }

    public int startCharacter() {
        return startCharacter;
    }

    public int endLine() {
        return endLine;
    }

    public int endCharacter() {
        return endCharacter;
    }

}
