package com.byazt.ji;

import com.byazt.qp.d;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 115, 26})
public class qg {
    public final boolean fs;
    public final String l;
    public final String n;
    public final String q;
    public final String qg;
    public final int rv;
    public final String s;
    public final int tj;
    public final int w;
    public final long x;

    public qg(String str, String str2, String str3, String str4, String str5, int i, long j, boolean z, int i2, int i3) {
        this.n = str;
        this.qg = str2;
        this.s = str3;
        this.q = str4;
        this.l = str5;
        this.w = i;
        this.x = j;
        this.fs = z;
        this.rv = i2;
        this.tj = i3;
    }

    public static qg n(com.byazt.sym.s sVar) {
        return new qg("acquire", sVar.n, sVar.qg, sVar.s, sVar.q, -1, sVar.l, sVar.w, sVar.x, sVar.fs);
    }

    public static qg n(com.byazt.sym.qg qgVar) {
        return new qg("bridge", qgVar.n, qgVar.qg, qgVar.q, "", qgVar.s, qgVar.l, qgVar.w, -1, -1);
    }

    public static qg n(String str, String str2, d dVar, boolean z) {
        return new qg(str, "ats", str2, "", "", -1, 0L, z, dVar == null ? -1 : dVar.n(), dVar != null ? dVar.l() : -1);
    }

    public String n() {
        return this.n + "#" + this.qg + "#" + this.s + "#" + this.l + "#" + this.w;
    }
}
