package com.google.gson.util;

/* JADX INFO: loaded from: classes2.dex */
public class VersionUtils {
    private static final int majorJavaVersion = determineMajorJavaVersion();

    private static int determineMajorJavaVersion() {
        String[] strArrSplit = System.getProperty("java.version").split("[._]");
        int i = Integer.parseInt(strArrSplit[0]);
        return (i != 1 || strArrSplit.length <= 1) ? i : Integer.parseInt(strArrSplit[1]);
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }

    public static boolean isJava9OrLater() {
        return majorJavaVersion >= 9;
    }
}
