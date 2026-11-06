package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
class SecurityChecker {
    private static final String FILE_NAME_SUFFIX = ".apk";

    SecurityChecker() {
    }

    public static boolean checkFileValid(File file) {
        return file != null && file.exists() && file.length() > 0 && file.getName().endsWith(FILE_NAME_SUFFIX);
    }

    public static boolean checkMd5(File file, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(SecurityUtils.getFileMD5(file).toLowerCase());
    }
}
