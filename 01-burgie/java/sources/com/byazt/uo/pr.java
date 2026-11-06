package com.byazt.uo;

import com.byazt.kf.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 217, 37})
public final class pr {
    public long hn;
    public final long hw;
    public final com.byazt.tj.pr pr;

    public pr(com.byazt.tj.pr prVar, long j) {
        this.pr = prVar;
        this.hw = j;
    }

    public com.byazt.tj.pr pr() {
        return this.pr;
    }

    public void pr(long j) {
        this.hn = j;
    }

    public boolean pr(long j, boolean z) {
        if (j < this.hw) {
            return false;
        }
        long j2 = this.hn;
        if (j2 <= 0) {
            return true;
        }
        if (z) {
            return j <= j2 + 5000;
        }
        return j <= j2;
    }

    public boolean hw(long j) {
        long j2 = this.hn;
        return j2 > 0 && j - j2 > x.pr().hn();
    }

    public JSONObject hw() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ad_session", this.pr.pr());
        jSONObject.put("req_id", this.pr.hw());
        jSONObject.put("rit", this.pr.hn());
        jSONObject.put("creative_id", this.pr.c());
        jSONObject.put(MediationConstant.EXTRA_ADID, this.pr.uc());
        jSONObject.put("ad_slot_type", this.pr.x());
        return jSONObject;
    }
}
