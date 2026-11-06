package com.byazt.wv;

import android.app.Activity;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.an;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 5})
public class uc extends pr {
    public int lb;
    public int yb;

    public uc(Activity activity, of ofVar, pj pjVar) {
        JSONObject jSONObjectHw;
        super(activity, ofVar, pjVar);
        if (this.aj != null && (jSONObjectHw = this.aj.hw()) != null) {
            this.yb = jSONObjectHw.optInt("reduce_time");
            this.lb = jSONObjectHw.optInt("reduce_duration");
        }
    }

    @Override // com.byazt.wv.hw
    public int fw() {
        return 3;
    }

    @Override // com.byazt.wv.hw
    public boolean uc() {
        return (this.aj == null || !this.aj.uc()) && this.yb > 0 && this.lb > 0 && this.hw < this.lb;
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(vk vkVar) {
        return hn(vkVar);
    }

    @Override // com.byazt.wv.hw
    public void pr(com.byazt.nc.uc ucVar) {
    }

    @Override // com.byazt.wv.hw
    public void x(vk vkVar) {
        if (vkVar != null) {
            vkVar.pr(this.yb);
        }
        this.aj.pr(true);
        if (vkVar != null) {
            vkVar.pr();
        }
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.yb + an.aB);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
