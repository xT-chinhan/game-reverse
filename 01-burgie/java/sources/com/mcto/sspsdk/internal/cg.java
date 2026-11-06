package com.mcto.sspsdk.internal;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class cg {
    public final boolean a;
    public final String f;
    public final String g;
    public String h;
    public HashMap j;
    public final i7 k;
    public byte[] l;
    public final int[] m;
    public int b = 0;
    public final long c = System.currentTimeMillis();
    public long d = 0;
    public long e = 0;
    public String i = "application/x-www-form-urlencoded; charset=UTF-8";

    public cg(bg bgVar) {
        this.a = false;
        this.f = bgVar.b;
        this.h = bgVar.c;
        this.k = bgVar.e;
        this.l = bgVar.f;
        this.m = bgVar.g;
        this.a = bgVar.a;
        this.g = bgVar.d;
        this.j = bgVar.h;
    }

    public final String toString() {
        return "requestCount: " + this.b + ", total: " + (this.e - this.c) + ", netTotal: " + (this.e - this.d) + ", url: '" + this.f + "', data: '" + lj.a(this.l) + "'";
    }
}
