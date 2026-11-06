package com.byazt.nv;

import android.content.Context;
import com.byazt.pd.l;
import com.byazt.yw.q;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1389, 8})
public class s implements qg {
    public Context n;

    @Override // com.byazt.nv.qg
    public boolean n(Throwable th) {
        return true;
    }

    @Override // com.byazt.nv.qg
    public void n(long j, Thread thread, Throwable th) throws Throwable {
        com.byazt.ub.n nVarN = com.byazt.ub.n.n(j, this.n, thread, th);
        q.n(this.n, com.byazt.qf.s.JAVA.n(), Thread.currentThread().getName());
        com.byazt.xh.n.n().n(l.n().n(com.byazt.qf.s.JAVA, nVarN).n());
    }

    public s(Context context) {
        this.n = context;
    }
}
