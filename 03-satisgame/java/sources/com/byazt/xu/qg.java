package com.byazt.xu;

import android.os.Environment;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 91, 26})
public class qg {
    public static String n() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable unused) {
            return "";
        }
    }
}
