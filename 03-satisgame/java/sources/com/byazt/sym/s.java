package com.byazt.sym;

import com.byazt.qp.d;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 78, 8})
public final class s {
    public final int fs;
    public final long l;
    public final String n;
    public final String q;
    public final String qg;
    public final String s;
    public final boolean w;
    public final int x;

    public s(String str, String str2, String str3, String str4, long j, boolean z, int i, int i2) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = str4;
        this.l = j;
        this.w = z;
        this.x = i;
        this.fs = i2;
    }

    public static s n(String str, String str2, String str3, String str4, long j, boolean z, d dVar, long j2) {
        return new s(str, str2, str3, str4, j2 - j, z, dVar == null ? -1 : dVar.n(), dVar != null ? dVar.l() : -1);
    }
}
