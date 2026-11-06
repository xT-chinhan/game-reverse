package com.byazt.pd;

import android.content.Context;
import com.byazt.qf.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 24, 13})
@Deprecated
public class w extends s {
    public w(Context context, qg qgVar, q qVar) {
        super(com.byazt.qf.s.CUSTOM_JAVA, context, qgVar, qVar);
    }

    @Override // com.byazt.pd.s
    public com.byazt.ub.n n(com.byazt.ub.n nVar) {
        com.byazt.ub.n nVarN = super.n(nVar);
        com.byazt.ub.qg qgVarN = com.byazt.ub.qg.n(this.qg);
        qgVarN.n(fs.n().n());
        qgVarN.n(fs.s().n());
        qgVarN.qg(this.s.s());
        nVarN.n(qgVarN);
        return nVarN;
    }
}
