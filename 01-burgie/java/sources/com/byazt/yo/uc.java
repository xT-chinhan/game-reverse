package com.byazt.yo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 5})
public class uc implements x {
    public long hw;
    public long pr;

    public void pr(long j) {
        this.pr = j;
    }

    public void hw(long j) {
        this.hw = j;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.pr);
            jSONObject.put("total_duration", this.hw);
        } catch (Throwable th) {
        }
    }
}
