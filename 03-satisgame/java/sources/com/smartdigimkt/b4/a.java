package com.smartdigimkt.b4;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public int a;

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.a = jSONObject.optInt("net_type", 1);
        return aVar;
    }
}
