package com.byazt.ob;

import com.byazt.vy.py;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1645, 18})
public class l implements n.InterfaceC0279n {
    public List<n> n = new CopyOnWriteArrayList();
    public com.byazt.dd.qg qg;
    public com.byazt.zb.qg s;

    public l(List<n> list) {
        if (py.n(list)) {
            return;
        }
        this.n.addAll(list);
    }

    public void n(com.byazt.zb.qg qgVar, com.byazt.dd.qg qgVar2) {
        this.s = qgVar;
        this.qg = qgVar2;
        if (py.n(this.n)) {
            return;
        }
        com.byazt.rb.l.n(new Runnable() { // from class: com.byazt.ob.l.1
            @Override // java.lang.Runnable
            public void run() {
                ((n) l.this.n.get(0)).n(l.this);
            }
        });
    }

    @Override // com.byazt.ob.n.InterfaceC0279n
    public com.byazt.dd.qg n() {
        return this.qg;
    }

    @Override // com.byazt.ob.n.InterfaceC0279n
    public com.byazt.zb.qg qg() {
        return this.s;
    }

    @Override // com.byazt.ob.n.InterfaceC0279n
    public void n(n nVar) {
        int iIndexOf;
        if (py.n(this.n) || nVar == null || (iIndexOf = this.n.indexOf(nVar)) == -1 || iIndexOf >= this.n.size() - 1) {
            return;
        }
        this.n.get(iIndexOf + 1).n(this);
    }
}
