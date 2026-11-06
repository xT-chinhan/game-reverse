package com.byazt.yo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 61})
public class aj implements x {
    public int hn;
    public long hw;
    public long pr;
    public int x;

    public void pr(long j) {
        this.pr = j;
    }

    public void pr(int i) {
        this.x = i;
    }

    public void hw(long j) {
        this.hw = j;
    }

    public void hw(int i) {
        this.hn = i;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_start_duration", this.pr);
            jSONObject.put("video_cache_size", this.hw);
            jSONObject.put("is_auto_play", this.hn);
            jSONObject.put("is_supplement_replay", this.x);
        } catch (Throwable th) {
        }
    }
}
