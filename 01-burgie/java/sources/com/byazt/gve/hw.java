package com.byazt.gve;

import com.byazt.ca.ho;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 597, 13})
public final class hw {
    public static void pr(com.byazt.tj.pr prVar, JSONArray jSONArray) {
        if (prVar == null || jSONArray == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object objOpt = jSONArray.opt(i);
                if (objOpt != null) {
                    jSONArray2.put(objOpt);
                }
            }
            jSONObject.put("jank", jSONArray2);
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "jank lifecycle json err: " + e.getMessage());
        }
        x.pr("jank_observe", prVar, null, jSONObject);
    }

    public static void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("jank", jSONObject);
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "jank cycle json err: " + e.getMessage());
        }
        x.pr("jank_cycle_observe", jSONObject2);
    }
}
