package com.bytedance.sdk.openadsdk.core.nw;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int f3036ms = 1;
    int xr = 1;

    public void ms(int i) {
        this.f3036ms = i;
    }

    public void xr(int i) {
        this.xr = i;
    }

    public boolean ms() {
        return this.f3036ms == 1;
    }

    public boolean xr() {
        return this.xr == 1;
    }

    public JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.f3036ms);
            jSONObject.put("am", this.xr);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.xr(e.toString());
        }
        return jSONObject;
    }
}
