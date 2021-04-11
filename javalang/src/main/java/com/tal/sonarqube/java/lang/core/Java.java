package com.tal.sonarqube.java.lang.core;

import org.sonar.api.resources.AbstractLanguage;

public class Java extends AbstractLanguage  {
    public static final String KEY = "java";

    public Java(String key) {
        super(key);
    }

    public Java(String key, String name) {
        super(key, name);
    }


    @Override
    public String[] getFileSuffixes() {
        return new String[0];
    }
}
