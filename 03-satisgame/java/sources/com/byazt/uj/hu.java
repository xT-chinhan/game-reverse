package com.byazt.uj;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 738, 793})
public class hu {
    public static Object n(com.byazt.qy.n nVar) {
        hd hdVarN;
        if (nVar == null || (hdVarN = n(nVar.n())) == null) {
            return null;
        }
        return hdVarN.n(null, nVar.qg());
    }

    public static hd n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str.hashCode();
        switch (str) {
            case "toNumber":
                return new ou();
            case "toString":
                return new wm();
            case "formatDecimal":
                return new d();
            case "feature":
                return new rv();
            case "modArray":
                return new cd();
            case "find":
                return new tj();
            case "join":
                return new cy();
            case "size":
                return new um();
            case "includes":
                return new oa();
            case "chunk":
                return new n();
            case "exist":
                return new fs();
            case "slice":
                return new a();
            case "split":
                return new py();
            case "dateFormat":
                return new q();
            case "decodeUrl":
                return new l();
            case "formatCurrency":
                return new cp();
            case "translate":
                return new m();
            case "currentTimestamp":
                return new s();
            case "compactFormatCurrency":
                return new qg();
            case "encodeUrl":
                return new x();
            case "isDigit":
                return new sz();
            case "isEmpty":
                return new k();
            default:
                return null;
        }
    }
}
