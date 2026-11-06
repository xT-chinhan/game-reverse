package com.byazt.rb;

import java.util.IllegalFormatException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1315, 8})
public final class s {
    public static void n(Object obj) {
        n(obj, true, "Object can not be null.", "");
    }

    private static boolean n(Object obj, boolean z, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String strN = n(str, objArr);
        if (z) {
            throw new NullPointerException(strN);
        }
        qg.q("TTMediationSDK_ADAPTER", strN);
        return false;
    }

    private static String n(String str, Object... objArr) {
        String strValueOf = String.valueOf(str);
        try {
            return String.format(strValueOf, objArr);
        } catch (IllegalFormatException e) {
            qg.q("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e.getMessage());
            return strValueOf;
        }
    }
}
