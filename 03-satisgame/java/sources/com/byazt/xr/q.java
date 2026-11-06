package com.byazt.xr;

import android.text.TextUtils;
import com.byazt.np.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 685, 5})
public class q extends com.byazt.am.n {
    public x n;

    public q(x xVar) {
        this.n = xVar;
    }

    @Override // com.byazt.am.n
    public void n(String str, com.byazt.ap.qg qgVar) {
        qg(str, qgVar);
    }

    public void qg(String str, final com.byazt.ap.qg qgVar) {
        x xVar;
        if (!TextUtils.isEmpty(str) && (xVar = this.n) != null && qgVar != null) {
            xVar.n(str, new com.byazt.us.qg() { // from class: com.byazt.xr.q.1
                @Override // com.byazt.us.qg
                public void n(List<com.byazt.sg.s> list) {
                    if (list != null) {
                        ArrayList arrayList = new ArrayList();
                        for (com.byazt.sg.s sVar : list) {
                            if (sVar != null) {
                                arrayList.add(new n(q.this.n, sVar, q.this.n.um()));
                            }
                        }
                        qgVar.n(arrayList);
                        return;
                    }
                    qgVar.n(null);
                }

                @Override // com.byazt.us.qg
                public void n(com.byazt.mj.n nVar) {
                    if (nVar != null) {
                        qgVar.n(nVar.n, nVar.qg);
                    }
                }
            });
        } else {
            com.byazt.rb.qg.q("TMe", "adm 参数错误 或者 drawTokenInfo is null");
        }
    }
}
