package com.byazt.xe;

import com.byazt.ca.ho;
import com.byazt.hg.of;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1624, 20})
public final class hn {
    public static void pr(of ofVar, JSONObject jSONObject) {
        if (ofVar == null || jSONObject == null) {
            return;
        }
        ofVar.zo(jSONObject.optLong("correct_action_code", -1L));
        ofVar.aj(jSONObject.optLong("correct_result_code", -1L));
        ofVar.vk(jSONObject.optLong("cali_timestamp", -1L));
    }

    public static void pr(of ofVar, JSONObject jSONObject, boolean z) {
        if (ofVar == null || jSONObject == null) {
            return;
        }
        long jMj = ofVar.mj();
        long jVh = ofVar.vh();
        long jDs = ofVar.ds();
        try {
            jSONObject.put("correct_action_code", jMj);
            jSONObject.put("correct_result_code", jVh);
            if (z) {
                jSONObject.put("cali_timestamp", jDs);
            }
        } catch (JSONException e) {
            ho.pr("CaliTrackUtils", "putCaliExtra error", e);
        }
    }
}
