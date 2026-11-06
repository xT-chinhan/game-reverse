package com.byazt.yo;

import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 19})
public class ho implements x {
    public long aj;
    public String c;
    public int fw;
    public int hn;
    public long hw;
    public long pr;
    public JSONArray uc;
    public int vk;
    public boolean w;
    public int x;
    public long zo;

    public void pr(boolean z) {
        this.w = z;
    }

    public void pr(long j) {
        this.aj = j;
    }

    public void pr(int i) {
        this.vk = i;
    }

    public void pr(JSONArray jSONArray) {
        this.uc = jSONArray;
    }

    public void hw(long j) {
        this.zo = j;
    }

    public void hw(int i) {
        this.fw = i;
    }

    public void hn(long j) {
        this.pr = j;
    }

    public void x(long j) {
        this.hw = j;
    }

    public void hn(int i) {
        this.hn = i;
    }

    public void x(int i) {
        this.x = i;
    }

    public void pr(String str) {
        this.c = str;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.pr);
            jSONObject.put("total_duration", this.hw);
            jSONObject.put(Constants.ERROR_CODE_FIELD, this.hn);
            jSONObject.put("extra_error_code", this.x);
            jSONObject.put("error_message", this.c);
            jSONObject.put("event_list", this.uc);
            jSONObject.put("vbtt_skip_type", this.fw);
            jSONObject.put("video_cache_size", this.zo);
            jSONObject.put("current", this.aj);
            jSONObject.put("percent", this.vk);
            jSONObject.put("has_endcard_skip", this.w);
        } catch (Throwable th) {
        }
    }
}
