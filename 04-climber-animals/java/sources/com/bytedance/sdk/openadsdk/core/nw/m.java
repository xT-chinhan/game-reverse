package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private String ah;
    private String d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3068ms;
    private int xr;

    public static m ms(String str) {
        try {
            return ms(new JSONObject(str));
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.xr("LiveSdkConfig", "parse failed:".concat(String.valueOf(e)));
            return new m();
        }
    }

    public static m ms(JSONObject jSONObject) {
        m mVar = new m();
        mVar.ms(jSONObject.optInt("ad_live_status"));
        mVar.xr(jSONObject.optInt("app_id"));
        mVar.xr(jSONObject.optString("partner"));
        mVar.ah(jSONObject.optString("secure_key"));
        return mVar;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", ms());
            jSONObject.put("app_id", xr());
            jSONObject.put("partner", ah());
            jSONObject.put("secure_key", d());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject.toString();
    }

    public int ms() {
        return this.f3068ms;
    }

    public int xr() {
        return this.xr;
    }

    public String ah() {
        return this.ah;
    }

    public String d() {
        return this.d;
    }

    public void ms(int i) {
        this.f3068ms = i;
    }

    public void xr(int i) {
        this.xr = i;
    }

    public void xr(String str) {
        this.ah = str;
    }

    public void ah(String str) {
        this.d = str;
    }

    public boolean ka() {
        return this.f3068ms == 1;
    }
}
