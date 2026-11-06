package com.byazt.aw;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 13})
public class w implements s {
    public final List<com.byazt.ccr.qg> cp;
    public final com.byazt.ccr.qg d;
    public final cd.n fs;
    public final com.byazt.ccr.w l;
    public final String n;
    public final boolean oa;
    public final com.byazt.ccr.q q;
    public final x qg;
    public final cd.qg rv;
    public final com.byazt.ccr.s s;
    public final float tj;
    public final com.byazt.ccr.w w;
    public final com.byazt.ccr.qg x;

    public w(String str, x xVar, com.byazt.ccr.s sVar, com.byazt.ccr.q qVar, com.byazt.ccr.w wVar, com.byazt.ccr.w wVar2, com.byazt.ccr.qg qgVar, cd.n nVar, cd.qg qgVar2, float f, List<com.byazt.ccr.qg> list, com.byazt.ccr.qg qgVar3, boolean z) {
        this.n = str;
        this.qg = xVar;
        this.s = sVar;
        this.q = qVar;
        this.l = wVar;
        this.w = wVar2;
        this.x = qgVar;
        this.fs = nVar;
        this.rv = qgVar2;
        this.tj = f;
        this.cp = list;
        this.d = qgVar3;
        this.oa = z;
    }

    public String n() {
        return this.n;
    }

    public x qg() {
        return this.qg;
    }

    public com.byazt.ccr.s s() {
        return this.s;
    }

    public com.byazt.ccr.q q() {
        return this.q;
    }

    public com.byazt.ccr.w l() {
        return this.l;
    }

    public com.byazt.ccr.w w() {
        return this.w;
    }

    public com.byazt.ccr.qg x() {
        return this.x;
    }

    public cd.n fs() {
        return this.fs;
    }

    public cd.qg rv() {
        return this.rv;
    }

    public List<com.byazt.ccr.qg> tj() {
        return this.cp;
    }

    public com.byazt.ccr.qg cp() {
        return this.d;
    }

    public float d() {
        return this.tj;
    }

    public boolean oa() {
        return this.oa;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.rv(fsVar, sVar, this);
    }
}
