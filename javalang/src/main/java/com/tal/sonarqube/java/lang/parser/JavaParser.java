/**
 * Swift SonarQube Plugin - Objective-C module - Enables analysis of Swift and Objective-C projects into SonarQube.
 * Copyright © 2015 Backelite (${email})
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.tal.sonarqube.java.lang.parser;

import com.sonar.sslr.impl.Parser;
import com.tal.sonarqube.java.lang.JavaConfiguration;
import com.tal.sonarqube.java.lang.api.JavaGrammar;

public class JavaParser {

    private JavaParser() {
    }

    public static Parser<JavaGrammar> create() {
        return create(new JavaConfiguration());
    }

    public static Parser<JavaGrammar> create(JavaConfiguration conf) {
        return Parser.builder((JavaGrammar) new JavaGrammarImpl())
//                .withLexer(ObjectiveCLexer.create(conf))
                .build();
    }

}
