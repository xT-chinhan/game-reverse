package com.byazt.fxc;

import com.byazt.gct.pk;
import com.byazt.tk.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1743, 8})
public final class s {
    public static void n(pk pkVar, JSONObject jSONObject) {
        if (pkVar == null || jSONObject == null) {
            return;
        }
        pkVar.fs(jSONObject.optLong("correct_action_code", -1L));
        pkVar.rv(jSONObject.optLong("correct_result_code", -1L));
        pkVar.tj(jSONObject.optLong("cali_timestamp", -1L));
    }

    public static void n(pk pkVar, JSONObject jSONObject, boolean z) {
        if (pkVar == null || jSONObject == null) {
            return;
        }
        long jEc = pkVar.ec();
        long jMq = pkVar.mq();
        long jHz = pkVar.hz();
        try {
            jSONObject.put("correct_action_code", jEc);
            jSONObject.put("correct_result_code", jMq);
            if (z) {
                jSONObject.put("cali_timestamp", jHz);
            }
        } catch (JSONException e) {
            k.n("CaliTrackUtils", "putCaliExtra error", e);
        }
    }
}
