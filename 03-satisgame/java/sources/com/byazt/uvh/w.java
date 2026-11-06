package com.byazt.uvh;

import com.byazt.tk.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 576, 13})
public final class w {
    public final int cp;
    public final int d;
    public final int fs;
    public final int l;
    public final int n;
    public final long oa;
    public final int q;
    public final int qg;
    public final int rv;
    public final int s;
    public final com.byazt.yq.s sz;
    public final int tj;
    public final int w;
    public final int x;

    public w(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, long j, com.byazt.yq.s sVar) {
        this.n = i;
        this.qg = i2;
        this.s = i3;
        this.q = i4;
        this.l = i5;
        this.w = i6;
        this.x = i7;
        this.fs = i8;
        this.rv = i9;
        this.tj = i10;
        this.cp = i11;
        this.d = i12;
        this.oa = j;
        this.sz = sVar == null ? com.byazt.yq.s.n : sVar;
    }

    public int n() {
        return this.fs;
    }

    public int qg() {
        return this.n;
    }

    public int s() {
        return this.s;
    }

    public int q() {
        return this.q;
    }

    public JSONObject n(String str, boolean z) {
        int i = 1;
        JSONObject jSONObjectN = n(true);
        try {
            jSONObjectN.put("stage", str);
            if (!z) {
                i = 0;
            }
            jSONObjectN.put("baseline_valid", i);
        } catch (JSONException e) {
            k.qg("PerfMonitor", "jank sample stage json err: " + e.getMessage());
        }
        return jSONObjectN;
    }

    public JSONObject l() {
        return n(false);
    }

    private JSONObject n(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("frame_count", this.n);
            jSONObject.put("jank_frame_count", this.qg);
            jSONObject.put("jank_rate", this.s);
            jSONObject.put("total_skipped_frames", this.q);
            jSONObject.put("max_frame_cost_ms", this.l);
            jSONObject.put("avg_frame_cost_ms", this.w);
            jSONObject.put("p50_frame_cost_ms", this.x);
            jSONObject.put("p95_frame_cost_ms", this.fs);
            jSONObject.put("threshold_ms", this.rv);
            if (z) {
                jSONObject.put("delta_frame_ms", this.tj);
                jSONObject.put("delta_jank_rate", this.cp);
                jSONObject.put("delta_skipped_frames", this.d);
                jSONObject.put("res", this.sz.w());
            } else {
                jSONObject.put("res", n(this.sz));
            }
            jSONObject.put("ts", this.oa);
        } catch (JSONException e) {
            k.qg("PerfMonitor", "jank sample json err: " + e.getMessage());
        }
        return jSONObject;
    }

    private static JSONObject n(com.byazt.yq.s sVar) {
        JSONObject jSONObject = new JSONObject();
        if (sVar == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("webview_count", sVar.n());
            jSONObject.put("player_count", sVar.qg());
            jSONObject.put("native_ad_count", sVar.s());
            jSONObject.put("oom_count", sVar.q());
            jSONObject.put("thread_count", sVar.l());
        } catch (JSONException e) {
            k.qg("PerfMonitor", "jank cycle res json err: " + e.getMessage());
        }
        return jSONObject;
    }
}
