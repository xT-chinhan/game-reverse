package com.byazt.aw;

import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 18})
public class l implements s {
    public final com.byazt.ccr.qg fs;
    public final com.byazt.ccr.w l;
    public final x n;
    public final com.byazt.ccr.q q;
    public final Path.FillType qg;
    public final com.byazt.ccr.qg rv;
    public final com.byazt.ccr.s s;
    public final boolean tj;
    public final com.byazt.ccr.w w;
    public final String x;

    public l(String str, x xVar, Path.FillType fillType, com.byazt.ccr.s sVar, com.byazt.ccr.q qVar, com.byazt.ccr.w wVar, com.byazt.ccr.w wVar2, com.byazt.ccr.qg qgVar, com.byazt.ccr.qg qgVar2, boolean z) {
        this.n = xVar;
        this.qg = fillType;
        this.s = sVar;
        this.q = qVar;
        this.l = wVar;
        this.w = wVar2;
        this.x = str;
        this.fs = qgVar;
        this.rv = qgVar2;
        this.tj = z;
    }

    public String n() {
        return this.x;
    }

    public x qg() {
        return this.n;
    }

    public Path.FillType s() {
        return this.qg;
    }

    public com.byazt.ccr.s q() {
        return this.s;
    }

    public com.byazt.ccr.q l() {
        return this.q;
    }

    public com.byazt.ccr.w w() {
        return this.l;
    }

    public com.byazt.ccr.w x() {
        return this.w;
    }

    public boolean fs() {
        return this.tj;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.fs(fsVar, wVar, sVar, this);
    }
}
