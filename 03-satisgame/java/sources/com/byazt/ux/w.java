package com.byazt.ux;

import android.content.Context;
import com.byazt.np.rv;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 727, 13})
public class w implements com.byazt.fb.l {
    public rv n;
    public boolean q;
    public com.byazt.pch.n qg;
    public com.byazt.ap.s s;

    public w(Context context, com.byazt.pch.n nVar, com.byazt.ap.s sVar, boolean z) {
        this.qg = nVar;
        this.q = z;
        if (nVar != null) {
            this.n = new rv(context);
            this.s = sVar;
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        com.byazt.qn.qg qgVar = new com.byazt.qn.qg(5, this.qg.lh(), this.qg.an());
        qgVar.n(this.q);
        this.n.n(qgVar, new com.byazt.fz.q() { // from class: com.byazt.ux.w.1
            @Override // com.byazt.fz.q
            public void n(List<com.byazt.sg.s> list) {
                if (list != null) {
                    if (w.this.s != null) {
                        LinkedList linkedList = new LinkedList();
                        Iterator<com.byazt.sg.s> it = list.iterator();
                        while (it.hasNext()) {
                            linkedList.add(new qg(w.this.n, it.next(), w.this.n.um()));
                        }
                        w.this.s.n(linkedList);
                        return;
                    }
                    return;
                }
                n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
            }

            @Override // com.byazt.fz.q
            public void n(com.byazt.mj.n nVar) {
                if (nVar == null || w.this.s == null) {
                    return;
                }
                w.this.s.n(nVar.n, nVar.qg);
            }
        });
    }
}
