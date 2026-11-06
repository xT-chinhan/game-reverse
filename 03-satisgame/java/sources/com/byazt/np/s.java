package com.byazt.np;

import android.content.Context;
import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 20, 8})
public class s extends qg implements com.byazt.qa.qg {
    public s(Context context) {
        super(context);
    }

    @Override // com.byazt.qa.qg
    public void n(Context context, com.byazt.qn.qg qgVar, com.byazt.qa.q.s sVar) {
        n(qgVar);
        this.s.s(true);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.s.n(jCurrentThreadTimeMillis);
        this.s.n(sVar);
        com.byazt.qa.q.n().n(this.l, jCurrentThreadTimeMillis);
        rv();
    }

    @Override // com.byazt.qa.qg
    public int n() {
        if (this.s != null) {
            return this.s.bb();
        }
        return 0;
    }

    @Override // com.byazt.qa.qg
    public ConcurrentHashMap<String, com.byazt.mj.qg> e_() {
        if (this.s != null) {
            return this.s.t();
        }
        return null;
    }

    @Override // com.byazt.qa.qg
    public com.byazt.zb.qg q() {
        return this.s;
    }
}
