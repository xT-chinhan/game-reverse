package com.mcto.sspsdk.internal;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;

    public g0(JSONObject jSONObject) {
        this.a = 3;
        this.a = jSONObject.optInt("plt", 3);
        this.b = jSONObject.optInt("adnAdType", 2);
        this.c = jSONObject.optInt("adnType", 4);
        this.d = jSONObject.optString("codeId");
        this.e = jSONObject.optString("adnAdDropNewUser", "0");
    }

    public final String toString() {
        return "AdnCode{plt=" + this.a + ", adnAdType=" + this.b + ", adnType=" + this.c + ", codeId='" + this.d + "', adnAdDropNewUser='" + this.e + "'}";
    }
}
