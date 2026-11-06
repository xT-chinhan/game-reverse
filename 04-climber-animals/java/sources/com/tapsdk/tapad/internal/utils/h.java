package com.tapsdk.tapad.internal.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    public static Intent a(Context context, String str) throws Exception {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("packageName is null!");
        }
        try {
            return context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public static Intent a(Uri uri) {
        if (uri == null) {
            throw new IllegalArgumentException("fileUri is illegal!");
        }
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setFlags(268435457);
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        return intent;
    }

    public static Uri a(Context context, File file) {
        if (context != null) {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".com.tds.ad.fileprovider", file);
        }
        return null;
    }
}
