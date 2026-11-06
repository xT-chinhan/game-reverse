package com.byazt.wp;

import com.byazt.md.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX, 19})
public final class n {
    public final com.byazt.gd.n n;
    public final long qg;
    public long s;

    public n(com.byazt.gd.n nVar, long j) {
        this.n = nVar;
        this.qg = j;
    }

    public com.byazt.gd.n n() {
        return this.n;
    }

    public void n(long j) {
        this.s = j;
    }

    public boolean n(long j, boolean z) {
        if (j < this.qg) {
            return false;
        }
        long j2 = this.s;
        if (j2 <= 0) {
            return true;
        }
        if (z) {
            return j <= j2 + 5000;
        }
        return j <= j2;
    }

    public boolean qg(long j) {
        long j2 = this.s;
        return j2 > 0 && j - j2 > q.n().s();
    }

    public JSONObject qg() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("ad_session", this.n.n());
        jSONObject.put("req_id", this.n.qg());
        jSONObject.put("rit", this.n.s());
        jSONObject.put("creative_id", this.n.l());
        jSONObject.put(MediationConstant.EXTRA_ADID, this.n.w());
        jSONObject.put("ad_slot_type", this.n.q());
        return jSONObject;
    }
}
