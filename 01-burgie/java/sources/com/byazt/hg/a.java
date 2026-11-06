package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public class a {
    public int pr = 1;
    public int hw = 1;

    public void pr(int i) {
        this.pr = i;
    }

    public void hw(int i) {
        this.hw = i;
    }

    public boolean pr() {
        return this.pr == 1;
    }

    public boolean hw() {
        return this.hw == 1;
    }

    public JSONObject hn() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.pr);
            jSONObject.put("am", this.hw);
        } catch (Exception e) {
            com.byazt.ca.ho.pr(e.toString());
        }
        return jSONObject;
    }
}
