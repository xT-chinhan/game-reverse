package com.byazt.pd;

import android.content.Context;
import com.byazt.qf.fs;
import com.byazt.yw.cp;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 24, 21})
public class x extends s {
    public x(Context context, qg qgVar, q qVar) {
        super(com.byazt.qf.s.JAVA, context, qgVar, qVar);
    }

    @Override // com.byazt.pd.s
    public com.byazt.ub.n n(com.byazt.ub.n nVar) {
        com.byazt.ub.n nVarN = super.n(nVar);
        nVarN.n("app_count", (Object) 1);
        nVarN.n("magic_tag", "ss_app_log");
        s(nVarN);
        com.byazt.ub.qg qgVarN = com.byazt.ub.qg.n(this.qg);
        qgVarN.n(fs.n().n());
        qgVarN.n(fs.s().n());
        qgVarN.qg(this.s.s());
        nVarN.n(qgVarN);
        cp.n(nVarN, qgVarN, this.n);
        return nVarN;
    }
}
