package com.byazt.br;

import android.text.TextUtils;
import com.anythink.core.common.l.f;
import com.byazt.tk.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1001, 5})
public final class q {
    public static void n(String str, com.byazt.gd.n nVar, String str2, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || nVar == null) {
            return;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                k.qg("PerfMonitor", "report event " + str + " err: " + th.getMessage());
                return;
            }
        }
        try {
            jSONObject.put("page", com.byazt.yq.qg.n());
            jSONObject.put("fg", com.byazt.yq.qg.qg() ? 1 : 0);
            jSONObject.put("ad_session", nVar.n());
            jSONObject.put(MediationConstant.EXTRA_ADID, nVar.w());
            jSONObject.put("lottie_tmp_url", nVar.fs());
            jSONObject.put("tpl_id_v3", nVar.rv());
            jSONObject.put("ugen_url", nVar.tj());
            jSONObject.put(f.V, n(str));
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("stage", str2);
            }
            com.byazt.wp.s.n().n(nVar, n(jSONObject)).n(jSONObject);
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().n(str, nVar.s(), nVar.l(), nVar.qg(), nVar.q(), null, nVar.x(), null, null, 0, new com.byazt.rs.n() { // from class: com.byazt.br.q.1
            @Override // com.byazt.rs.n
            public JSONObject n(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    private static long n(JSONObject jSONObject) {
        long jN = n(jSONObject.optJSONArray("cpu"), "delta_cpu");
        if (jN > 0) {
            return jN;
        }
        long jN2 = n(jSONObject.optJSONArray("jank"), "delta_frame_ms");
        return jN2 > 0 ? jN2 : n(jSONObject.optJSONArray("mem"), "delta_used_kb");
    }

    private static long n(JSONArray jSONArray, String str) {
        if (jSONArray == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        int length = jSONArray.length();
        long j = 0;
        long j2 = 0;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
            if (jSONObjectOptJSONObject != null) {
                long jOptLong = jSONObjectOptJSONObject.optLong("ts", 0L);
                if (jOptLong > 0) {
                    j2 = jOptLong;
                }
                int iOptInt = jSONObjectOptJSONObject.optInt(str, 0);
                if (iOptInt > i && jOptLong > 0) {
                    i = iOptInt;
                    j = jOptLong;
                }
            }
        }
        return j > 0 ? j : j2;
    }

    public static void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                k.qg("PerfMonitor", "report event " + str + " err: " + th.getMessage());
                return;
            }
        }
        try {
            jSONObject.put("page", com.byazt.yq.qg.n());
            jSONObject.put("fg", com.byazt.yq.qg.qg() ? 1 : 0);
            jSONObject.put(f.V, n(str));
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put("ads_vids", com.byazt.vyf.qg.n().qg());
        } catch (JSONException unused) {
        }
        com.byazt.eji.s.n().n(str, jSONObject);
    }

    private static int n(String str) {
        com.byazt.md.q qVarN = com.byazt.md.q.n();
        if ("mem_observe".equals(str) || "mem_cycle_observe".equals(str)) {
            return qVarN.l().qg();
        }
        if ("jank_observe".equals(str) || "jank_cycle_observe".equals(str)) {
            return qVarN.w().qg();
        }
        if ("cpu_observe".equals(str) || "cpu_cycle_observe".equals(str)) {
            return qVarN.x().qg();
        }
        return 0;
    }
}
