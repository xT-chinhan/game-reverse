package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH})
public class ry {
    public boolean l;
    public JSONObject n;
    public String q;
    public int qg;
    public String s;

    public ry(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.n = jSONObject;
            this.qg = jSONObject.optInt("dialog_type");
            this.s = jSONObject.optString("template_url");
            this.q = jSONObject.optString("template_md5");
        }
        com.byazt.ai.n nVar = new com.byazt.ai.n();
        nVar.qg(l());
        nVar.s(q());
    }

    public JSONObject n() {
        return this.n;
    }

    public JSONObject qg() {
        return this.n;
    }

    public int s() {
        return this.qg;
    }

    public String q() {
        return this.s;
    }

    public String l() {
        return this.q;
    }

    public boolean w() {
        return this.l;
    }

    public void n(boolean z) {
        this.l = z;
    }
}
