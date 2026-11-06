package com.bytedance.sdk.openadsdk.op;

import android.os.Environment;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static String ms() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable unused) {
            return "";
        }
    }
}
