package com.byazt.wk;

import com.byazt.xk.hw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2384, 37})
public final class pr {
    public static void pr(String str, String str2, int i, String str3, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "dispatch");
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("triggerId", str2);
            if (str == null) {
                str = "";
            }
            jSONObject.put("onType", str);
            jSONObject.put("hitCount", i);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("source", str3);
            jSONObject.put("costMs", j);
            hw.pr().hw("trigger_event", jSONObject);
        } catch (Throwable th) {
        }
    }

    public static void pr(String str, String str2, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "cascade_emit");
            if (str == null) {
                str = "";
            }
            jSONObject.put("sourceTriggerId", str);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("targetEventName", str2);
            jSONObject.put("depth", i);
            hw.pr().hw("trigger_event", jSONObject);
        } catch (Throwable th) {
        }
    }

    public static void pr(List<String> list, int i, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "cascade_overflow");
            JSONArray jSONArray = new JSONArray();
            if (list != null) {
                for (String str2 : list) {
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONArray.put(str2);
                }
            }
            jSONObject.put("chain", jSONArray);
            jSONObject.put("depth", i);
            if (str == null) {
                str = "";
            }
            jSONObject.put(MediationConstant.KEY_REASON, str);
            hw.pr().hw("trigger_event", jSONObject);
        } catch (Throwable th) {
        }
    }

    public static void pr(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "fallback_legacy");
            jSONObject.put("source", "ugen");
            if (str == null) {
                str = "";
            }
            jSONObject.put(MediationConstant.KEY_REASON, str);
            hw.pr().hw("trigger_event", jSONObject);
        } catch (Throwable th) {
        }
    }
}
