package com.byazt.ynb;

import android.graphics.Path;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 19})
public class ho implements hn {
    public final com.byazt.eqw.x c;
    public final String hn;
    public final Path.FillType hw;
    public final boolean pr;
    public final boolean uc;
    public final com.byazt.eqw.pr x;

    public ho(String str, boolean z, Path.FillType fillType, com.byazt.eqw.pr prVar, com.byazt.eqw.x xVar, boolean z2) {
        this.hn = str;
        this.pr = z;
        this.hw = fillType;
        this.x = prVar;
        this.c = xVar;
        this.uc = z2;
    }

    public String pr() {
        return this.hn;
    }

    public com.byazt.eqw.pr hw() {
        return this.x;
    }

    public com.byazt.eqw.x hn() {
        return this.c;
    }

    public Path.FillType x() {
        return this.hw;
    }

    public boolean c() {
        return this.uc;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.fw(zoVar, hnVar, this);
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.pr + AbstractJsonLexerKt.END_OBJ;
    }
}
