package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.component.utils.sl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class xr {
    private JSONObject d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f2520ms;
    private String xr;
    private long ah = 0;
    private boolean ka = d.xr;

    public static xr ms(JSONObject jSONObject) {
        xr xrVar = new xr();
        if (jSONObject != null) {
            xrVar.ms(jSONObject.optString("ec_mall_back_url"));
            xrVar.f2520ms = jSONObject.optBoolean("sub_process", false);
            xrVar.ah = jSONObject.optLong("init_delay", d.f2512ms);
            xrVar.d = jSONObject.optJSONObject("live_tob_init_extra");
            xrVar.ms(jSONObject.optString("ec_mall_back_url"));
            xrVar.ka = jSONObject.optBoolean("init_after_click", d.xr);
        }
        return xrVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.xr);
            jSONObject.put("sub_process", this.f2520ms);
            jSONObject.put("init_delay", this.ah);
            jSONObject.put("live_tob_init_extra", this.d);
            jSONObject.put("init_after_click", this.ka);
        } catch (Exception e) {
            sl.xr("AppLiveConfig", e);
        }
        return jSONObject.toString();
    }

    public boolean ms() {
        return this.f2520ms;
    }

    public long xr() {
        return this.ah;
    }

    public JSONObject ah() {
        return this.d;
    }

    public String d() {
        return this.xr;
    }

    public void ms(String str) {
        this.xr = str;
    }

    public boolean ka() {
        return this.ka;
    }
}
