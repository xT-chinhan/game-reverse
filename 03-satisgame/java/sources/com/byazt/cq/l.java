package com.byazt.cq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 18})
public class l {
    public static void n(com.byazt.qit.x xVar, int i) {
        if (xVar == null) {
            return;
        }
        com.byazt.gkj.s sVarS = com.byazt.gkj.n.n().s();
        ExecutorService executorServiceD = sVarS != null ? sVarS.d() : null;
        if (executorServiceD != null) {
            xVar.setPriority(i);
            executorServiceD.execute(xVar);
        } else {
            com.byazt.qit.l.n(xVar, i);
        }
    }

    public static void qg(com.byazt.qit.x xVar, int i) {
        if (xVar == null) {
            return;
        }
        com.byazt.gkj.s sVarS = com.byazt.gkj.n.n().s();
        ExecutorService executorServiceCp = sVarS != null ? sVarS.cp() : null;
        if (executorServiceCp != null) {
            xVar.setPriority(i);
            executorServiceCp.execute(xVar);
        } else {
            com.byazt.qit.l.n(xVar);
        }
    }

    public static ScheduledFuture n(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.byazt.qit.l.q().schedule(runnable, j, timeUnit);
    }
}
