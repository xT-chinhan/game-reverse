package com.byazt.yey;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND, 50})
public class vk implements aj {
    @Override // com.byazt.yey.aj
    public boolean pr(com.byazt.tia.hw hwVar, int i, zo zoVar) {
        if (hwVar == null || !hw(hwVar.qa())) {
            return false;
        }
        if (System.currentTimeMillis() - hwVar.nw() > pr(hwVar.qa())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
        }
        com.byazt.mf.pr.pr().pr("pause_optimise", jSONObject, hwVar);
        return true;
    }

    private long pr(int i) {
        return com.byazt.ew.pr.pr(i).pr("pause_optimise_mistake_click_interval", TTAdConstant.DEFAULT_LIVE_SHOW_TIME_MAX);
    }

    private boolean hw(int i) {
        return com.byazt.ew.pr.pr(i).pr("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }
}
