package com.tal.sonarqube.java.lang;

import org.sonar.squidbridge.api.SquidConfiguration;

import java.nio.charset.Charset;

public class JavaConfiguration extends SquidConfiguration {

    public JavaConfiguration() {
    }

    public JavaConfiguration(Charset charset) {
        super(charset);
    }
}
