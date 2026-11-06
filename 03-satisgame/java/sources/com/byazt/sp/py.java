package com.byazt.sp;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1179, 866})
public class py implements s, com.byazt.bd.n.InterfaceC0134n {
    public final com.byazt.bd.n<?, Float> l;
    public final String n;
    public final com.byazt.aw.um.n q;
    public final boolean qg;
    public final List<com.byazt.bd.n.InterfaceC0134n> s = new ArrayList();
    public final com.byazt.bd.n<?, Float> w;
    public final com.byazt.bd.n<?, Float> x;

    @Override // com.byazt.sp.s
    public void n(List<s> list, List<s> list2) {
    }

    public py(com.byazt.eg.s sVar, com.byazt.aw.um umVar) {
        this.n = umVar.n();
        this.qg = umVar.l();
        this.q = umVar.getType();
        com.byazt.bd.n<Float, Float> nVarN = umVar.s().n();
        this.l = nVarN;
        com.byazt.bd.n<Float, Float> nVarN2 = umVar.qg().n();
        this.w = nVarN2;
        com.byazt.bd.n<Float, Float> nVarN3 = umVar.q().n();
        this.x = nVarN3;
        sVar.n(nVarN);
        sVar.n(nVarN2);
        sVar.n(nVarN3);
        nVarN.n(this);
        nVarN2.n(this);
        nVarN3.n(this);
    }

    @Override // com.byazt.bd.n.InterfaceC0134n
    public void n() {
        for (int i = 0; i < this.s.size(); i++) {
            this.s.get(i).n();
        }
    }

    public void n(com.byazt.bd.n.InterfaceC0134n interfaceC0134n) {
        this.s.add(interfaceC0134n);
    }

    public com.byazt.aw.um.n getType() {
        return this.q;
    }

    public com.byazt.bd.n<?, Float> qg() {
        return this.l;
    }

    public com.byazt.bd.n<?, Float> s() {
        return this.w;
    }

    public com.byazt.bd.n<?, Float> q() {
        return this.x;
    }

    public boolean l() {
        return this.qg;
    }
}
