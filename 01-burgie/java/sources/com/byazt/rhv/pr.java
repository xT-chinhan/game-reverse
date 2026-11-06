package com.byazt.rhv;

import android.text.TextUtils;
import com.byazt.tit.rc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1125, 37})
public class pr {
    public static String pr(String str, JSONObject jSONObject) {
        com.byazt.oze.pr prVarPr;
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return str;
        }
        try {
            if (!str.startsWith("${") || !str.endsWith("}") || (prVarPr = com.byazt.oze.pr.pr(str.substring(2, str.length() - 1))) == null) {
                return str;
            }
            Object objPr = prVarPr.pr(jSONObject);
            if (objPr instanceof String) {
                return (String) objPr;
            }
            if (objPr instanceof com.byazt.dg.pr) {
                return String.valueOf(rc.pr((com.byazt.dg.pr) objPr));
            }
            return String.valueOf(objPr);
        } catch (Throwable th) {
            return str;
        }
    }
}
