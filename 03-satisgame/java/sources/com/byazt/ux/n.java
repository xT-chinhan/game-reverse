package com.byazt.ux;

import android.text.TextUtils;
import com.byazt.np.rv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 727, 19})
public class n extends com.byazt.am.qg {
    public rv n;

    public n(rv rvVar) {
        this.n = rvVar;
    }

    @Override // com.byazt.am.qg
    public void n(String str, com.byazt.ap.s sVar) {
        qg(str, sVar);
    }

    public void qg(String str, final com.byazt.ap.s sVar) {
        rv rvVar;
        if (!TextUtils.isEmpty(str) && (rvVar = this.n) != null && sVar != null) {
            rvVar.n(str, new com.byazt.fz.q() { // from class: com.byazt.ux.n.1
                @Override // com.byazt.fz.q
                public void n(List<com.byazt.sg.s> list) {
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (com.byazt.sg.s sVar2 : list) {
                            if (sVar2 != null) {
                                arrayList.add(new qg(n.this.n, sVar2, n.this.n.um()));
                            }
                        }
                        sVar.n(arrayList);
                        return;
                    }
                    sVar.n(null);
                }

                @Override // com.byazt.fz.q
                public void n(com.byazt.mj.n nVar) {
                    if (nVar != null) {
                        sVar.n(nVar.n, nVar.qg);
                    }
                }
            });
        } else {
            com.byazt.rb.qg.q("TMe", "adm 参数错误 或者 nativeAdManager is null");
        }
    }
}
