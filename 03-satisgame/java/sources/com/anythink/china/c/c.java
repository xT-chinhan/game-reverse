package com.anythink.china.c;

import android.util.Log;
import com.anythink.core.api.ATSDK;

/* JADX INFO: loaded from: classes.dex */
final class c {
    private static final String a = "anythink_lpc";

    private c() {
    }

    private static boolean a() {
        return ATSDK.isNetworkLogDebug();
    }

    static void a(String str) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.i(a, str);
        }
    }

    static void a(String str, Throwable th) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.w(a, str, th);
        }
    }

    static void b(String str) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.e(a, str);
        }
    }

    static void b(String str, Throwable th) {
        if (ATSDK.isNetworkLogDebug()) {
            Log.e(a, str, th);
        }
    }
}
