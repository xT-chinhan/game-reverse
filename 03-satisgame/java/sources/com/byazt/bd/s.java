package com.byazt.bd;

import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 893, 8})
public class s implements n.InterfaceC0134n {
    public final n<Float, Float> l;
    public final n.InterfaceC0134n n;
    public final n<Float, Float> q;
    public final n<Integer, Integer> qg;
    public final n<Float, Float> s;
    public final n<Float, Float> w;
    public boolean x = true;

    public s(n.InterfaceC0134n interfaceC0134n, com.byazt.eg.s sVar, com.byazt.ur.tj tjVar) {
        this.n = interfaceC0134n;
        n<Integer, Integer> nVarN = tjVar.n().n();
        this.qg = nVarN;
        nVarN.n(this);
        sVar.n(nVarN);
        n<Float, Float> nVarN2 = tjVar.qg().n();
        this.s = nVarN2;
        nVarN2.n(this);
        sVar.n(nVarN2);
        n<Float, Float> nVarN3 = tjVar.s().n();
        this.q = nVarN3;
        nVarN3.n(this);
        sVar.n(nVarN3);
        n<Float, Float> nVarN4 = tjVar.q().n();
        this.l = nVarN4;
        nVarN4.n(this);
        sVar.n(nVarN4);
        n<Float, Float> nVarN5 = tjVar.l().n();
        this.w = nVarN5;
        nVarN5.n(this);
        sVar.n(nVarN5);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        this.x = true;
        this.n.n();
    }

    public void n(Paint paint) {
        if (this.x) {
            this.x = false;
            double dFloatValue = ((double) this.q.x().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.l.x().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.qg.x().intValue();
            paint.setShadowLayer(this.w.x().floatValue(), fSin, fCos, Color.argb(Math.round(this.s.x().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
