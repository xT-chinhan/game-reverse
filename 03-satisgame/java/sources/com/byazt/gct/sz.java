package com.byazt.gct;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.core.internal.event.constants.TapEventParamConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING, 110})
public class sz {
    public String cd;
    public long cp;
    public String cy;
    public int d;
    public long fs;
    public String hd;
    public String k;
    public boolean l;
    public long n;
    public long oa;
    public long q;
    public String qg;
    public String rv;
    public String s;
    public String sz;
    public long tj;
    public int w;
    public int x;

    public static sz n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sz szVar = new sz();
        szVar.n = jSONObject.optLong("user_id");
        szVar.qg = jSONObject.optString("coupon_meta_id");
        szVar.s = jSONObject.optString(com.anythink.core.e.l.a.aA);
        szVar.q = jSONObject.optLong(TapEventParamConstants.PARAM_DEVICE_ID);
        szVar.l = jSONObject.optBoolean("has_coupon");
        szVar.w = jSONObject.optInt("coupon_scene");
        szVar.x = jSONObject.optInt("type");
        szVar.fs = jSONObject.optLong("threshold");
        szVar.rv = jSONObject.optString("scene_key");
        szVar.tj = jSONObject.optLong("activity_id");
        szVar.cp = jSONObject.optLong("amount");
        szVar.d = jSONObject.optInt("action");
        szVar.oa = jSONObject.optLong("style");
        szVar.sz = jSONObject.optString(com.anythink.core.common.d.f.a);
        szVar.k = jSONObject.optString("expire_time");
        szVar.cy = jSONObject.optString("button_text");
        szVar.hd = jSONObject.optString("extra");
        szVar.cd = jSONObject.optString("toast");
        return szVar;
    }

    public JSONObject n() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.n);
            jSONObject.put("coupon_meta_id", this.qg);
            jSONObject.put(com.anythink.core.e.l.a.aA, this.s);
            jSONObject.put(TapEventParamConstants.PARAM_DEVICE_ID, this.q);
            jSONObject.put("has_coupon", this.l);
            jSONObject.put("coupon_scene", this.w);
            jSONObject.put("type", this.x);
            jSONObject.put("threshold", this.fs);
            jSONObject.put("scene_key", this.rv);
            jSONObject.put("activity_id", this.tj);
            jSONObject.put("amount", this.cp);
            jSONObject.put("action", this.d);
            jSONObject.put("style", this.oa);
            jSONObject.put(com.anythink.core.common.d.f.a, this.sz);
            jSONObject.put("expire_time", this.k);
            jSONObject.put("button_text", this.cy);
            jSONObject.put("extra", this.hd);
            jSONObject.put("toast", this.cd);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject qg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.n);
            jSONObject.put("coupon_meta_id", this.qg);
            jSONObject.put(com.anythink.core.e.l.a.aA, this.s);
            jSONObject.put(TapEventParamConstants.PARAM_DEVICE_ID, this.q);
            jSONObject.put("type", this.x);
            jSONObject.put("scene_key", this.rv);
            jSONObject.put("activity_id", this.tj);
            jSONObject.put(com.anythink.core.common.f.e.a.d, this.cp);
            jSONObject.put("threshold", this.fs);
            jSONObject.put("extra", this.hd);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void n(String str) {
        this.cd = str;
    }

    public int s() {
        return this.w;
    }

    public void n(boolean z) {
        this.l = z;
    }

    public void n(int i) {
        this.w = i;
    }

    public void n(long j) {
        this.cp = j;
    }

    public int getType() {
        return this.x;
    }

    public String q() {
        return this.cd;
    }

    public boolean qg(boolean z) {
        int i;
        boolean z2 = this.l && this.cp > 0;
        if (z) {
            if (z2 && ((i = this.w) == 0 || i == 5)) {
                return true;
            }
        } else if (z2 && this.w == 5) {
            return true;
        }
        return false;
    }
}
