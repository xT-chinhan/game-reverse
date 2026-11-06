package com.byazt.ns;

import com.byazt.ep.s;
import com.byazt.gct.nf;
import com.byazt.gct.pk;
import com.byazt.px.q;
import com.byazt.qit.l;
import com.byazt.qit.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2117, 19})
public class n {
    public static void n(pk pkVar, final s sVar) {
        final q qVarTj;
        if (pkVar == null || nf.rv(pkVar) || (qVarTj = nf.tj(pkVar)) == null) {
            return;
        }
        l.n(new x("saveTemplate") { // from class: com.byazt.ns.n.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.mzw.x.n().n(qVarTj, new com.byazt.mzw.x.n() { // from class: com.byazt.ns.n.1.1
                    @Override // com.byazt.mzw.x.n
                    public void n() {
                        if (sVar != null) {
                            sVar.n(null);
                        }
                    }

                    @Override // com.byazt.mzw.x.n
                    public void qg() {
                        if (sVar != null) {
                            sVar.n();
                        }
                    }
                });
            }
        }, 10);
    }
}
