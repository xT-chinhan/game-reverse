package com.byazt.kr;

import com.byazt.gct.pk;
import com.byazt.mz.l;
import com.byazt.nf.rv;
import com.byazt.se.w;
import com.byazt.se.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1300, 19})
public class n {
    public boolean l;
    public com.byazt.mz.n n;
    public String qg;
    public com.byazt.zq.qg s;
    public l x;
    public x q = new x();
    public com.byazt.fxc.n w = new com.byazt.fxc.n(4);

    public n(com.byazt.mz.n nVar) {
        this.n = nVar;
        nVar.qg();
        this.l = rv.qg().sq();
    }

    public void n(com.byazt.se.l lVar, com.byazt.jr.qg<w, x> qgVar) {
        if (lVar == null || qgVar == null) {
            return;
        }
        this.q.qg(true);
        this.s = lVar.q();
        this.qg = lVar.w();
        this.x = lVar.x();
        if (com.byazt.jr.l.n(this.s, lVar.l())) {
            this.q.qg(1);
            this.q.n("no cache");
            qgVar.n(this.q);
            return;
        }
        n(this.qg, qgVar);
    }

    private void n(final String str, final com.byazt.jr.qg<w, x> qgVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        this.n.n(this.q, str, new com.byazt.mz.n.InterfaceC0253n() { // from class: com.byazt.kr.n.1
            @Override // com.byazt.mz.n.InterfaceC0253n
            public void n(final w wVar) {
                com.byazt.eo.n.n("lqmt", "缓存读取总耗时： " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (qgVar == null) {
                    return;
                }
                if (wVar == null || wVar.qg() == null) {
                    if (wVar == null) {
                        n.this.q.qg(1);
                        n.this.q.n("no ad model cache");
                        qgVar.n(n.this.q);
                        return;
                    } else if (wVar.qg() == null) {
                        n.this.q.qg(1);
                        n.this.q.n("no splash material");
                        qgVar.n(n.this.q);
                        return;
                    }
                }
                pk pkVarQg = wVar.qg();
                pkVarQg.d(true);
                n.this.w.n(jCurrentTimeMillis);
                n.this.w.qg(System.currentTimeMillis());
                ArrayList arrayList = new ArrayList();
                arrayList.add(pkVarQg);
                n.this.w.n(arrayList, new com.byazt.fxc.w() { // from class: com.byazt.kr.n.1.1
                    @Override // com.byazt.fxc.w
                    public void n(List<pk> list) {
                        if (n.this.l) {
                            n.this.n(wVar, (com.byazt.jr.qg<w, x>) qgVar);
                        } else {
                            qgVar.qg(wVar);
                        }
                    }

                    @Override // com.byazt.fxc.w
                    public void qg(List<pk> list) {
                        if (list == null || list.isEmpty()) {
                            n.this.q.qg(22);
                            n.this.q.n("check server cache unavailable");
                            qgVar.n(n.this.q);
                            return;
                        }
                        qgVar.qg(wVar);
                    }

                    @Override // com.byazt.fxc.w
                    public void s(List<pk> list) {
                        Iterator<pk> it = list.iterator();
                        while (it.hasNext()) {
                            n.this.n.n(str, it.next());
                        }
                    }
                });
            }

            @Override // com.byazt.mz.n.InterfaceC0253n
            public void n() {
                com.byazt.eo.n.n("lqmt", "缓存读取失败");
                com.byazt.jr.qg qgVar2 = qgVar;
                if (qgVar2 == null) {
                    return;
                }
                qgVar2.n(n.this.q);
            }
        }, this.x);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(final w wVar, final com.byazt.jr.qg<w, x> qgVar) {
        if (qgVar == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        pk pkVarQg = wVar.qg();
        rv.n().n(pkVarQg.q(), pkVarQg.F_(), new com.byazt.mw.n.InterfaceC0251n() { // from class: com.byazt.kr.n.2
            @Override // com.byazt.mw.n.InterfaceC0251n
            public void n(boolean z, long j, long j2) {
                com.byazt.eji.s.n(n.this.s, j, j2, System.currentTimeMillis() - jCurrentTimeMillis, 4, 1, z ? 1 : 0);
                if (!z) {
                    n.this.q.qg(22);
                    n.this.q.n("check server cache unavailable");
                    n.this.q.n(j);
                    qgVar.n(n.this.q);
                    return;
                }
                qgVar.qg(wVar);
            }
        });
    }
}
