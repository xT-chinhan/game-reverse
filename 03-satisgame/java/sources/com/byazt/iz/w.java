package com.byazt.iz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 861, 13})
public class w implements q {
    public List<q> n = new ArrayList();
    public s qg = new s(com.byazt.nf.rv.qg().eq());

    public w() {
        this.n.add(new l(this.qg));
        this.n.add(new x(this.qg));
    }

    @Override // com.byazt.iz.q
    public boolean n(com.byazt.esa.n nVar) {
        Iterator<q> it = this.n.iterator();
        while (it.hasNext()) {
            if (it.next().n(nVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.iz.q
    public boolean qg(com.byazt.esa.n nVar) {
        Iterator<q> it = this.n.iterator();
        while (it.hasNext()) {
            if (it.next().qg(nVar)) {
                return true;
            }
        }
        return false;
    }
}
