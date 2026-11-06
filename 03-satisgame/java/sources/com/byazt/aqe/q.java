package com.byazt.aqe;

import android.app.Activity;
import android.text.TextUtils;
import com.anythink.core.common.d.f;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 5})
public class q extends n {
    public String a;
    public int cd;
    public int hd;
    public String um;

    @Override // com.byazt.aqe.qg
    public int x() {
        return 6;
    }

    public q(Activity activity, pk pkVar, ry ryVar) {
        JSONObject jSONObjectOptJSONObject;
        super(activity, pkVar, ryVar);
        JSONObject jSONObjectQg = ryVar.qg();
        if (jSONObjectQg == null || (jSONObjectOptJSONObject = jSONObjectQg.optJSONObject("coupon")) == null) {
            return;
        }
        this.hd = jSONObjectOptJSONObject.optInt("amount");
        this.cd = jSONObjectOptJSONObject.optInt("threshold");
        this.um = jSONObjectOptJSONObject.optString(f.a);
        this.a = jSONObjectOptJSONObject.optString("expire_time");
    }

    @Override // com.byazt.aqe.qg
    public boolean w() {
        return (this.hd == 0 || this.cd == 0) ? false : true;
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        return s(tjVar);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("amount", this.hd);
            jSONObject.put("threshold", "满" + this.cd + "元可用");
            if (TextUtils.isEmpty(this.um)) {
                str = TextUtils.isEmpty(this.a) ? "领取当日起30分钟内有效" : "有效期至" + this.a;
            } else if (TextUtils.isEmpty(this.a)) {
                str = "有效期至" + this.um;
            } else {
                str = "有效期" + this.um + "至" + this.a;
            }
            jSONObject.put(f.a, this.um);
            jSONObject.put("expire_text", str);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
