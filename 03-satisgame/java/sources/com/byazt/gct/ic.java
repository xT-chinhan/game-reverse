package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 2228})
public class ic {
    public int l;
    public int n;
    public int q;
    public int qg;
    public long s;

    public static ic n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ic icVar = new ic();
        icVar.n = jSONObject.optInt("auth_type");
        icVar.qg = jSONObject.optInt("auth_time");
        icVar.s = jSONObject.optLong("auth_out_time");
        icVar.q = jSONObject.optInt("video_open_deeplink");
        icVar.l = jSONObject.optInt("reject_in");
        return icVar;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.n);
            jSONObject.put("auth_time", this.qg);
            jSONObject.put("auth_out_time", this.s);
            jSONObject.put("video_open_deeplink", this.q);
            jSONObject.put("reject_in", this.l);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public int qg() {
        return this.n;
    }

    public int s() {
        return this.qg;
    }

    public int q() {
        return this.q;
    }

    public long l() {
        return this.s;
    }

    public int w() {
        return this.l;
    }
}
