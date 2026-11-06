package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.api.ab;

/* JADX INFO: loaded from: classes2.dex */
public class MediationApiLog {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static boolean f3938ms = false;
    private static String xr = "MEDIATION_LOG";

    public static void setDebug(Boolean bool) {
        f3938ms = bool.booleanValue();
    }

    public static void i(String str, String str2) {
        if (f3938ms) {
            ab.ah(str, str2);
        }
    }

    public static void i(String str) {
        if (f3938ms) {
            ab.ah(xr, str);
        }
    }

    public static void e(String str, String str2) {
        if (f3938ms) {
            ab.ka(str, str2);
        }
    }

    public static void e(String str) {
        if (f3938ms) {
            ab.ka(xr, str);
        }
    }
}
