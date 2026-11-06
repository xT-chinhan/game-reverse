package com.byazt.lm;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public JSONObject hn;
    public String hw;
    public String pr;
    public JSONObject x;

    public static zo pr() {
        return new zo();
    }

    public zo pr(JSONObject jSONObject) {
        this.x = jSONObject;
        return this;
    }

    public zo pr(String str) {
        this.pr = str;
        return this;
    }

    public zo hw(String str) {
        this.hw = str;
        return this;
    }

    public zo hw(JSONObject jSONObject) {
        this.hn = jSONObject;
        return this;
    }

    public String hw() {
        return this.pr;
    }

    public String hn() {
        return this.hw;
    }

    public JSONObject x() {
        return this.hn;
    }

    public JSONObject c() {
        return this.x;
    }
}
