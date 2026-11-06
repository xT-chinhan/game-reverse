package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ao {
    public static void ms(Object obj, String str) {
        if (obj == null) {
            xr(str);
        }
    }

    public static void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            xr(str2);
        }
    }

    public static void ms(boolean z, String str) {
        if (z) {
            return;
        }
        xr(str);
    }

    public static void ms(String str) {
        xr(str);
    }

    private static void xr(String str) {
        throw new IllegalArgumentException(str);
    }
}
