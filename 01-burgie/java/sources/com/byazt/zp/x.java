package com.byazt.zp;

import android.os.Environment;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1229, 121})
public class x {
    public static String pr() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable th) {
            return "";
        }
    }
}
