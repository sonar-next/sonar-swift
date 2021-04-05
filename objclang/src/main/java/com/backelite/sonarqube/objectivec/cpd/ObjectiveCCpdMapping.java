package com.backelite.sonarqube.objectivec.cpd;

import com.backelite.sonarqube.objectivec.lang.core.ObjectiveC;
import net.sourceforge.pmd.cpd.Tokenizer;
import org.sonar.api.batch.AbstractCpdMapping;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.resources.Language;

import java.nio.charset.Charset;

/**
 * @author magaofei
 * @date 2021/4/5
 */
public class ObjectiveCCpdMapping extends AbstractCpdMapping {

    private final ObjectiveC language;
    private final Charset charset;

    public ObjectiveCCpdMapping(ObjectiveC language, FileSystem fs) {
        this.language = language;
        this.charset = fs.encoding();
    }

    public Tokenizer getTokenizer() {
        return new ObjectiveCTokenizer(charset);
    }

    public Language getLanguage() {
        return language;
    }

}
