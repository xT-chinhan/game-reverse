package com.anythink.core.common.h;

/* JADX INFO: loaded from: classes.dex */
public final class aq {
    private String a;
    private String b;
    private String c;
    private int d;
    private int e;
    private String f;

    private static aq g() {
        return new aq();
    }

    public final String toString() {
        return "EcpmEncDecInfo{uniqueId='" + this.a + "', ecpmEncryptInfo='" + this.b + "', ecpmEncPubKey='" + this.c + "', ecpmDecPvtKeyServerId=" + this.d + ", ecpmDecPvtKeyClientId=" + this.e + ", ecpmRmbEncryptInfo='" + this.f + "'}";
    }

    public final String a() {
        return this.a;
    }

    public final void a(String str) {
        this.a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        this.b = str;
    }

    public final String c() {
        return this.c;
    }

    public final void c(String str) {
        this.c = str;
    }

    public final int d() {
        return this.d;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final int e() {
        return this.e;
    }

    public final void b(int i) {
        this.e = i;
    }

    public final String f() {
        return this.f;
    }

    public final void d(String str) {
        this.f = str;
    }
}
