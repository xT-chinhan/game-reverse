package com.byazt.fh;

import com.byazt.ca.ho;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 890, 5})
public final class uc {
    public final int aj;
    public final int c;
    public final int fw;
    public final com.byazt.sf.hn g;
    public final int hn;
    public final int hw;
    public final int k;
    public final long m;
    public final int pr;
    public final int uc;
    public final int vk;
    public final int w;
    public final int x;
    public final int zo;

    public uc(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, long j, com.byazt.sf.hn hnVar) {
        this.pr = i;
        this.hw = i2;
        this.hn = i3;
        this.x = i4;
        this.c = i5;
        this.uc = i6;
        this.fw = i7;
        this.zo = i8;
        this.aj = i9;
        this.vk = i10;
        this.w = i11;
        this.k = i12;
        this.m = j;
        this.g = hnVar == null ? com.byazt.sf.hn.pr : hnVar;
    }

    public int pr() {
        return this.zo;
    }

    public int hw() {
        return this.pr;
    }

    public int hn() {
        return this.hn;
    }

    public int x() {
        return this.x;
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
            ho.hw("PerfMonitor", "jank sample stage json err: " + e.getMessage());
        }
        return jSONObjectPr;
    }

    public JSONObject c() {
        return pr(false);
    }

    private JSONObject pr(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("frame_count", this.pr);
            jSONObject.put("jank_frame_count", this.hw);
            jSONObject.put("jank_rate", this.hn);
            jSONObject.put("total_skipped_frames", this.x);
            jSONObject.put("max_frame_cost_ms", this.c);
            jSONObject.put("avg_frame_cost_ms", this.uc);
            jSONObject.put("p50_frame_cost_ms", this.fw);
            jSONObject.put("p95_frame_cost_ms", this.zo);
            jSONObject.put("threshold_ms", this.aj);
            if (!z) {
                jSONObject.put("res", pr(this.g));
            } else {
                jSONObject.put("delta_frame_ms", this.vk);
                jSONObject.put("delta_jank_rate", this.w);
                jSONObject.put("delta_skipped_frames", this.k);
                jSONObject.put("res", this.g.uc());
            }
            jSONObject.put("ts", this.m);
        } catch (JSONException e) {
            ho.hw("PerfMonitor", "jank sample json err: " + e.getMessage());
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
            ho.hw("PerfMonitor", "jank cycle res json err: " + e.getMessage());
        }
        return jSONObject;
    }
}
