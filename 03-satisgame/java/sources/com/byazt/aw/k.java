package com.byazt.aw;

import android.graphics.Path;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1026, 210})
public class k implements s {
    public final com.byazt.ccr.q l;
    public final boolean n;
    public final com.byazt.ccr.n q;
    public final Path.FillType qg;
    public final String s;
    public final boolean w;

    public k(String str, boolean z, Path.FillType fillType, com.byazt.ccr.n nVar, com.byazt.ccr.q qVar, boolean z2) {
        this.s = str;
        this.n = z;
        this.qg = fillType;
        this.q = nVar;
        this.l = qVar;
        this.w = z2;
    }

    public String n() {
        return this.s;
    }

    public com.byazt.ccr.n qg() {
        return this.q;
    }

    public com.byazt.ccr.q s() {
        return this.l;
    }

    public Path.FillType q() {
        return this.qg;
    }

    public boolean l() {
        return this.w;
    }

    @Override // com.byazt.aw.s
    public com.byazt.sp.s n(com.byazt.pp.fs fsVar, com.byazt.pp.w wVar, com.byazt.eg.s sVar) {
        return new com.byazt.sp.x(fsVar, sVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.n + AbstractJsonLexerKt.END_OBJ;
    }
}
