package com.byazt.ghh;

import com.byazt.gct.pk;
import com.byazt.qit.x;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1006, 19})
public class n implements l {
    public int n;

    @Override // com.byazt.ghh.l
    public void n(pk pkVar) {
    }

    @Override // com.byazt.ghh.l
    public void n(com.byazt.zq.qg qgVar, pk pkVar, Object obj, boolean z) {
    }

    @Override // com.byazt.ghh.l
    public void n(com.byazt.zq.qg qgVar, List<pk> list) {
    }

    @Override // com.byazt.ghh.l
    public boolean n(String str) {
        return true;
    }

    @Override // com.byazt.ghh.l
    public void qg(com.byazt.zq.qg qgVar, List<pk> list) {
    }

    public n(int i) {
        this.n = i;
    }

    @Override // com.byazt.ghh.l
    public void n(final com.byazt.zq.qg qgVar, final pk pkVar) {
        if (pkVar.aj() <= 0) {
            pkVar.l((System.currentTimeMillis() + 10500000) / 1000);
        }
        com.byazt.ag.qg.l(new x("PreloadStrategyLoadDelete-onNetworkResponse") { // from class: com.byazt.ghh.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ci.l.n(n.this.n).n(qgVar, pkVar, false);
            }
        });
    }

    @Override // com.byazt.ghh.l
    public void qg(String str) {
        com.byazt.ci.l.n(this.n).qg(str);
    }

    @Override // com.byazt.ghh.l
    public pk n(String str, long j) {
        pk pkVarN = com.byazt.ci.l.n(this.n).n(str, false, j);
        if (pkVarN != null) {
            com.byazt.ci.l.n(this.n).n(str, pkVarN.cs());
        }
        return pkVarN;
    }

    @Override // com.byazt.ghh.l
    public List<pk> n(String str, long j, int i, double d) {
        List<pk> listN = com.byazt.ci.l.n(this.n).n(str, false, j, i, d);
        Iterator<pk> it = listN.iterator();
        while (it.hasNext()) {
            com.byazt.ci.l.n(this.n).n(str, it.next().cs());
        }
        listN.size();
        return listN;
    }

    @Override // com.byazt.ghh.l
    public void n(String str, pk pkVar) {
        com.byazt.ci.l.n(this.n).n(str, pkVar.cs());
    }
}
