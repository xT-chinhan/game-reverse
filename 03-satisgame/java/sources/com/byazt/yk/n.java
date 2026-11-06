package com.byazt.yk;

import com.byazt.dg.qg;
import com.byazt.xx.l;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1176, 19})
public class n extends com.byazt.le.n {
    public final double l;
    public final double q;
    public final double w;

    public n(qg qgVar, com.byazt.le.n.InterfaceC0236n interfaceC0236n, double d, double d2, double d3) {
        super(qgVar, interfaceC0236n);
        this.q = d;
        this.l = d2;
        this.w = d3;
    }

    @Override // com.byazt.le.n
    public void n(l lVar, qg.q qVar, double d) {
        lVar.l = this.q + (lVar.x / 2.0d);
        lVar.w = (this.l - this.w) - (lVar.fs / 2.0d);
    }
}
