package com.smartdigimkt.h0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public final String a;
    public final String b;

    public g(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return com.smartdigimkt.f.i.a(new StringBuilder("code[ ").append(this.a).append(" ],desc[ "), this.b, " ]");
    }
}
