package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG})
public class a {
    public int n = 1;
    public int qg = 1;

    public void n(int i) {
        this.n = i;
    }

    public void qg(int i) {
        this.qg = i;
    }

    public boolean n() {
        return this.n == 1;
    }

    public boolean qg() {
        return this.qg == 1;
    }

    public JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.n);
            jSONObject.put("am", this.qg);
        } catch (Exception e) {
            com.byazt.tk.k.n(e.toString());
        }
        return jSONObject;
    }
}
