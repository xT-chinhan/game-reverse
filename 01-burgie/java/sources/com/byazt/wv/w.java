package com.byazt.wv;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 109})
public class w extends pr {
    public w(Activity activity, of ofVar, pj pjVar) {
        super(activity, ofVar, pjVar);
    }

    @Override // com.byazt.wv.hw
    public int fw() {
        return 2;
    }

    @Override // com.byazt.wv.hw
    public boolean uc() {
        if (!jn.hn(this.fw)) {
            return false;
        }
        try {
            return (Integer.parseInt(this.k) == 0 || TextUtils.isEmpty(this.k) || TextUtils.isEmpty(this.w)) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(vk vkVar) {
        return hn(vkVar);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "继续观看 " + this.pr + "s 可获得奖励");
            jSONObject.put("number", this.k);
            jSONObject.put("number_unit", this.w);
            jSONObject.put("remain_time", this.pr);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
