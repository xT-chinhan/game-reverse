package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 18})
public class l {
    public int l;
    public String n;
    public int q;
    public String qg;
    public String s;
    public int w;
    public String x;

    public String n() {
        return this.x;
    }

    public void n(String str) {
        this.x = str;
    }

    public String qg() {
        return this.n;
    }

    public void qg(String str) {
        this.n = str;
    }

    public String s() {
        return this.qg;
    }

    public void s(String str) {
        this.qg = str;
    }

    public String q() {
        return this.s;
    }

    public void q(String str) {
        this.s = str;
    }

    public int l() {
        return this.q;
    }

    public void n(int i) {
        this.q = i;
    }

    public int w() {
        return this.l;
    }

    public void qg(int i) {
        this.l = i;
    }

    public int x() {
        return this.w;
    }

    public void s(int i) {
        this.w = i;
    }

    public JSONObject fs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", s());
            jSONObject.put("app_size", x());
            jSONObject.put("comment_num", w());
            jSONObject.put(SDMAdConst.NETWORK_CUSTOM_KEY.DOWNLOAD_URL, qg());
            jSONObject.put("package_name", q());
            jSONObject.put("score", l());
        } catch (Exception e) {
            com.byazt.tk.k.n(e.toString());
        }
        return jSONObject;
    }
}
