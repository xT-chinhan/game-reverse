package com.byazt.udb;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1064, 113})
public class d implements tj.n {
    public k n;
    public AtomicBoolean q = new AtomicBoolean(false);
    public List<tj> qg;
    public rv s;

    public d(List<tj> list, rv rvVar) {
        this.qg = list;
        this.s = rvVar;
    }

    @Override // com.byazt.udb.tj.n
    public void n() {
        this.s.w();
        Iterator<tj> it = this.qg.iterator();
        while (it.hasNext() && !it.next().n(this)) {
        }
    }

    @Override // com.byazt.udb.tj.n
    public void n(tj tjVar) {
        int iIndexOf = this.qg.indexOf(tjVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.qg.size()) {
                return;
            }
        } while (!this.qg.get(iIndexOf).n(this));
    }

    @Override // com.byazt.udb.tj.n
    public boolean qg(tj tjVar) {
        int iIndexOf = this.qg.indexOf(tjVar);
        return iIndexOf < this.qg.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.byazt.udb.tj.n
    public k qg() {
        return this.n;
    }

    @Override // com.byazt.udb.tj.n
    public void n(k kVar) {
        this.n = kVar;
    }

    @Override // com.byazt.udb.tj.n
    public void n(boolean z) {
        this.q.getAndSet(z);
    }

    @Override // com.byazt.udb.tj.n
    public boolean s() {
        return this.q.get();
    }
}
