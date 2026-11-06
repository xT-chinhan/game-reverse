package com.byazt.ynb;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 47, 13})
public class hw implements hn {
    public final boolean c;
    public final com.byazt.eqw.uc hn;
    public final com.byazt.eqw.m<PointF, PointF> hw;
    public final String pr;
    public final boolean x;

    public hw(String str, com.byazt.eqw.m<PointF, PointF> mVar, com.byazt.eqw.uc ucVar, boolean z, boolean z2) {
        this.pr = str;
        this.hw = mVar;
        this.hn = ucVar;
        this.x = z;
        this.c = z2;
    }

    @Override // com.byazt.ynb.hn
    public com.byazt.ova.hn pr(com.byazt.dx.zo zoVar, com.byazt.dx.uc ucVar, com.byazt.cg.hn hnVar) {
        return new com.byazt.ova.uc(zoVar, hnVar, this);
    }

    public String pr() {
        return this.pr;
    }

    public com.byazt.eqw.m<PointF, PointF> hw() {
        return this.hw;
    }

    public com.byazt.eqw.uc hn() {
        return this.hn;
    }

    public boolean x() {
        return this.x;
    }

    public boolean c() {
        return this.c;
    }
}
