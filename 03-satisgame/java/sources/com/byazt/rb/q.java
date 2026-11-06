package com.byazt.rb;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1315, 5})
public class q {
    public static String n() {
        return "TTMediationSDK_";
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return n();
        }
        return "TTMediationSDK_" + str + "_";
    }

    public static String n(com.byazt.ws.qg qgVar) {
        if (qgVar == null || TextUtils.isEmpty(qgVar.f())) {
            return n();
        }
        return "TTMediationSDK_" + qgVar.f() + "_";
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return n();
        }
        if (TextUtils.isEmpty(str2)) {
            return n(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }

    public static String qg(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return n();
        }
        if (TextUtils.isEmpty(str2)) {
            return n(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }
}
