package com.varbto.utils.api;

/* JADX INFO: loaded from: classes3.dex */
public final class UtilConst {
    public static final String CRASH_CAT_A = "A";
    public static final String CRASH_CAT_B = "B";
    public static final String CRASH_CAT_C = "C";
    public static final String CRASH_CAT_S = "S";
    public static final String CRASH_CAT_UNKNOWN = "UNKNOWN";
    public static final int SDK_MCSDK = 0;
    public static final int SDK_OTHER = 2;
    public static final int SDK_TOPON = 1;

    public static boolean isValidCrashCategory(String str) {
        if (str == null) {
            return false;
        }
        return CRASH_CAT_S.equals(str) || CRASH_CAT_A.equals(str) || CRASH_CAT_B.equals(str) || CRASH_CAT_C.equals(str) || CRASH_CAT_UNKNOWN.equals(str);
    }
}
