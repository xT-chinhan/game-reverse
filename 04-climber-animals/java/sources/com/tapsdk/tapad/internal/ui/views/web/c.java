package com.tapsdk.tapad.internal.ui.views.web;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static volatile c c;
    private String a = "WebDownloadConfig";
    String b = "";

    private c(Context context) {
        b(context);
    }

    public static c a(Context context) {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c(context);
                }
            }
        }
        return c;
    }

    private void b(Context context) {
        File externalCacheDir;
        if (TextUtils.isEmpty(this.b)) {
            File externalCacheDir2 = context.getExternalCacheDir();
            Context applicationContext = context.getApplicationContext();
            if (externalCacheDir2 == null) {
                externalCacheDir = applicationContext.getExternalFilesDir(null);
                if (externalCacheDir == null) {
                    return;
                }
            } else {
                externalCacheDir = applicationContext.getExternalCacheDir();
            }
            this.b = externalCacheDir.getAbsolutePath();
        }
    }
}
