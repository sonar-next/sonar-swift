package com.backelite.sonarqube.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.sonar.api.utils.WildcardPattern;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScanner {

    private final File baseDir;
    private final WildcardPattern pattern;

    public DirectoryScanner(File baseDir, WildcardPattern pattern) {
        this.baseDir = baseDir;
        this.pattern = pattern;
    }

    public List<File> getIncludedFiles() {
        final String baseDirAbsolutePath = baseDir.getAbsolutePath();
        IOFileFilter fileFilter = new IOFileFilter() {

            @Override
            public boolean accept(File dir, String name) {
                return accept(new File(dir, name));
            }

            @Override
            public boolean accept(File file) {
                String path = file.getAbsolutePath();
                path = path.substring(Math.min(baseDirAbsolutePath.length(), path.length()));
                return pattern.match(FilenameUtils.separatorsToUnix(path));
            }
        };
        return new ArrayList<>(FileUtils.listFiles(baseDir, fileFilter, TrueFileFilter.INSTANCE));
    }

}
