package com.bytedance.sdk.component.ms;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f1258ms;

    static String ms() {
        return "";
    }

    static String ms(Throwable th) {
        return "{\"code\":" + (th instanceof qv ? ((qv) th).f1266ms : 0) + "}";
    }

    static String ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String strSubstring = f1258ms ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!strSubstring.isEmpty()) {
            return str2 + "," + strSubstring + "}";
        }
        return str2 + "}";
    }

    static void ms(boolean z) {
        f1258ms = z;
    }
}
