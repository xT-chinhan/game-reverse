package com.mcto.sspsdk.internal;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ij {
    public static File a(Context context) {
        if (context == null) {
            return null;
        }
        return new File(context.getExternalFilesDir(null), ".issp_apk");
    }

    public static File b(Context context) {
        return new File(context.getExternalCacheDir(), ".issp_font");
    }

    public static File c(Context context) {
        return new File(context.getExternalCacheDir(), ".issp_image");
    }
}
