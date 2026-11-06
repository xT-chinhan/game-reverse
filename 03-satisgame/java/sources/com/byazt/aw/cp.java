package com.byazt.aw;

import android.graphics.PointF;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 29})
public class cp implements s {
    public final boolean l;
    public final String n;
    public final com.byazt.ccr.qg q;
    public final com.byazt.ccr.oa<PointF, PointF> qg;
    public final com.byazt.ccr.oa<PointF, PointF> s;

    public cp(String str, com.byazt.ccr.oa<PointF, PointF> oaVar, com.byazt.ccr.oa<PointF, PointF> oaVar2, com.byazt.ccr.qg qgVar, boolean z) {
        this.n = str;
        this.qg = oaVar;
        this.s = oaVar2;
        this.q = qgVar;
        this.l = z;
    }

    public String n() {
        return this.n;
    }

    public com.byazt.ccr.qg qg() {
        return this.q;
    }

    public com.byazt.ccr.oa<PointF, PointF> s() {
        return this.s;
    }

    public com.byazt.ccr.oa<PointF, PointF> q() {
        return this.qg;
    }

    public boolean l() {
        return this.l;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.k(fsVar, sVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.qg + ", size=" + this.s + AbstractJsonLexerKt.END_OBJ;
    }
}
