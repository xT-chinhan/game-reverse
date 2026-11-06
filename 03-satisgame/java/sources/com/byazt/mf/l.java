package com.byazt.mf;

import android.os.Bundle;
import android.util.SparseArray;
import com.byazt.qk.cy;
import com.byazt.qk.d;
import com.byazt.qk.k;
import com.byazt.qk.oa;
import com.byazt.qk.rv;
import com.byazt.vf.bb;
import com.byazt.vf.cp;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1054, 18})
public class l implements bb, Function {
    public final com.byazt.xl.qg n;
    public final com.byazt.phf.qg qg;
    public final com.byazt.two.n s;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            rv rvVarN = n();
            return rvVarN != null ? new d(rvVarN) : rvVarN;
        }
        if (iIntValue != 2) {
            if (iIntValue != 3) {
                return null;
            }
            n(((Boolean) sparseArray.get(1)).booleanValue());
            return null;
        }
        Object cyVar = sparseArray.get(1);
        if (cyVar != null) {
            cyVar = new cy((Function) cyVar);
        }
        n((k) cyVar);
        return null;
    }

    @Override // com.byazt.vf.bb
    public void n(k kVar) {
    }

    public l(com.byazt.xl.qg qgVar) {
        this.n = qgVar;
        final com.byazt.phf.qg.n nVarN = new com.byazt.phf.qg.n().n(qgVar.qg(), TimeUnit.MILLISECONDS).qg(qgVar.s(), TimeUnit.MILLISECONDS).s(qgVar.q(), TimeUnit.MILLISECONDS).n(n(qgVar)).n(qgVar.l());
        qgVar.x().forEach(new Consumer<k>() { // from class: com.byazt.mf.l.1
            @Override // java.util.function.Consumer
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public void accept(final k kVar) {
                nVarN.n(new com.byazt.tbt.rv() { // from class: com.byazt.mf.l.1.1
                    @Override // com.byazt.tbt.rv
                    public com.byazt.tbt.cy n(com.byazt.tbt.rv.n nVar) throws IOException {
                        kVar.n((rv) null);
                        com.byazt.tbt.cy cyVarN = nVar.n(nVar.n());
                        kVar.n((oa) null);
                        return cyVarN;
                    }
                });
            }
        });
        com.byazt.phf.qg qgVarN = nVarN.n(true).n();
        this.qg = qgVarN;
        com.byazt.tbt.q qVarN = qgVarN.n().n();
        int iCp = qgVar.cp();
        com.byazt.phf.n.n(iCp >= 0);
        if (qVarN != null) {
            qVarN.n(qgVar.w());
            qVarN.qg(qgVar.n());
            if (iCp >= 0) {
                qVarN.s(iCp);
            }
        }
        this.s = new com.byazt.two.n(qgVar.fs());
    }

    private static Bundle n(com.byazt.xl.qg qgVar) {
        Bundle bundle = new Bundle();
        int iRv = qgVar.rv();
        if (iRv >= 0) {
            bundle.putInt("max_idle_cnt", iRv);
        }
        int iTj = qgVar.tj();
        if (iTj > 0) {
            bundle.putLong("max_idle_time", iTj);
        }
        return bundle;
    }

    @Override // com.byazt.vf.bb
    public rv n() {
        return new s(this.n, this.qg);
    }

    @Override // com.byazt.vf.bb
    public void n(boolean z) {
        cp cpVar = (cp) com.byazt.qp.q.n("csj_settings");
        if (cpVar == null || !cpVar.a()) {
            return;
        }
        com.byazt.two.n.qg(true);
        this.s.n();
        com.byazt.vf.l lVar = (com.byazt.vf.l) com.byazt.qp.q.n("app_process");
        boolean z2 = lVar != null && lVar.n();
        if (qg() || (!z2 && z)) {
            this.s.x();
            this.s.n(false);
        }
        if (z2) {
            this.s.x();
            this.s.n(false);
        }
    }

    private static boolean qg() {
        String strQg = ((com.byazt.vf.l) com.byazt.qp.q.n("app_process")).qg();
        if (strQg != null) {
            return strQg.endsWith(":push") || strQg.endsWith(":pushservice");
        }
        return false;
    }
}
