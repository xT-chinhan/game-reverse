package com.byazt.aqe;

import android.app.Activity;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 21})
public class x extends n {
    @Override // com.byazt.aqe.qg
    public int x() {
        return 4;
    }

    public x(Activity activity, pk pkVar, ry ryVar) {
        super(activity, pkVar, ryVar);
    }

    @Override // com.byazt.aqe.qg
    public boolean w() {
        return this.w;
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        return s(tjVar);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "参与互动可以领取福利");
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
