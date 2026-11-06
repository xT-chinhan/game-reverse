package com.byazt.gve;

import android.text.TextUtils;
import com.byazt.ca.ho;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 597, 121})
public final class x {
    public static void pr(String str, com.byazt.tj.pr prVar, String str2, final JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || prVar == null) {
            return;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                ho.hw("PerfMonitor", "report event " + str + " err: " + th.getMessage());
                return;
            }
        }
        try {
            jSONObject.put("page", com.byazt.sf.hw.pr());
            jSONObject.put("fg", com.byazt.sf.hw.hw() ? 1 : 0);
            jSONObject.put("ad_session", prVar.pr());
            jSONObject.put(MediationConstant.EXTRA_ADID, prVar.uc());
            jSONObject.put("lottie_tmp_url", prVar.zo());
            jSONObject.put("tpl_id_v3", prVar.aj());
            jSONObject.put("ugen_url", prVar.vk());
            jSONObject.put("sample_rate", pr(str));
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("stage", str2);
            }
            com.byazt.uo.hn.pr().pr(prVar, pr(jSONObject)).pr(jSONObject);
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr(str, prVar.hn(), prVar.c(), prVar.hw(), prVar.x(), null, prVar.fw(), null, null, 0, new com.byazt.ttf.pr() { // from class: com.byazt.gve.x.1
            @Override // com.byazt.ttf.pr
            public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                return jSONObject;
            }
        });
    }

    private static long pr(JSONObject jSONObject) {
        long jPr = pr(jSONObject.optJSONArray("cpu"), "delta_cpu");
        if (jPr > 0) {
            return jPr;
        }
        long jPr2 = pr(jSONObject.optJSONArray("jank"), "delta_frame_ms");
        if (jPr2 > 0) {
            return jPr2;
        }
        return pr(jSONObject.optJSONArray("mem"), "delta_used_kb");
    }

    private static long pr(JSONArray jSONArray, String str) {
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

    public static void pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                ho.hw("PerfMonitor", "report event " + str + " err: " + th.getMessage());
                return;
            }
        }
        try {
            jSONObject.put("page", com.byazt.sf.hw.pr());
            jSONObject.put("fg", com.byazt.sf.hw.hw() ? 1 : 0);
            jSONObject.put("sample_rate", pr(str));
            jSONObject.put("ts", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        com.byazt.xk.hw.pr().pr(str, jSONObject);
    }

    private static int pr(String str) {
        com.byazt.kf.x xVarPr = com.byazt.kf.x.pr();
        if ("mem_observe".equals(str) || "mem_cycle_observe".equals(str)) {
            return xVarPr.c().hw();
        }
        if ("jank_observe".equals(str) || "jank_cycle_observe".equals(str)) {
            return xVarPr.uc().hw();
        }
        if ("cpu_observe".equals(str) || "cpu_cycle_observe".equals(str)) {
            return xVarPr.fw().hw();
        }
        return 0;
    }
}
