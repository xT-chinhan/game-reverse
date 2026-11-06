package com.bytedance.sdk.component.ms;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
class ny {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f1265ms;

    static void ms(boolean z) {
        f1265ms = z;
    }

    static void ms(String str) {
        if (f1265ms) {
            com.bytedance.sdk.component.utils.sl.ms("JsBridge2", str);
        }
    }

    static void xr(String str) {
        if (f1265ms) {
            com.bytedance.sdk.component.utils.sl.xr("JsBridge2", str);
        }
    }

    static void ms(String str, Throwable th) {
        if (f1265ms) {
            com.bytedance.sdk.component.utils.sl.xr("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.sl.xr("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void xr(String str, Throwable th) {
        if (f1265ms) {
            com.bytedance.sdk.component.utils.sl.ah("JsBridge2", str, th);
            com.bytedance.sdk.component.utils.sl.d("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    static void ms(RuntimeException runtimeException) {
        if (f1265ms) {
            throw runtimeException;
        }
    }
}
