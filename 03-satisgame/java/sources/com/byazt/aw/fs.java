package com.byazt.aw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 101})
public class fs {
    public final n n;
    public final boolean q;
    public final com.byazt.ccr.fs qg;
    public final com.byazt.ccr.q s;

    public enum n {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public fs(n nVar, com.byazt.ccr.fs fsVar, com.byazt.ccr.q qVar, boolean z) {
        this.n = nVar;
        this.qg = fsVar;
        this.s = qVar;
        this.q = z;
    }

    public n n() {
        return this.n;
    }

    public com.byazt.ccr.fs qg() {
        return this.qg;
    }

    public com.byazt.ccr.q s() {
        return this.s;
    }

    public boolean q() {
        return this.q;
    }
}
