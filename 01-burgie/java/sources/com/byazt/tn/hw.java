package com.byazt.tn;

import android.text.TextUtils;
import com.byazt.llk.uc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1629, 13})
public class hw {
    public static String pr(String str, JSONObject jSONObject) {
        pr prVarHn;
        pr.InterfaceC0198pr interfaceC0198prPr;
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            if (!str.startsWith("${") || !str.endsWith("}") || (prVarHn = uc.pr().hn()) == null || (interfaceC0198prPr = prVarHn.pr(str.substring(2, str.length() - 1))) == null) {
                return str;
            }
            return (String) interfaceC0198prPr.pr(jSONObject);
        } catch (Throwable th) {
            return str;
        }
    }

    public static Object pr(Object obj, JSONObject jSONObject) {
        if (obj == null) {
            return null;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        if (!strValueOf.startsWith("${") || !strValueOf.endsWith("}")) {
            return obj;
        }
        return pr(strValueOf, jSONObject);
    }
}
