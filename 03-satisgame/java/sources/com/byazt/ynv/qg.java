package com.byazt.ynv;

import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN, 26})
public final class qg {
    public final com.byazt.yq.s l;
    public final int n;
    public final long q;
    public final int qg;
    public final int s;

    public qg(int i, int i2, int i3, long j, com.byazt.yq.s sVar) {
        this.n = i;
        this.qg = i2;
        this.s = i3;
        this.q = j;
        this.l = sVar == null ? com.byazt.yq.s.n : sVar;
    }

    public int n() {
        return this.n;
    }

    public boolean qg() {
        return this.n >= 0;
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
            k.qg("PerfMonitor", "cpu sample stage json err: " + e.getMessage());
        }
        return jSONObjectN;
    }

    public JSONObject s() {
        return n(false);
    }

    private JSONObject n(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cpu_app_usage_rate", this.n);
            jSONObject.put("cpu_core_count", this.qg);
            jSONObject.put("sample_valid", qg() ? 1 : 0);
            if (z) {
                jSONObject.put("delta_cpu", this.s);
                jSONObject.put("res", this.l.w());
            } else {
                jSONObject.put("res", n(this.l));
            }
            jSONObject.put("ts", this.q);
        } catch (JSONException e) {
            k.qg("PerfMonitor", "cpu sample json err: " + e.getMessage());
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
            k.qg("PerfMonitor", "cpu cycle res json err: " + e.getMessage());
        }
        return jSONObject;
    }
}
