package com.byazt.lr;

import com.byazt.sd.nl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1896, 37})
public final class pr {
    public static void pr(nl nlVar, boolean z, boolean z2, boolean z3) {
        if (nlVar == null) {
            return;
        }
        String.format("sendMessage: isVisible = %s, isResume = %s, isForemost = %s", Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("adVisible", z);
            jSONObject.put("adResume", z2);
            jSONObject.put("adForemost", z3);
            nlVar.hw("notifyPageVisibilityState", jSONObject);
        } catch (Exception e) {
        }
    }
}
