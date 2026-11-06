package com.bytedance.adsdk.xr;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ny {
    public static Object ms(com.bytedance.adsdk.xr.xr.ms.ms msVar) {
        c cVarMs;
        if (msVar == null || (cVarMs = ms(msVar.ms())) == null) {
            return null;
        }
        return cVarMs.ms(null, msVar.xr());
    }

    public static c ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "modArray":
                return new ab();
            case "find":
                return new d();
            case "chunk":
                return new ms();
            case "exist":
                return new ah();
            case "translate":
                return new x();
            case "isDigit":
                return new ka();
            default:
                return null;
        }
    }
}
