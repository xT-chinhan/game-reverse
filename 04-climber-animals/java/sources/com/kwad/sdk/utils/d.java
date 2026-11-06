package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static boolean cr(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion >= 29 && Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy() && !bc.useStoragePermissionDisable();
        } catch (Throwable unused) {
        }
    }
}
