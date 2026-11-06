package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 745})
public class u {
    public int n;
    public String q;
    public int qg;
    public String s;

    public static u n(String str) {
        try {
            return n(new JSONObject(str));
        } catch (JSONException unused) {
            return new u();
        }
    }

    public static u n(JSONObject jSONObject) {
        u uVar = new u();
        uVar.n(jSONObject.optInt("ad_live_status"));
        uVar.qg(jSONObject.optInt("app_id"));
        uVar.qg(jSONObject.optString("partner"));
        uVar.s(jSONObject.optString("secure_key"));
        return uVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", n());
            jSONObject.put("app_id", qg());
            jSONObject.put("partner", s());
            jSONObject.put("secure_key", q());
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public int n() {
        return this.n;
    }

    public int qg() {
        return this.qg;
    }

    public String s() {
        return this.s;
    }

    public String q() {
        return this.q;
    }

    public void n(int i) {
        this.n = i;
    }

    public void qg(int i) {
        this.qg = i;
    }

    public void qg(String str) {
        this.s = str;
    }

    public void s(String str) {
        this.q = str;
    }

    public boolean l() {
        return this.n == 1;
    }
}
