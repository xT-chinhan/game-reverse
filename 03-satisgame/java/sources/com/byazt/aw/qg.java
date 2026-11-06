package com.byazt.aw;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 26})
public class qg implements s {
    public final boolean l;
    public final String n;
    public final boolean q;
    public final com.byazt.ccr.oa<PointF, PointF> qg;
    public final com.byazt.ccr.w s;

    public qg(String str, com.byazt.ccr.oa<PointF, PointF> oaVar, com.byazt.ccr.w wVar, boolean z, boolean z2) {
        this.n = str;
        this.qg = oaVar;
        this.s = wVar;
        this.q = z;
        this.l = z2;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.w(fsVar, sVar, this);
    }

    public String n() {
        return this.n;
    }

    public com.byazt.ccr.oa<PointF, PointF> qg() {
        return this.qg;
    }

    public com.byazt.ccr.w s() {
        return this.s;
    }

    public boolean q() {
        return this.q;
    }

    public boolean l() {
        return this.l;
    }
}
