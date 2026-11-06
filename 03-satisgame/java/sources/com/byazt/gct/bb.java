package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF})
public class bb {
    public g n;
    public final JSONObject qg;

    public bb(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.qg = jSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("game_client")) == null) {
            return;
        }
        this.n = new g(jSONObjectOptJSONObject.optJSONObject("components"), 6);
    }

    public g n() {
        return this.n;
    }

    public JSONObject qg() {
        return this.qg;
    }

    public boolean s() {
        g gVar = this.n;
        return gVar != null && gVar.k();
    }
}
