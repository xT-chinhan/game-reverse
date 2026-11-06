package com.byazt.hg;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO})
public class od {
    public g c;
    public qi hn;
    public lv hw;
    public yb pr;
    public String x;

    public static od pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        od odVar = new od();
        yb ybVar = new yb();
        odVar.pr = ybVar;
        ybVar.hw(jSONObject.optString("deeplink_url", ""));
        odVar.hw = lv.pr(jSONObject.optJSONObject("saas_info"));
        odVar.hn = qi.pr(jSONObject.optJSONObject("live_info"));
        odVar.x = jSONObject.optString("ecom_live_params");
        odVar.c = g.pr(jSONObject.optJSONObject("coupon"));
        if (TextUtils.isEmpty(odVar.pr.hw())) {
            return null;
        }
        return odVar;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            yb ybVar = this.pr;
            if (ybVar != null) {
                jSONObject.put("deeplink_url", ybVar.hw());
            }
            lv lvVar = this.hw;
            if (lvVar != null) {
                jSONObject.put("saas_info", lvVar.pr());
            }
            qi qiVar = this.hn;
            if (qiVar != null) {
                jSONObject.put("live_info", qiVar.pr());
            }
            String str = this.x;
            if (str != null) {
                jSONObject.put("ecom_live_params", str);
            }
            g gVar = this.c;
            if (gVar != null) {
                jSONObject.put("coupon", gVar.pr());
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public g hw() {
        return this.c;
    }

    public yb hn() {
        return this.pr;
    }

    public lv x() {
        return this.hw;
    }

    public String c() {
        return this.x;
    }

    public qi uc() {
        return this.hn;
    }
}
