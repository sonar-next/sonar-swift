//package com.backelite.sonarqube.swift.cpd;
//
//import com.backelite.sonarqube.swift.lang.core.Swift;
//import net.sourceforge.pmd.cpd.Tokenizer;
//import org.sonar.api.batch.AbstractCpdMapping;
//import org.sonar.api.batch.fs.FileSystem;
//import org.sonar.api.resources.Language;
//
//import java.nio.charset.Charset;
//
///**
// * @author magaofei
// * @date 2021/4/5
// */
//public class SwiftCpdMapping extends AbstractCpdMapping {
//
//    private final Swift language;
//    private final Charset charset;
//
//    public SwiftCpdMapping(Swift language, FileSystem fileSystem) {
//        this.language = language;
//        this.charset = fileSystem.encoding();
//    }
//
//    public Tokenizer getTokenizer() {
//        return new SwiftTokenizer(charset);
//    }
//
//    public Language getLanguage() {
//        return language;
//    }
//}