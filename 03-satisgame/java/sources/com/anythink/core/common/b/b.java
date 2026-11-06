package com.anythink.core.common.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    private int a;
    private int b;

    public final int a() {
        return this.a;
    }

    private void a(int i) {
        this.a = i;
    }

    public final int b() {
        return this.b;
    }

    private void b(int i) {
        this.b = i;
    }

    public static b a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        bVar.a = jSONObject.optInt("period_days", 7);
        bVar.b = jSONObject.optInt("max_count", 2);
        return bVar;
    }

    public static b c() {
        b bVar = new b();
        bVar.a = 7;
        bVar.b = 2;
        return bVar;
    }
}
