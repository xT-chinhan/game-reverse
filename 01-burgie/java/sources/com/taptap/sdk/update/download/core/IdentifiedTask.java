package com.taptap.sdk.update.download.core;

import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public abstract class IdentifiedTask {
    public static final File EMPTY_FILE = new File("");
    public static final String EMPTY_URL = "";

    public abstract String getFilename();

    public abstract int getId();

    public abstract File getParentFile();

    protected abstract File getProvidedPathFile();

    public abstract String getUrl();

    public boolean compareIgnoreId(IdentifiedTask another) {
        if (getProvidedPathFile().equals(another.getProvidedPathFile())) {
            return true;
        }
        if (!getParentFile().equals(another.getParentFile())) {
            return false;
        }
        String filename = getFilename();
        String anotherFilename = another.getFilename();
        return (anotherFilename == null || filename == null || !anotherFilename.equals(filename)) ? false : true;
    }
}
