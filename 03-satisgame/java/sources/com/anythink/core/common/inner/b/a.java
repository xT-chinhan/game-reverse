package com.anythink.core.common.inner.b;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    protected String a;
    protected String b;

    protected a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    private String c() {
        return "code[ " + this.a + " ],desc[ " + this.b + " ]";
    }
}
