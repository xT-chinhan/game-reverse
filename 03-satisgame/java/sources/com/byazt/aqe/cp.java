package com.byazt.aqe;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.gct.cx;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 29})
public class cp extends n {
    @Override // com.byazt.aqe.qg
    public int x() {
        return 2;
    }

    public cp(Activity activity, pk pkVar, ry ryVar) {
        super(activity, pkVar, ryVar);
    }

    @Override // com.byazt.aqe.qg
    public boolean w() {
        if (!cx.s(this.x)) {
            return false;
        }
        try {
            return (Integer.parseInt(this.d) == 0 || TextUtils.isEmpty(this.d) || TextUtils.isEmpty(this.cp)) ? false : true;
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        return s(tjVar);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "继续观看 " + this.n + "s 可获得奖励");
            jSONObject.put("number", this.d);
            jSONObject.put("number_unit", this.cp);
            jSONObject.put("remain_time", this.n);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
