package com.anythink.core.common.h;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class bc {
    int a;
    boolean b;
    String c;
    boolean d;

    private bc() {
    }

    public static bc a(boolean z, String str, boolean z2) {
        bc bcVar = new bc();
        bcVar.a = 1;
        bcVar.b = z;
        bcVar.c = str;
        bcVar.d = z2;
        return bcVar;
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("from", this.a);
            int i = 1;
            jSONObject.put("is_playend", this.b ? 1 : 2);
            jSONObject.put("url", this.c);
            if (!this.d) {
                i = 2;
            }
            jSONObject.put("status", i);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
