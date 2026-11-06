package com.anythink.core.common.u;

import android.text.TextUtils;
import android.webkit.URLUtil;
import java.io.File;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class ak {
    private static final String a = "ak";

    private static String a(String str) {
        try {
            return (TextUtils.isEmpty(str) || !URLUtil.isValidUrl(str)) ? str : new URL(str).getPath();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean a(String str, String str2) {
        try {
            File canonicalFile = new File(str).getCanonicalFile();
            File canonicalFile2 = new File(str2).getCanonicalFile();
            if (canonicalFile.exists() && canonicalFile2.exists()) {
                return canonicalFile.getPath().startsWith(canonicalFile2.getPath());
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
