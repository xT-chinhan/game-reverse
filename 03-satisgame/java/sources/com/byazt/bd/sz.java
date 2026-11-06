package com.byazt.bd;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 110})
public class sz extends n<PointF, PointF> {
    public final n<Float, Float> fs;
    public com.byazt.yt.s<Float> l;
    public com.byazt.yt.s<Float> q;
    public final n<Float, Float> rv;
    public final PointF w;
    public final PointF x;

    public sz(n<Float, Float> nVar, n<Float, Float> nVar2) {
        super(Collections.emptyList());
        this.w = new PointF();
        this.x = new PointF();
        this.fs = nVar;
        this.rv = nVar2;
        n(fs());
    }

    @Override // com.byazt.bd.n
    public void n(float f) {
        this.fs.n(f);
        this.rv.n(f);
        this.w.set(this.fs.x().floatValue(), this.rv.x().floatValue());
        for (int i = 0; i < this.n.size(); i++) {
            this.n.get(i).n();
        }
    }

    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: rv, reason: merged with bridge method [inline-methods] */
    public PointF x() {
        return n(null, 0.0f);
    }

    @Override // com.byazt.bd.n
    /* JADX INFO: renamed from: qg, reason: merged with bridge method [inline-methods] */
    public PointF n(com.byazt.yt.n<PointF> nVar, float f) {
        Float fN;
        com.byazt.yt.n<Float> nVarS;
        com.byazt.yt.n<Float> nVarS2;
        Float fN2 = null;
        if (this.q == null || (nVarS2 = this.fs.s()) == null) {
            fN = null;
        } else {
            float fL = this.fs.l();
            Float f2 = nVarS2.x;
            fN = this.q.n(nVarS2.w, f2 == null ? nVarS2.w : f2.floatValue(), nVarS2.n, nVarS2.qg, f, f, fL);
        }
        if (this.l != null && (nVarS = this.rv.s()) != null) {
            float fL2 = this.rv.l();
            Float f3 = nVarS.x;
            fN2 = this.l.n(nVarS.w, f3 == null ? nVarS.w : f3.floatValue(), nVarS.n, nVarS.qg, f, f, fL2);
        }
        if (fN == null) {
            this.x.set(this.w.x, 0.0f);
        } else {
            this.x.set(fN.floatValue(), 0.0f);
        }
        if (fN2 == null) {
            PointF pointF = this.x;
            pointF.set(pointF.x, this.w.y);
        } else {
            PointF pointF2 = this.x;
            pointF2.set(pointF2.x, fN2.floatValue());
        }
        return this.x;
    }
}
