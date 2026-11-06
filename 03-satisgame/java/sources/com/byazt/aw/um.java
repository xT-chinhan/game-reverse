package com.byazt.aw;

import com.byazt.sp.py;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 33})
public class um implements s {
    public final com.byazt.ccr.qg l;
    public final String n;
    public final com.byazt.ccr.qg q;
    public final n qg;
    public final com.byazt.ccr.qg s;
    public final boolean w;

    public enum n {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static n n(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public um(String str, n nVar, com.byazt.ccr.qg qgVar, com.byazt.ccr.qg qgVar2, com.byazt.ccr.qg qgVar3, boolean z) {
        this.n = str;
        this.qg = nVar;
        this.s = qgVar;
        this.q = qgVar2;
        this.l = qgVar3;
        this.w = z;
    }

    public String n() {
        return this.n;
    }

    public n getType() {
        return this.qg;
    }

    public com.byazt.ccr.qg qg() {
        return this.q;
    }

    public com.byazt.ccr.qg s() {
        return this.s;
    }

    public com.byazt.ccr.qg q() {
        return this.l;
    }

    public boolean l() {
        return this.w;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new py(sVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.s + ", end: " + this.q + ", offset: " + this.l + "}";
    }
}
