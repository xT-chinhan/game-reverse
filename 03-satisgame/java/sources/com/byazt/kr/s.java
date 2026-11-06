package com.byazt.kr;

import android.text.TextUtils;
import com.byazt.nf.rv;
import com.byazt.se.l;
import com.byazt.se.w;
import com.byazt.se.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1300, 8})
public class s {
    public x n = new x();
    public int s = 3;
    public final com.byazt.mw.n qg = rv.n();

    public void n(final l lVar, final com.byazt.jr.qg<w, x> qgVar) {
        if (this.qg == null || lVar == null) {
            return;
        }
        this.n.qg(false);
        this.qg.n(lVar.q(), lVar.l(), this.s, new com.byazt.mw.n.qg() { // from class: com.byazt.kr.s.1
            @Override // com.byazt.mw.n.qg
            public void n(int i, String str, com.byazt.gct.qg qgVar2) {
                s.this.n.qg(i);
                s.this.n.s(qgVar2 != null ? qgVar2.s() : 0);
                if (TextUtils.isEmpty(str)) {
                    str = "load ad error";
                }
                s.this.n.n(str);
                qgVar.n(s.this.n);
            }

            @Override // com.byazt.mw.n.qg
            public void n(com.byazt.gct.n nVar, com.byazt.gct.qg qgVar2) {
                if (nVar == null || nVar.qg() == null) {
                    s.this.n.qg(1);
                    s.this.n.n("no ad or material");
                    qgVar.n(s.this.n);
                    return;
                }
                w wVar = new w(nVar, false);
                wVar.qg(qgVar2.rv());
                wVar.s(qgVar2.tj());
                wVar.q(qgVar2.cp());
                wVar.l(qgVar2.d());
                wVar.n(lVar.n());
                wVar.n(lVar.s());
                qgVar.qg(wVar);
            }
        });
    }
}
