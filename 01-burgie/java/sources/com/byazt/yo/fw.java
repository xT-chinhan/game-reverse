package com.byazt.yo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 62})
public class fw implements x {
    public int hn = 0;
    public long hw;
    public long pr;

    public void pr(long j) {
        this.pr = j;
    }

    public void hw(long j) {
        this.hw = j;
    }

    public void pr(int i) {
        this.hn = i;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.pr);
            jSONObject.put("buffers_time", this.hw);
            jSONObject.put("video_backup", this.hn);
        } catch (Throwable th) {
        }
    }
}
