package com.byazt.vy;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 86})
public class cd {
    public static void n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            n(str2);
        }
    }

    private static void n(String str) {
        throw new IllegalArgumentException(str);
    }
}
