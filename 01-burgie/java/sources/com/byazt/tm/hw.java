package com.byazt.tm;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2289, 13})
public class hw {
    public float c;
    public long hn;
    public int hw;
    public int pr;
    public float x;

    public hw(JSONObject jSONObject) {
        this.pr = 0;
        this.hw = 0;
        this.hn = 0L;
        this.x = 0.1f;
        this.c = 0.1f;
        if (jSONObject == null) {
            return;
        }
        this.pr = jSONObject.optInt("time");
        this.hw = jSONObject.optInt("type");
        this.hn = jSONObject.optLong("duration");
        this.x = (float) jSONObject.optDouble("intensity");
        this.c = (float) jSONObject.optDouble("density");
        if (this.hw == 1 || this.hn < 100) {
            pr(100L);
        }
    }

    public int pr() {
        return this.pr;
    }

    public int getType() {
        return this.hw;
    }

    public long hw() {
        return this.hn;
    }

    public void pr(long j) {
        this.hn = j;
    }

    public float hn() {
        return this.x;
    }

    public float x() {
        return this.c;
    }
}
