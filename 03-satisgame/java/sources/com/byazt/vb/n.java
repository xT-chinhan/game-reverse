package com.byazt.vb;

import com.byazt.dg.qg;
import com.byazt.xx.l;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1160, 19})
public class n extends com.byazt.le.n {
    public final Random q;

    public n(qg qgVar, com.byazt.le.n.InterfaceC0236n interfaceC0236n) {
        super(qgVar, interfaceC0236n);
        this.q = new Random();
    }

    @Override // com.byazt.le.n
    public void n(l lVar, qg.q qVar, double d) {
        lVar.l = (lVar.x / 2.0d) + (this.q.nextDouble() * Math.max(1.0d, d - lVar.x));
        lVar.w = -lVar.fs;
    }
}
