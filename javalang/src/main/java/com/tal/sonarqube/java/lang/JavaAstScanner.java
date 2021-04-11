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
package com.tal.sonarqube.java.lang;

import com.sonar.sslr.impl.Parser;
import com.tal.sonarqube.java.lang.api.JavaGrammar;
import com.tal.sonarqube.java.lang.api.JavaMetric;
import com.tal.sonarqube.java.lang.parser.JavaParser;
import org.sonar.squidbridge.AstScanner;
import org.sonar.squidbridge.CommentAnalyser;
import org.sonar.squidbridge.SquidAstVisitor;
import org.sonar.squidbridge.SquidAstVisitorContextImpl;
import org.sonar.squidbridge.api.SourceCode;
import org.sonar.squidbridge.api.SourceFile;
import org.sonar.squidbridge.api.SourceProject;
import org.sonar.squidbridge.indexer.QueryByType;
import org.sonar.squidbridge.metrics.CommentsVisitor;
import org.sonar.squidbridge.metrics.LinesOfCodeVisitor;
import org.sonar.squidbridge.metrics.LinesVisitor;

import java.io.File;
import java.util.Collection;

public class JavaAstScanner {

    private JavaAstScanner() {
    }

    /**
     * Helper method for testing checks without having to deploy them on a Sonar instance.
     */
    public static SourceFile scanSingleFile(File file, SquidAstVisitor<JavaGrammar>... visitors) {
        if (!file.isFile()) {
            throw new IllegalArgumentException("File '" + file + "' not found.");
        }
        AstScanner<JavaGrammar> scanner = create(new JavaConfiguration(), visitors);
        scanner.scanFile(file);
        Collection<SourceCode> sources = scanner.getIndex().search(new QueryByType(SourceFile.class));
        if (sources.size() != 1) {
            throw new IllegalStateException("Only one SourceFile was expected whereas " + sources.size() + " has been returned.");
        }
        return (SourceFile) sources.iterator().next();
    }

    public static AstScanner<JavaGrammar> create(JavaConfiguration conf, SquidAstVisitor<JavaGrammar>... visitors) {
        final SquidAstVisitorContextImpl<JavaGrammar> context = new SquidAstVisitorContextImpl<JavaGrammar>(new SourceProject("Java Project"));
        final Parser<JavaGrammar> parser = JavaParser.create(conf);

        AstScanner.Builder<JavaGrammar> builder = AstScanner.<JavaGrammar>builder(context).setBaseParser(parser);

        /* Metrics */
        builder.withMetrics(JavaMetric.values());

        /* Comments */
        builder.setCommentAnalyser(
                new CommentAnalyser() {
                    @Override
                    public boolean isBlank(String line) {
                        for (int i = 0; i < line.length(); i++) {
                            if (Character.isLetterOrDigit(line.charAt(i))) {
                                return false;
                            }
                        }
                        return true;
                    }

                    @Override
                    public String getContents(String comment) {
                        return comment.startsWith("//") ? comment.substring(2) : comment.substring(2, comment.length() - 2);
                    }
                });

        /* Files */
        builder.setFilesMetric(JavaMetric.FILES);
        if(visitors != null && visitors.length > 0) {
            for (SquidAstVisitor<JavaGrammar> sv : visitors) {
                builder.withSquidAstVisitor(sv);
            }
        } else {
            /* Metrics */
            builder.withSquidAstVisitor(new LinesVisitor(JavaMetric.LINES));
            builder.withSquidAstVisitor(new LinesOfCodeVisitor(JavaMetric.LINES_OF_CODE));
            builder.withSquidAstVisitor(CommentsVisitor.<JavaGrammar>builder().withCommentMetric(JavaMetric.COMMENT_LINES)
                .withNoSonar(true)
                .build());
        }
        return builder.build();
    }

}
