package com.byazt.aw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 113})
public class d implements s {
    public final boolean l;
    public final String n;
    public final com.byazt.ccr.d q;
    public final com.byazt.ccr.qg qg;
    public final com.byazt.ccr.qg s;

    public d(String str, com.byazt.ccr.qg qgVar, com.byazt.ccr.qg qgVar2, com.byazt.ccr.d dVar, boolean z) {
        this.n = str;
        this.qg = qgVar;
        this.s = qgVar2;
        this.q = dVar;
        this.l = z;
    }

    public String n() {
        return this.n;
    }

    public com.byazt.ccr.qg qg() {
        return this.qg;
    }

    public com.byazt.ccr.qg s() {
        return this.s;
    }

    public com.byazt.ccr.d q() {
        return this.q;
    }

    public boolean l() {
        return this.l;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.cy(fsVar, sVar, this);
    }
}
