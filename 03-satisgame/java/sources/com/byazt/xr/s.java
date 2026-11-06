package com.byazt.xr;

import android.content.Context;
import com.byazt.fb.l;
import com.byazt.np.x;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 685, 8})
public class s implements l {
    public x n;
    public com.byazt.pch.n qg;
    public com.byazt.ap.qg s;

    public s(Context context, com.byazt.pch.n nVar, com.byazt.ap.qg qgVar) {
        this.qg = nVar;
        if (nVar != null) {
            this.n = new x(context);
            this.s = qgVar;
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        this.n.n(new com.byazt.qn.qg(9, this.qg.lh(), this.qg.an()), new com.byazt.us.qg() { // from class: com.byazt.xr.s.1
            @Override // com.byazt.us.qg
            public void n(List<com.byazt.sg.s> list) {
                if (list != null) {
                    if (s.this.s != null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<com.byazt.sg.s> it = list.iterator();
                        while (it.hasNext()) {
                            arrayList.add(new n(s.this.n, it.next(), s.this.n.um()));
                        }
                        s.this.s.n(arrayList);
                        return;
                    }
                    return;
                }
                n(new com.byazt.mj.n(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is null"));
            }

            @Override // com.byazt.us.qg
            public void n(com.byazt.mj.n nVar) {
                if (nVar == null || s.this.s == null) {
                    return;
                }
                s.this.s.n(nVar.n, nVar.qg);
            }
        });
    }
}
