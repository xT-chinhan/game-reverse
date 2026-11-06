package com.anythink.core.common.b;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    private int a;
    private int b;
    private int c;
    private long d;
    private int e;

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

    public final int c() {
        return this.c;
    }

    private void c(int i) {
        this.c = i;
    }

    public final long d() {
        return this.d;
    }

    private void a(long j) {
        this.d = j;
    }

    public final int e() {
        return this.e;
    }

    private void d(int i) {
        this.e = i;
    }

    public static g a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        g gVar = new g();
        gVar.a = jSONObject.optInt("core_size", 0);
        gVar.b = jSONObject.optInt("max_size", 0);
        gVar.c = jSONObject.optInt("queue_size", 0);
        gVar.d = jSONObject.optLong("keep_alive", 0L);
        gVar.e = jSONObject.optInt("priority", 0);
        return gVar;
    }

    public static g a(int i, int i2, int i3, int i4, int i5) {
        g gVar = new g();
        gVar.a = i;
        gVar.b = i2;
        gVar.c = i3;
        gVar.d = i4;
        gVar.e = i5;
        return gVar;
    }
}
