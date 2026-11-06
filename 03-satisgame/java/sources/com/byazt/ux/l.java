package com.byazt.ux;

import android.content.Context;
import com.byazt.np.rv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 727, 18})
public class l implements com.byazt.fb.l {
    public com.byazt.pch.n n;
    public boolean q;
    public com.byazt.ap.w qg;
    public rv s;

    public l(Context context, com.byazt.pch.n nVar, com.byazt.ap.w wVar, boolean z) {
        this.n = nVar;
        this.q = z;
        if (nVar != null) {
            this.s = new rv(context);
            this.qg = wVar;
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        com.byazt.qn.qg qgVar = new com.byazt.qn.qg(5, this.n.lh(), this.n.an());
        qgVar.n(this.q);
        this.s.n(qgVar, new com.byazt.fz.q() { // from class: com.byazt.ux.l.1
            @Override // com.byazt.fz.q
            public void n(List<com.byazt.sg.s> list) {
                com.byazt.pch.qg qgVarUr;
                if (list != null) {
                    if (l.this.qg != null) {
                        com.byazt.he.qg qgVarTj = (l.this.n == null || (qgVarUr = l.this.n.ur()) == null) ? null : qgVarUr.tj();
                        LinkedList linkedList = new LinkedList();
                        Iterator<com.byazt.sg.s> it = list.iterator();
                        while (it.hasNext()) {
                            linkedList.add(new q(l.this.s, it.next(), l.this.s.um(), qgVarTj));
                        }
                        l.this.qg.n(linkedList);
                        return;
                    }
                    return;
                }
                n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
            }

            @Override // com.byazt.fz.q
            public void n(com.byazt.mj.n nVar) {
                if (nVar == null || l.this.qg == null) {
                    return;
                }
                l.this.qg.n(nVar.n, nVar.qg);
            }
        });
    }
}
