package com.bytedance.sdk.openadsdk.core.nw;

import com.anythink.core.common.e.n;
import com.umeng.ccg.a;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u {
    private int ab;
    private String ah;
    private String ao;
    private int c;
    private long ch;
    private long d;
    private String h;
    private long hi;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private long f3100ms;
    private String ny;
    private String qv;
    private int sl;
    private String u;
    private String ub;
    private long x;
    private String xr;
    private long zb;

    public static u ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        u uVar = new u();
        uVar.f3100ms = jSONObject.optLong("user_id");
        uVar.xr = jSONObject.optString("coupon_meta_id");
        uVar.ah = jSONObject.optString("unique_id");
        uVar.d = jSONObject.optLong("device_id");
        uVar.ka = jSONObject.optBoolean("has_coupon");
        uVar.c = jSONObject.optInt("coupon_scene");
        uVar.ab = jSONObject.optInt("type");
        uVar.x = jSONObject.optLong("threshold");
        uVar.ny = jSONObject.optString("scene_key");
        uVar.ch = jSONObject.optLong("activity_id");
        uVar.hi = jSONObject.optLong(com.tapsdk.tapad.internal.tracker.experiment.d.q);
        uVar.sl = jSONObject.optInt(a.z);
        uVar.zb = jSONObject.optLong("style");
        uVar.u = jSONObject.optString("start_time");
        uVar.ub = jSONObject.optString(n.a.g);
        uVar.ao = jSONObject.optString("button_text");
        uVar.h = jSONObject.optString("extra");
        uVar.qv = jSONObject.optString("toast");
        return uVar;
    }

    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.f3100ms);
            jSONObject.put("coupon_meta_id", this.xr);
            jSONObject.put("unique_id", this.ah);
            jSONObject.put("device_id", this.d);
            jSONObject.put("has_coupon", this.ka);
            jSONObject.put("coupon_scene", this.c);
            jSONObject.put("type", this.ab);
            jSONObject.put("threshold", this.x);
            jSONObject.put("scene_key", this.ny);
            jSONObject.put("activity_id", this.ch);
            jSONObject.put(com.tapsdk.tapad.internal.tracker.experiment.d.q, this.hi);
            jSONObject.put(a.z, this.sl);
            jSONObject.put("style", this.zb);
            jSONObject.put("start_time", this.u);
            jSONObject.put(n.a.g, this.ub);
            jSONObject.put("button_text", this.ao);
            jSONObject.put("extra", this.h);
            jSONObject.put("toast", this.qv);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    public JSONObject xr() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.f3100ms);
            jSONObject.put("coupon_meta_id", this.xr);
            jSONObject.put("unique_id", this.ah);
            jSONObject.put("device_id", this.d);
            jSONObject.put("type", this.ab);
            jSONObject.put("scene_key", this.ny);
            jSONObject.put("activity_id", this.ch);
            jSONObject.put(com.anythink.core.common.e.f.a.d, this.hi);
            jSONObject.put("threshold", this.x);
            jSONObject.put("extra", this.h);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    public int ah() {
        return this.c;
    }

    public int getType() {
        return this.ab;
    }

    public String d() {
        return this.qv;
    }

    public boolean ms(boolean z) {
        int i;
        boolean z2 = this.ka && this.hi > 0;
        if (z) {
            if (z2 && ((i = this.c) == 0 || i == 5)) {
                return true;
            }
        } else if (z2 && this.c == 5) {
            return true;
        }
        return false;
    }
}
