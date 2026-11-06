package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gy {
    private String ah;
    private String d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f3054ms;
    private int xr;

    public gy(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f3054ms = jSONObject;
            this.xr = jSONObject.optInt("dialog_type");
            this.ah = jSONObject.optString("template_url");
            this.d = jSONObject.optString("template_md5");
        }
        com.bytedance.sdk.openadsdk.core.ugeno.c.ms msVar = new com.bytedance.sdk.openadsdk.core.ugeno.c.ms();
        msVar.xr(ka());
        msVar.ah(d());
    }

    public JSONObject ms() {
        return this.f3054ms;
    }

    public JSONObject xr() {
        return this.f3054ms;
    }

    public int ah() {
        return this.xr;
    }

    public String d() {
        return this.ah;
    }

    public String ka() {
        return this.d;
    }

    public boolean c() {
        return this.ka;
    }

    public void ms(boolean z) {
        this.ka = z;
    }
}
