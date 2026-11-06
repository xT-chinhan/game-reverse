package com.byazt.tk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, 86})
public class cd {
    public static void n(Object obj, String str) {
        if (obj == null) {
            qg(str);
        }
    }

    public static void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            qg(str2);
        }
    }

    public static void n(boolean z, String str) {
        if (z) {
            return;
        }
        qg(str);
    }

    public static void n(String str) {
        qg(str);
    }

    private static void qg(String str) {
        throw new IllegalArgumentException(str);
    }
}
