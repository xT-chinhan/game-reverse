package com.byazt.gve;

import com.byazt.ca.ho;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 597, 37})
public final class pr {
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
            jSONObject.put("cpu", jSONArray2);
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "cpu lifecycle json err: " + e.getMessage());
        }
        x.pr("cpu_observe", prVar, null, jSONObject);
    }

    public static void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("cpu", jSONObject);
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "cpu cycle json err: " + e.getMessage());
        }
        x.pr("cpu_cycle_observe", jSONObject2);
    }
}
