package com.tapsdk.tapad.oaid;

/* JADX INFO: loaded from: classes3.dex */
public final class OAIDLog {
    private static final String TAG = "OAID";
    private static boolean enable;

    private OAIDLog() {
    }

    public static void enable() {
        enable = true;
    }

    public static void print(Object obj) {
        if (enable) {
            if (obj == null) {
                obj = "<null>";
            }
            obj.toString();
        }
    }
}
