package com.byazt.sn;

import com.byazt.gcl.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1816, 19})
public final class n {
    public static void n(s sVar, boolean z, boolean z2, boolean z3) {
        if (sVar == null) {
            return;
        }
        String.format("sendMessage: isVisible = %s, isResume = %s, isForemost = %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            jSONObject.put("adResume", z2);
            jSONObject.put("adForemost", z3);
            sVar.qg("notifyPageVisibilityState", jSONObject);
        } catch (Exception unused) {
        }
    }
}
