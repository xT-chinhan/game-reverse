package com.byazt.gct;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID})
public class ci {
    public sz l;
    public hd n;
    public String q;
    public ic qg;
    public dg s;

    public static ci n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ci ciVar = new ci();
        hd hdVar = new hd();
        ciVar.n = hdVar;
        hdVar.qg(jSONObject.optString("deeplink_url", ""));
        ciVar.qg = ic.n(jSONObject.optJSONObject("saas_info"));
        ciVar.s = dg.n(jSONObject.optJSONObject("live_info"));
        ciVar.q = jSONObject.optString("ecom_live_params");
        ciVar.l = sz.n(jSONObject.optJSONObject("coupon"));
        if (TextUtils.isEmpty(ciVar.n.qg())) {
            return null;
        }
        return ciVar;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            hd hdVar = this.n;
            if (hdVar != null) {
                jSONObject.put("deeplink_url", hdVar.qg());
            }
            ic icVar = this.qg;
            if (icVar != null) {
                jSONObject.put("saas_info", icVar.n());
            }
            dg dgVar = this.s;
            if (dgVar != null) {
                jSONObject.put("live_info", dgVar.n());
            }
            String str = this.q;
            if (str != null) {
                jSONObject.put("ecom_live_params", str);
            }
            sz szVar = this.l;
            if (szVar != null) {
                jSONObject.put("coupon", szVar.n());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public sz qg() {
        return this.l;
    }

    public hd s() {
        return this.n;
    }

    public ic q() {
        return this.qg;
    }

    public String l() {
        return this.q;
    }

    public dg w() {
        return this.s;
    }
}
