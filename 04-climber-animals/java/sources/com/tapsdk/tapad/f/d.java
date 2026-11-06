package com.tapsdk.tapad.f;

import com.tapsdk.tapad.internal.utils.TapADLogger;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static final String a = "OAID";
    private static boolean b = false;

    private d() {
    }

    public static void a() {
        b = true;
    }

    public static void a(Object obj) {
        if (b) {
            if (obj == null) {
                obj = "<null>";
            }
            TapADLogger.i("OAID:" + obj);
        }
    }
}
