package com.byazt.aqe;

import android.app.Activity;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 113})
public class d extends n {
    @Override // com.byazt.aqe.qg
    public int x() {
        return 1;
    }

    public d(Activity activity, pk pkVar, ry ryVar) {
        super(activity, pkVar, ryVar);
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        return s(tjVar);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.n);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
