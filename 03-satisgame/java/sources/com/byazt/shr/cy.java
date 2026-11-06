package com.byazt.shr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1216, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements q {
    public boolean cp;
    public long fs;
    public String l;
    public long n;
    public int q;
    public long qg;
    public long rv;
    public int s;
    public int tj;
    public JSONArray w;
    public int x;

    public void n(boolean z) {
        this.cp = z;
    }

    public void n(long j) {
        this.rv = j;
    }

    public void n(int i) {
        this.tj = i;
    }

    public void n(JSONArray jSONArray) {
        this.w = jSONArray;
    }

    public void qg(long j) {
        this.fs = j;
    }

    public void qg(int i) {
        this.x = i;
    }

    public void s(long j) {
        this.n = j;
    }

    public void q(long j) {
        this.qg = j;
    }

    public void s(int i) {
        this.s = i;
    }

    public void q(int i) {
        this.q = i;
    }

    public void n(String str) {
        this.l = str;
    }

    @Override // com.byazt.shr.q
    public void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.n);
            jSONObject.put("total_duration", this.qg);
            jSONObject.put("error_code", this.s);
            jSONObject.put("extra_error_code", this.q);
            jSONObject.put("error_message", this.l);
            jSONObject.put("event_list", this.w);
            jSONObject.put("vbtt_skip_type", this.x);
            jSONObject.put("video_cache_size", this.fs);
            jSONObject.put("current", this.rv);
            jSONObject.put("percent", this.tj);
            jSONObject.put("has_endcard_skip", this.cp);
        } catch (Throwable unused) {
        }
    }
}
