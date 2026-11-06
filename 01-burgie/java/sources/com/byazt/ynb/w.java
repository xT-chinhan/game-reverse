package com.byazt.ynb;

import android.graphics.PointF;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 109})
public class w implements hn {
    public final boolean c;
    public final com.byazt.eqw.m<PointF, PointF> hn;
    public final com.byazt.eqw.m<PointF, PointF> hw;
    public final String pr;
    public final com.byazt.eqw.hw x;

    public w(String str, com.byazt.eqw.m<PointF, PointF> mVar, com.byazt.eqw.m<PointF, PointF> mVar2, com.byazt.eqw.hw hwVar, boolean z) {
        this.pr = str;
        this.hw = mVar;
        this.hn = mVar2;
        this.x = hwVar;
        this.c = z;
    }

    public String pr() {
        return this.pr;
    }

    public com.byazt.eqw.hw hw() {
        return this.x;
    }

    public com.byazt.eqw.m<PointF, PointF> hn() {
        return this.hn;
    }

    public com.byazt.eqw.m<PointF, PointF> x() {
        return this.hw;
    }

    public boolean c() {
        return this.c;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.ho(zoVar, hnVar, this);
    }

    public String toString() {
        return "RectangleShape{position=" + this.hw + ", size=" + this.hn + AbstractJsonLexerKt.END_OBJ;
    }
}
