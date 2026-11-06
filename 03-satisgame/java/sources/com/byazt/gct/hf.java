package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 938})
public class hf {
    public boolean n;
    public int qg;

    public hf(JSONObject jSONObject) {
        this.n = jSONObject.optBoolean("enable_reward_callback");
        this.qg = jSONObject.optInt("browse_duration_limit", 10);
    }

    public boolean n() {
        return this.n;
    }

    public int qg() {
        return this.qg;
    }

    public void n(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("enable_reward_callback", n());
            jSONObject2.put("browse_duration_limit", qg());
            jSONObject.put("self_reward_callback", jSONObject2);
        } catch (JSONException unused) {
        }
    }
}
