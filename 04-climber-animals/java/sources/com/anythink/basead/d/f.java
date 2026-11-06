package com.anythink.basead.d;

/* JADX INFO: loaded from: classes.dex */
public class f {
    protected String a;
    protected String b;

    protected f(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return "code[ " + this.a + " ],desc[ " + this.b + " ]";
    }
}
