package com.byazt.hg;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {
    public static volatile String pr;
    public boolean aj;
    public JSONObject c;
    public String fw;
    public String hn;
    public String hw;
    public int uc;
    public int x;
    public String zo;

    public static void pr(String str) {
        pr = str;
    }

    public yb() {
        this.fw = "";
        this.zo = "";
    }

    public yb(JSONObject jSONObject) {
        this.fw = "";
        this.zo = "";
        if (jSONObject == null) {
            return;
        }
        hw(jSONObject.optString("deeplink_url"));
        hn(jSONObject.optString("fallback_url"));
        pr(jSONObject.optInt("fallback_type"));
        this.c = jSONObject.optJSONObject("addon_params");
        this.uc = jSONObject.optInt("fallback_landing");
        this.fw = jSONObject.optString("fallback_landing_ugen_url");
        this.zo = jSONObject.optString("fallback_landing_ugen_md5");
    }

    public void pr(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("deeplink_url", hw());
            jSONObject2.put("fallback_url", x());
            jSONObject2.put("fallback_type", c());
            jSONObject2.put("addon_params", this.c);
            jSONObject2.put("fallback_landing", this.uc);
            jSONObject2.put("fallback_landing_ugen_url", this.fw);
            jSONObject2.put("fallback_landing_ugen_md5", this.zo);
            jSONObject.put("deep_link", jSONObject2);
        } catch (JSONException e) {
        }
    }

    public boolean pr() {
        return this.aj;
    }

    public void pr(boolean z) {
        this.aj = z;
    }

    public String hw() {
        return x(pr);
    }

    public int hn() {
        return this.uc;
    }

    private String x(String str) {
        if (this.c != null && !TextUtils.isEmpty(str) && this.hw != null) {
            String strOptString = this.c.optString(str);
            if (!TextUtils.isEmpty(strOptString)) {
                return this.hw + (this.hw.contains("?") ? "&" : "?") + strOptString;
            }
        }
        return this.hw;
    }

    public void hw(String str) {
        this.hw = str;
    }

    public String x() {
        return this.hn;
    }

    public void hn(String str) {
        this.hn = str;
    }

    public int c() {
        return this.x;
    }

    public void pr(int i) {
        this.x = i;
    }

    public String uc() {
        return this.fw;
    }

    public String fw() {
        return this.zo;
    }

    public void pr(yb ybVar) {
        if (ybVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(ybVar.hw())) {
            hw(ybVar.hw());
        }
        if (!TextUtils.isEmpty(ybVar.x())) {
            hn(ybVar.x());
        }
        if (ybVar.c() != 0) {
            pr(ybVar.c());
        }
    }
}
