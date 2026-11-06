package com.byazt.qc;

import com.byazt.ph.q;
import com.byazt.yq.qg;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1110, 19})
public final class n {
    public static volatile boolean n;

    public static void n() {
        if (q.fs()) {
            n = true;
            if (qg.qg()) {
                com.byazt.yr.n.n().s();
                com.byazt.uvh.q.n().s();
                com.byazt.ynv.n.n().s();
            }
        }
    }

    public static void qg() {
        if (q.fs() && n) {
            com.byazt.yr.n.n().q();
            com.byazt.uvh.q.n().q();
            com.byazt.ynv.n.n().q();
        }
    }

    public static void s() {
        if (q.fs() && n) {
            n();
        }
    }
}
