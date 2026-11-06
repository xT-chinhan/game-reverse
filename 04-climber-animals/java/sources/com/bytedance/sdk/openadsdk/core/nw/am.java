package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class am {
    private long ah;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3031ms;
    private int xr;

    public static am ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        am amVar = new am();
        amVar.f3031ms = jSONObject.optInt("auth_type");
        amVar.xr = jSONObject.optInt("auth_time");
        amVar.ah = jSONObject.optLong("auth_out_time");
        amVar.d = jSONObject.optInt("video_open_deeplink");
        amVar.ka = jSONObject.optInt("reject_in");
        return amVar;
    }

    public JSONObject ms() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.f3031ms);
            jSONObject.put("auth_time", this.xr);
            jSONObject.put("auth_out_time", this.ah);
            jSONObject.put("video_open_deeplink", this.d);
            jSONObject.put("reject_in", this.ka);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    public int xr() {
        return this.f3031ms;
    }

    public int ah() {
        return this.xr;
    }

    public int d() {
        return this.d;
    }

    public long ka() {
        return this.ah;
    }

    public int c() {
        return this.ka;
    }
}
