package com.byazt.ahu;

import com.anythink.core.common.l.f;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1308, 19})
public class n {
    public final JSONObject l = new JSONObject();
    public String n;
    public String q;
    public long qg;
    public String s;
    public int w;

    public void n(String str) {
        this.n = str;
    }

    public String n() {
        return this.n;
    }

    public void n(long j) {
        this.qg = j;
    }

    public void qg(String str) {
        this.s = str;
    }

    public void n(int i) {
        this.w = i;
    }

    public void s(String str) {
        this.q = str;
    }

    public JSONObject qg() {
        return this.l;
    }

    public void s() {
        try {
            this.l.putOpt(MediationConstant.EXTRA_DURATION, Long.valueOf(this.qg));
            if ("d_i0".equals(this.n) || "d_a0".equals(this.n)) {
                this.l.putOpt(f.R, new JSONObject(this.s));
            } else {
                this.l.putOpt(f.R, this.s);
            }
            this.l.putOpt(MediationConstant.KEY_ERROR_MSG, this.q);
        } catch (JSONException e) {
            com.byazt.nt.n.n("__kite json error " + e.getMessage());
        }
    }

    public String toString() {
        return "FingerInfo{name='" + this.n + "', duration=" + this.qg + ", data='" + this.s + "', error='" + this.q + "'}";
    }
}
