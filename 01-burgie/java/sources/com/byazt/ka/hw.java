package com.byazt.ka;

import com.byazt.ca.ho;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1547, 13})
public final class hw {
    public final com.byazt.sf.hn c;
    public final int hn;
    public final int hw;
    public final int pr;
    public final long x;

    public hw(int i, int i2, int i3, long j, com.byazt.sf.hn hnVar) {
        this.pr = i;
        this.hw = i2;
        this.hn = i3;
        this.x = j;
        this.c = hnVar == null ? com.byazt.sf.hn.pr : hnVar;
    }

    public int pr() {
        return this.pr;
    }

    public boolean hw() {
        return this.pr >= 0;
    }

    public JSONObject pr(String str, boolean z) {
        int i = 1;
        JSONObject jSONObjectPr = pr(true);
        try {
            jSONObjectPr.put("stage", str);
            if (!z) {
                i = 0;
            }
            jSONObjectPr.put("baseline_valid", i);
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "cpu sample stage json err: " + e.getMessage());
        }
        return jSONObjectPr;
    }

    public JSONObject hn() {
        return pr(false);
    }

    private JSONObject pr(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cpu_app_usage_rate", this.pr);
            jSONObject.put("cpu_core_count", this.hw);
            jSONObject.put("sample_valid", hw() ? 1 : 0);
            if (!z) {
                jSONObject.put("res", pr(this.c));
            } else {
                jSONObject.put("delta_cpu", this.hn);
                jSONObject.put("res", this.c.uc());
            }
            jSONObject.put("ts", this.x);
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "cpu sample json err: " + e.getMessage());
        }
        return jSONObject;
    }

    private static JSONObject pr(com.byazt.sf.hn hnVar) {
        JSONObject jSONObject = new JSONObject();
        if (hnVar == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("webview_count", hnVar.pr());
            jSONObject.put("player_count", hnVar.hw());
            jSONObject.put("native_ad_count", hnVar.hn());
            jSONObject.put("oom_count", hnVar.x());
            jSONObject.put("thread_count", hnVar.c());
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "cpu cycle res json err: " + e.getMessage());
        }
        return jSONObject;
    }
}
