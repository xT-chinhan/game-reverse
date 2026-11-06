package com.byazt.ova;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 423, 213})
public class cz implements com.byazt.al.pr.InterfaceC0016pr, hn {
    public final com.byazt.al.pr<?, Float> c;
    public final com.byazt.al.pr<?, Float> fw;
    public final List<com.byazt.al.pr.InterfaceC0016pr> hn = new ArrayList();
    public final boolean hw;
    public final String pr;
    public final com.byazt.al.pr<?, Float> uc;
    public final com.byazt.ynb.qa.pr x;

    public cz(com.byazt.cg.hn hnVar, com.byazt.ynb.qa qaVar) {
        this.pr = qaVar.pr();
        this.hw = qaVar.c();
        this.x = qaVar.getType();
        com.byazt.al.pr<Float, Float> prVarPr = qaVar.hn().pr();
        this.c = prVarPr;
        com.byazt.al.pr<Float, Float> prVarPr2 = qaVar.hw().pr();
        this.uc = prVarPr2;
        com.byazt.al.pr<Float, Float> prVarPr3 = qaVar.x().pr();
        this.fw = prVarPr3;
        hnVar.pr(prVarPr);
        hnVar.pr(prVarPr2);
        hnVar.pr(prVarPr3);
        prVarPr.pr(this);
        prVarPr2.pr(this);
        prVarPr3.pr(this);
    }

    @Override // com.byazt.al.pr.InterfaceC0016pr
    public void pr() {
        for (int i = 0; i < this.hn.size(); i++) {
            this.hn.get(i).pr();
        }
    }

    @Override // com.byazt.ova.hn
    public void pr(List<hn> list, List<hn> list2) {
    }

    public void pr(com.byazt.al.pr.InterfaceC0016pr interfaceC0016pr) {
        this.hn.add(interfaceC0016pr);
    }

    public com.byazt.ynb.qa.pr getType() {
        return this.x;
    }

    public com.byazt.al.pr<?, Float> hw() {
        return this.c;
    }

    public com.byazt.al.pr<?, Float> hn() {
        return this.uc;
    }

    public com.byazt.al.pr<?, Float> x() {
        return this.fw;
    }

    public boolean c() {
        return this.hw;
    }
}
