package com.byazt.jdi;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1553, 37})
public class pr {
    public final JSONObject c = new JSONObject();
    public String hn;
    public long hw;
    public String pr;
    public int uc;
    public String x;

    public void pr(String str) {
        this.pr = str;
    }

    public String pr() {
        return this.pr;
    }

    public void pr(long j) {
        this.hw = j;
    }

    public void hw(String str) {
        this.hn = str;
    }

    public void pr(int i) {
        this.uc = i;
    }

    public void hn(String str) {
        this.x = str;
    }

    public JSONObject hw() {
        return this.c;
    }

    public void hn() {
        try {
            this.c.putOpt("duration", Long.valueOf(this.hw));
            if ("d_i0".equals(this.pr) || "d_a0".equals(this.pr)) {
                this.c.putOpt("data", new JSONObject(this.hn));
            } else {
                this.c.putOpt("data", this.hn);
            }
            this.c.putOpt(MediationConstant.KEY_ERROR_MSG, this.x);
        } catch (JSONException e) {
            com.byazt.wx.pr.pr("__kite json error " + e.getMessage());
        }
    }

    public String toString() {
        return "FingerInfo{name='" + this.pr + "', duration=" + this.hw + ", data='" + this.hn + "', error='" + this.x + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
