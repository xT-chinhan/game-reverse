package com.byazt.bz;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 762, 26})
public class qg {
    public float l;
    public int n;
    public float q;
    public int qg;
    public long s;

    public qg(JSONObject jSONObject) {
        this.n = 0;
        this.qg = 0;
        this.s = 0L;
        this.q = 0.1f;
        this.l = 0.1f;
        if (jSONObject == null) {
            return;
        }
        this.n = jSONObject.optInt("time");
        this.qg = jSONObject.optInt("type");
        this.s = jSONObject.optLong(MediationConstant.EXTRA_DURATION);
        this.q = (float) jSONObject.optDouble("intensity");
        this.l = (float) jSONObject.optDouble("density");
        if (this.qg == 1 || this.s < 100) {
            n(100L);
        }
    }

    public int n() {
        return this.n;
    }

    public int getType() {
        return this.qg;
    }

    public long qg() {
        return this.s;
    }

    public void n(long j) {
        this.s = j;
    }

    public float s() {
        return this.q;
    }

    public float q() {
        return this.l;
    }
}
