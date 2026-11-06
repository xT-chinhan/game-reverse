package com.byazt.aqe;

import android.app.Activity;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 13})
public class w extends n {
    public int cd;
    public int hd;

    @Override // com.byazt.aqe.qg
    public void n(com.byazt.mr.w wVar) {
    }

    @Override // com.byazt.aqe.qg
    public int x() {
        return 3;
    }

    public w(Activity activity, pk pkVar, ry ryVar) {
        JSONObject jSONObjectQg;
        super(activity, pkVar, ryVar);
        if (this.rv == null || (jSONObjectQg = this.rv.qg()) == null) {
            return;
        }
        this.hd = jSONObjectQg.optInt("reduce_time");
        this.cd = jSONObjectQg.optInt("reduce_duration");
    }

    @Override // com.byazt.aqe.qg
    public boolean w() {
        return (this.rv == null || !this.rv.w()) && this.hd > 0 && this.cd > 0 && this.qg < this.cd;
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        return s(tjVar);
    }

    @Override // com.byazt.aqe.qg
    public void q(tj tjVar) {
        if (tjVar != null) {
            tjVar.n(this.hd);
        }
        this.rv.n(true);
        if (tjVar != null) {
            tjVar.n();
        }
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.hd + com.anythink.core.common.s.a);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
