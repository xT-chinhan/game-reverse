package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class rt {
    private String ab;
    private String ah;
    private int c;
    private String d;
    private JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3092ms;
    private String xr;

    public String ms() {
        return this.f3092ms;
    }

    public String xr() {
        return this.xr;
    }

    public String ah() {
        return this.ah;
    }

    public String d() {
        return this.d;
    }

    public JSONObject ka() {
        return this.ka;
    }

    public String c() {
        return this.ab;
    }

    public int ab() {
        return this.c;
    }

    public static rt ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        rt rtVar = new rt();
        rtVar.f3092ms = jSONObject.optString("id");
        rtVar.d = jSONObject.optString("data");
        rtVar.ah = jSONObject.optString("url");
        rtVar.xr = jSONObject.optString("md5");
        rtVar.ab = jSONObject.optString("express_gesture_priority");
        rtVar.c = jSONObject.optInt("material_type");
        rtVar.ka = jSONObject.optJSONObject("custom_components");
        return rtVar;
    }

    public JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f3092ms);
            jSONObject.put("md5", this.xr);
            jSONObject.put("url", this.ah);
            jSONObject.put("data", this.d);
            jSONObject.put("material_type", this.c);
            jSONObject.put("custom_components", this.ka);
            jSONObject.put("express_gesture_priority", this.ab);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }
}
