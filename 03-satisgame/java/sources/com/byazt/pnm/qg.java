package com.byazt.pnm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID, 26})
public final class qg {
    public boolean n;
    public JSONObject q;
    public String qg;
    public long s = 0;
    public boolean l = com.byazt.ivn.n.qg;

    public static qg n(JSONObject jSONObject) {
        qg qgVar = new qg();
        if (jSONObject != null) {
            qgVar.n(jSONObject.optString("ec_mall_back_url"));
            qgVar.n = jSONObject.optBoolean("sub_process", false);
            qgVar.s = jSONObject.optLong("init_delay", com.byazt.ivn.n.n);
            qgVar.q = jSONObject.optJSONObject("live_tob_init_extra");
            qgVar.n(jSONObject.optString("ec_mall_back_url"));
            qgVar.l = jSONObject.optBoolean("init_after_click", com.byazt.ivn.n.qg);
        }
        return qgVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.qg);
            jSONObject.put("sub_process", this.n);
            jSONObject.put("init_delay", this.s);
            jSONObject.put("live_tob_init_extra", this.q);
            jSONObject.put("init_after_click", this.l);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public boolean n() {
        return this.n;
    }

    public long qg() {
        return this.s;
    }

    public JSONObject s() {
        return this.q;
    }

    public String q() {
        return this.qg;
    }

    public void n(String str) {
        this.qg = str;
    }

    public boolean l() {
        return this.l;
    }
}
