package com.bytedance.sdk.openadsdk.api.plugin.xr;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static String ms(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 49) {
            return str;
        }
        String strMs = ms(str.substring(1, 33), 32);
        String strSubstring = str.substring(33, 49);
        return (strSubstring == null || strMs == null) ? str : com.bytedance.sdk.component.ka.ms.xr(str.substring(49), strSubstring, strMs);
    }

    public static String ms(String str, int i) {
        if (str == null || str.length() != i) {
            return null;
        }
        int i2 = i / 2;
        return str.substring(i2, i) + str.substring(0, i2);
    }
}
