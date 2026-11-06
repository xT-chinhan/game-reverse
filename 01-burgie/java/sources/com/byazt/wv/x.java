package com.byazt.wv;

import android.app.Activity;
import android.text.TextUtils;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.IAction;
import com.umeng.analytics.pro.d;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 121})
public class x extends pr {
    public String a;
    public int lb;
    public String qa;
    public int yb;

    public x(Activity activity, of ofVar, pj pjVar) {
        JSONObject jSONObjectOptJSONObject;
        super(activity, ofVar, pjVar);
        JSONObject jSONObjectHw = pjVar.hw();
        if (jSONObjectHw != null && (jSONObjectOptJSONObject = jSONObjectHw.optJSONObject("coupon")) != null) {
            this.yb = jSONObjectOptJSONObject.optInt(IAction.BuyKey.CostAmount);
            this.lb = jSONObjectOptJSONObject.optInt("threshold");
            this.qa = jSONObjectOptJSONObject.optString(d.p);
            this.a = jSONObjectOptJSONObject.optString("expire_time");
        }
    }

    @Override // com.byazt.wv.hw
    public int fw() {
        return 6;
    }

    @Override // com.byazt.wv.hw
    public boolean uc() {
        return (this.yb == 0 || this.lb == 0) ? false : true;
    }

    @Override // com.byazt.wv.pr, com.byazt.wv.hw
    public hw.pr hw(vk vkVar) {
        return hn(vkVar);
    }

    @Override // com.byazt.wv.hw
    public String pr() {
        String str;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAction.BuyKey.CostAmount, this.yb);
            jSONObject.put("threshold", "满" + this.lb + "元可用");
            if (TextUtils.isEmpty(this.qa)) {
                if (TextUtils.isEmpty(this.a)) {
                    str = "领取当日起30分钟内有效";
                } else {
                    str = "有效期至" + this.a;
                }
            } else if (TextUtils.isEmpty(this.a)) {
                str = "有效期至" + this.qa;
            } else {
                str = "有效期" + this.qa + "至" + this.a;
            }
            jSONObject.put(d.p, this.qa);
            jSONObject.put("expire_text", str);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
