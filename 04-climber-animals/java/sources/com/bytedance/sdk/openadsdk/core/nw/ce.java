package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ce {
    private String ab;
    private String ah;
    private int c;
    private String d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3038ms;
    private String x;
    private int xr;

    public String ms() {
        return this.f3038ms;
    }

    public int xr() {
        return this.xr;
    }

    public void ms(String str) {
        this.f3038ms = str;
    }

    public void ms(int i) {
        this.xr = i;
    }

    public String ah() {
        return this.ah;
    }

    public void xr(String str) {
        this.ah = str;
    }

    public String d() {
        return this.d;
    }

    public void ah(String str) {
        this.d = str;
    }

    public int ka() {
        return this.ka;
    }

    public void xr(int i) {
        this.ka = i;
    }

    public int c() {
        return this.c;
    }

    public void ah(int i) {
        this.c = i;
    }

    public String ab() {
        return this.ab;
    }

    public void d(String str) {
        this.ab = str;
    }

    public String x() {
        return this.x;
    }

    public void ka(String str) {
        this.x = str;
    }

    public String toString() {
        return ny().toString();
    }

    public JSONObject ny() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wc_skip_type", xr());
            jSONObject.put("wc_miniapp_link", ms());
            jSONObject.put("adv_id", ah());
            jSONObject.put("site_id", d());
            jSONObject.put("wc_open_method", c());
            jSONObject.put("wc_miniapp_sdk", ab());
            jSONObject.put("wc_appid", x());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms("toString failed:" + th.getMessage());
        }
        return jSONObject;
    }

    public static ce ms(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        ce ceVar = new ce();
        try {
            ceVar.ms(jSONObject.optInt("wc_skip_type"));
            ceVar.ms(jSONObject.optString("wc_miniapp_link"));
            ceVar.xr(jSONObject.optString("adv_id"));
            ceVar.ah(jSONObject.optString("site_id"));
            ceVar.ah(jSONObject.optInt("wc_open_method"));
            ceVar.d(jSONObject.optString("wc_miniapp_sdk"));
            ceVar.ka(jSONObject.optString("wc_appid"));
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.sl.ms("parse WechatData failed:" + th.getMessage());
        }
        return ceVar;
    }
}
