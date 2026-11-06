package com.byazt.jeb;

import android.os.Looper;
import com.byazt.vf.wo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1621, 18})
public abstract class l implements q {
    public final com.byazt.vr.qg qg;
    public final com.byazt.kp.s s;

    public l(com.byazt.vr.qg qgVar, com.byazt.kp.s sVar) {
        this.qg = qgVar;
        this.s = sVar;
    }

    public void q() {
        s();
    }

    public Looper l() {
        com.byazt.kp.s sVar = this.s;
        if (sVar == null || sVar.s() == null || this.s.s().py() != 1) {
            return ((wo) com.byazt.qp.q.n("thread_service")).q().getLooper();
        }
        return ((wo) com.byazt.qp.q.n("thread_service")).l().getLooper();
    }
}
