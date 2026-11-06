package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 121})
public class wv {
    public String fs;
    public int l;
    public String n;
    public String q;
    public int qg;
    public String s;
    public int w;
    public String x;

    public String n() {
        return this.n;
    }

    public int qg() {
        return this.qg;
    }

    public void n(String str) {
        this.n = str;
    }

    public void n(int i) {
        this.qg = i;
    }

    public String s() {
        return this.s;
    }

    public void qg(String str) {
        this.s = str;
    }

    public String q() {
        return this.q;
    }

    public void s(String str) {
        this.q = str;
    }

    public int l() {
        return this.l;
    }

    public void qg(int i) {
        this.l = i;
    }

    public int w() {
        return this.w;
    }

    public void s(int i) {
        this.w = i;
    }

    public String x() {
        return this.x;
    }

    public void q(String str) {
        this.x = str;
    }

    public String fs() {
        return this.fs;
    }

    public void l(String str) {
        this.fs = str;
    }

    public String toString() {
        return rv().toString();
    }

    public JSONObject rv() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", qg());
            jSONObject.put("wc_miniapp_link", n());
            jSONObject.put("adv_id", s());
            jSONObject.put("site_id", q());
            jSONObject.put("wc_open_method", w());
            jSONObject.put("wc_miniapp_sdk", x());
            jSONObject.put("wc_appid", fs());
        } catch (Throwable th) {
            th.getMessage();
        }
        return jSONObject;
    }

    public static wv n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        wv wvVar = new wv();
        try {
            wvVar.n(jSONObject.optInt("wc_skip_type"));
            wvVar.n(jSONObject.optString("wc_miniapp_link"));
            wvVar.qg(jSONObject.optString("adv_id"));
            wvVar.s(jSONObject.optString("site_id"));
            wvVar.s(jSONObject.optInt("wc_open_method"));
            wvVar.q(jSONObject.optString("wc_miniapp_sdk"));
            wvVar.l(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            th.getMessage();
        }
        return wvVar;
    }
}
