package com.mcto.sspsdk.internal;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 {
    public final String a;
    public final String b;

    public m0(JSONObject jSONObject) {
        this.a = jSONObject.optString("token");
        this.b = jSONObject.optString("key");
    }
}
