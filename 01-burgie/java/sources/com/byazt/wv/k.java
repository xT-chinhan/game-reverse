package com.byazt.wv;

import android.app.Activity;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 250})
public class k extends pr {
    public k(Activity activity, of ofVar, pj pjVar) {
        super(activity, ofVar, pjVar);
    }

    @Override // com.byazt.wv.hw
    public int fw() {
        return 1;
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(vk vkVar) {
        return hn(vkVar);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.pr);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
