package com.byazt.br;

import com.byazt.tk.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1001, 8})
public final class s {
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
            jSONObject.put("mem", jSONArray2);
            q.n("mem_observe", nVar, null, jSONObject);
        } catch (JSONException e) {
            k.qg("PerfMonitor_MemoryMonitor", "mem lifecycle json err: " + e.getMessage());
        }
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("memo", jSONObject);
            q.n("mem_cycle_observe", jSONObject2);
        } catch (JSONException e) {
            k.qg("PerfMonitor_MemoryMonitor", "mem cycle json err: " + e.getMessage());
        }
    }
}
