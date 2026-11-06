package com.tapsdk.tapad.e.o.a.l;

import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final String a = "oaid-flow";
    private static boolean b = true;

    public static void a(String str) {
        if (b) {
            Log.d(a, str);
        }
    }

    public static void a(boolean z) {
        b = z;
    }

    public static void b(String str) {
        if (b) {
            Log.e(a, str);
        }
    }

    public static void c(String str) {
        if (b) {
            Log.i(a, str);
        }
    }

    public static void d(String str) {
        if (b) {
            Log.w(a, str);
        }
    }
}
