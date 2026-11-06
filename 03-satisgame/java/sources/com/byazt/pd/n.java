package com.byazt.pd;

import android.content.Context;
import com.byazt.qf.fs;
import com.byazt.yw.cp;
import com.bytedance.pangle.provider.ContentProviderManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 24, 19})
public class n extends s {
    public n(Context context, qg qgVar, q qVar) {
        super(com.byazt.qf.s.ANR, context, qgVar, qVar);
    }

    @Override // com.byazt.pd.s
    public com.byazt.ub.n n(com.byazt.ub.n nVar) {
        com.byazt.ub.n nVarN = super.n(nVar);
        com.byazt.ub.qg qgVarN = com.byazt.ub.qg.n(this.qg);
        qgVarN.n(fs.n().n());
        qgVarN.n(fs.s().n());
        qgVarN.qg(this.s.s());
        nVarN.n(qgVarN);
        nVarN.n(ContentProviderManager.PLUGIN_PROCESS_NAME, com.byazt.yw.n.q(this.qg));
        cp.n(nVarN, qgVarN, this.n);
        return nVarN;
    }
}
