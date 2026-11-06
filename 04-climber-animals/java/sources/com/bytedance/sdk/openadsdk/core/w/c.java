package com.bytedance.sdk.openadsdk.core.w;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f3677ms;

    public c(JSONObject jSONObject) {
        this.f3677ms = jSONObject;
    }

    public String toString() {
        JSONObject jSONObject = this.f3677ms;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }

    public int ms() {
        JSONObject jSONObject = this.f3677ms;
        if (jSONObject != null) {
            return jSONObject.optInt("code", -1);
        }
        return -1;
    }
}
