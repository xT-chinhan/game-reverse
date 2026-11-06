package com.byazt.gve;

import com.byazt.ca.ho;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 597, 20})
public final class hn {
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
            jSONObject.put("mem", jSONArray2);
            x.pr("mem_observe", prVar, null, jSONObject);
        } catch (JSONException e) {
            ho.hw("PerfMonitor_MemoryMonitor", "mem lifecycle json err: " + e.getMessage());
        }
    }

    public static void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("memo", jSONObject);
            x.pr("mem_cycle_observe", jSONObject2);
        } catch (JSONException e) {
            ho.hw("PerfMonitor_MemoryMonitor", "mem cycle json err: " + e.getMessage());
        }
    }
}
