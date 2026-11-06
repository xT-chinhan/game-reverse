package com.byazt.oi;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 28, 8})
public class s implements com.byazt.kmf.qg {
    public List<com.byazt.yvo.qg> n = new CopyOnWriteArrayList();

    @Override // com.byazt.kmf.qg
    public void n(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_load", "started", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.n.add(qgVar);
        com.byazt.yvo.s.n(qgVar, sVar.q, sVar);
    }

    @Override // com.byazt.kmf.qg
    public void qg(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.q.n(wVar);
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_load", "reqed", wVar != null ? wVar.n() : System.currentTimeMillis());
        this.n.add(qgVar);
        com.byazt.yvo.s.n(qgVar, sVar.q, sVar);
    }

    @Override // com.byazt.kmf.qg
    public void s(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_load", "received", wVar != null ? wVar.n() : System.currentTimeMillis(), sVar.fs ? 1 : 2);
        this.n.add(qgVar);
        com.byazt.yvo.s.n(qgVar, sVar.q, sVar);
    }

    @Override // com.byazt.kmf.qg
    public void q(com.byazt.wea.s sVar, com.byazt.bok.w wVar) {
        com.byazt.yvo.qg qgVar = new com.byazt.yvo.qg("ad_load", "loaded", wVar != null ? wVar.n() : System.currentTimeMillis(), sVar.rv ? 1 : 2);
        this.n.add(qgVar);
        com.byazt.yvo.s.n(qgVar, sVar.q, sVar);
        Iterator<String> it = sVar.cp.iterator();
        while (it.hasNext()) {
            ((com.byazt.id.s) com.byazt.bok.s.n(1)).n(it.next(), new com.byazt.bok.qg.n() { // from class: com.byazt.oi.s.1
                @Override // com.byazt.bok.qg.n
                public void n(com.byazt.wea.fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).k.addAll(0, s.this.n);
                    }
                }
            });
        }
    }
}
