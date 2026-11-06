package com.byazt.pj;

import android.content.Context;
import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 441, 21})
public class x extends s {
    public static final x s = new x(rv.getContext());

    @Override // com.byazt.pj.s
    public int qg() {
        return 7;
    }

    private x(Context context) {
        super(context);
    }

    public static x n() {
        return s;
    }

    public void n(com.byazt.zq.qg qgVar, String str, int i, q qVar) {
        com.byazt.dt.s sVar = new com.byazt.dt.s();
        sVar.n(str);
        sVar.n(i + 1);
        n(qgVar, qVar, sVar, null, null, null);
    }
}
