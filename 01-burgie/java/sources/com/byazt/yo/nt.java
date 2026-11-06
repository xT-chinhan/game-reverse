package com.byazt.yo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 74})
public class nt implements x {
    public boolean hw;
    public long pr;

    public void pr(long j) {
        this.pr = j;
    }

    public void pr(boolean z) {
        this.hw = z;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("video_cache_size", this.pr);
            jSONObject.put("is_auto_play", this.hw);
        } catch (Throwable th) {
        }
    }
}
