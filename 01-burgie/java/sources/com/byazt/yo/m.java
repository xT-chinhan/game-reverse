package com.byazt.yo;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1051, 108})
public class m extends pr {
    public long hn;
    public long hw;
    public String pr;
    public long x;

    public void pr(String str) {
        this.pr = str;
    }

    public void pr(long j) {
        this.hw = j;
    }

    public void hw(long j) {
        this.hn = j;
    }

    public void hn(long j) {
        this.x = j;
    }

    @Override // com.byazt.yo.x
    public void pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.pr);
            jSONObject.put("preload_size", this.hw);
            jSONObject.put("load_time", this.hn);
            jSONObject.put("local_cache", this.x);
        } catch (Throwable th) {
        }
    }
}
