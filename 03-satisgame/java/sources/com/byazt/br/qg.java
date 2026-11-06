package com.byazt.br;

import com.byazt.tk.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1001, 26})
public final class qg {
    public static void n(com.byazt.gd.n nVar, JSONArray jSONArray) {
        if (nVar == null || jSONArray == null) {
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
            k.qg("PerfMonitor", "jank lifecycle json err: " + e.getMessage());
        }
        q.n("jank_observe", nVar, null, jSONObject);
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("jank", jSONObject);
        } catch (JSONException e) {
            k.qg("PerfMonitor", "jank cycle json err: " + e.getMessage());
        }
        q.n("jank_cycle_observe", jSONObject2);
    }
}
