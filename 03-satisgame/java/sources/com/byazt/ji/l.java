package com.byazt.ji;

import com.anythink.core.common.f.e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 115, 18})
public class l {
    public final x n = new x();

    public q n(String str, String str2, w.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("scene", str);
            jSONObject.put("trigger_scene", str2);
            if (nVar != null) {
                jSONObject.put("trace_token", nVar.w);
                jSONObject.put("health_score", this.n.n(nVar));
                jSONObject.put(e.a.b, nVar.s);
                jSONObject.put("category", nVar.n);
                jSONObject.put("hit_level", nVar.q);
                jSONObject.put("failure_count", nVar.rv);
                jSONObject.put("version_drift_count", nVar.tj);
                jSONObject.put("duration_ms", nVar.d);
                jSONObject.put("recent_nodes", n(nVar));
                jSONObject.put("exception_summary", nVar.rv);
            }
        } catch (JSONException unused) {
        }
        return new q(jSONObject);
    }

    public JSONObject n(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return new JSONObject();
        }
        if (jSONObject.toString().length() <= i) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("scene", jSONObject.optString("scene"));
            jSONObject2.put("trigger_scene", jSONObject.optString("trigger_scene"));
            jSONObject2.put("trace_token", jSONObject.optString("trace_token"));
            jSONObject2.put("health_score", jSONObject.optInt("health_score"));
            jSONObject2.put("trimmed", true);
        } catch (JSONException unused) {
        }
        return jSONObject2;
    }

    private JSONArray n(w.n nVar) {
        JSONArray jSONArray = new JSONArray();
        if (nVar == null) {
            return jSONArray;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", nVar.n);
            jSONObject.put(e.a.b, nVar.s);
            jSONObject.put("hit_level", nVar.q);
            jSONObject.put("method_id", nVar.l);
            jSONObject.put("trace_token", nVar.w);
        } catch (JSONException unused) {
        }
        jSONArray.put(jSONObject);
        return jSONArray;
    }
}
