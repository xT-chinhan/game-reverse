package com.byazt.hg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mar.sdk.IAction;
import com.tapsdk.tapad.group.constants.Constants;
import com.tapsdk.tapad.internal.runtime.bundle.BundleId;
import com.taptap.sdk.db.constant.Common;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g {
    public String aj;
    public boolean c;
    public int fw;
    public String g;
    public String hn;
    public String ho;
    public String hw;
    public int k;
    public String lb;
    public long m;
    public String nt;
    public long pr;
    public int uc;
    public long vk;
    public long w;
    public long x;
    public String yb;
    public long zo;

    public static g pr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.pr = jSONObject.optLong(Common.System.USER_ID);
        gVar.hw = jSONObject.optString("coupon_meta_id");
        gVar.hn = jSONObject.optString("unique_id");
        gVar.x = jSONObject.optLong("device_id");
        gVar.c = jSONObject.optBoolean("has_coupon");
        gVar.uc = jSONObject.optInt("coupon_scene");
        gVar.fw = jSONObject.optInt("type");
        gVar.zo = jSONObject.optLong("threshold");
        gVar.aj = jSONObject.optString("scene_key");
        gVar.vk = jSONObject.optLong("activity_id");
        gVar.w = jSONObject.optLong(IAction.BuyKey.CostAmount);
        gVar.k = jSONObject.optInt("action");
        gVar.m = jSONObject.optLong(BundleId.STYLE);
        gVar.g = jSONObject.optString(com.umeng.analytics.pro.d.p);
        gVar.ho = jSONObject.optString("expire_time");
        gVar.nt = jSONObject.optString("button_text");
        gVar.yb = jSONObject.optString("extra");
        gVar.lb = jSONObject.optString("toast");
        return gVar;
    }

    public JSONObject pr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Common.System.USER_ID, this.pr);
            jSONObject.put("coupon_meta_id", this.hw);
            jSONObject.put("unique_id", this.hn);
            jSONObject.put("device_id", this.x);
            jSONObject.put("has_coupon", this.c);
            jSONObject.put("coupon_scene", this.uc);
            jSONObject.put("type", this.fw);
            jSONObject.put("threshold", this.zo);
            jSONObject.put("scene_key", this.aj);
            jSONObject.put("activity_id", this.vk);
            jSONObject.put(IAction.BuyKey.CostAmount, this.w);
            jSONObject.put("action", this.k);
            jSONObject.put(BundleId.STYLE, this.m);
            jSONObject.put(com.umeng.analytics.pro.d.p, this.g);
            jSONObject.put("expire_time", this.ho);
            jSONObject.put("button_text", this.nt);
            jSONObject.put("extra", this.yb);
            jSONObject.put("toast", this.lb);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public JSONObject hw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Common.System.USER_ID, this.pr);
            jSONObject.put("coupon_meta_id", this.hw);
            jSONObject.put("unique_id", this.hn);
            jSONObject.put("device_id", this.x);
            jSONObject.put("type", this.fw);
            jSONObject.put("scene_key", this.aj);
            jSONObject.put("activity_id", this.vk);
            jSONObject.put(Constants.VALUE_FIELD, this.w);
            jSONObject.put("threshold", this.zo);
            jSONObject.put("extra", this.yb);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void pr(String str) {
        this.lb = str;
    }

    public int hn() {
        return this.uc;
    }

    public void pr(boolean z) {
        this.c = z;
    }

    public void pr(int i) {
        this.uc = i;
    }

    public void pr(long j) {
        this.w = j;
    }

    public int getType() {
        return this.fw;
    }

    public String x() {
        return this.lb;
    }

    public boolean hw(boolean z) {
        int i;
        boolean z2 = this.c && this.w > 0;
        if (z) {
            return z2 && ((i = this.uc) == 0 || i == 5);
        }
        return z2 && this.uc == 5;
    }
}
