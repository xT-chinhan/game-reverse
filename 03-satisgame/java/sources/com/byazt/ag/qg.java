package com.byazt.ag;

import android.os.Looper;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.qp.q;
import com.byazt.vf.wo;
import com.byazt.vyf.l;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1760, 26})
public class qg {
    public static boolean n() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void n(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            l.q().post(runnable);
        }
    }

    public static void n(Runnable runnable, long j) {
        l.q().postDelayed(runnable, j);
    }

    public static void n(x xVar) {
        ((wo) q.n("thread_service")).n(xVar);
    }

    public static void qg(Runnable runnable) {
        ((wo) q.n("thread_service")).qg(runnable);
    }

    public static void s(Runnable runnable) {
        if (rv.qg().wx() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            l.q().post(runnable);
        }
    }

    public static void q(Runnable runnable) {
        if (rv.qg().em()) {
            ((wo) q.n("thread_service")).l().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void n(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (!n()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(runnable);
        } else {
            ((wo) q.n("thread_service")).n(new Runnable() { // from class: com.byazt.ag.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }

    public static void l(Runnable runnable) {
        n(runnable, (ScheduledExecutorService) null);
    }

    public static Looper qg() {
        if (rv.qg().em()) {
            return ((wo) q.n("thread_service")).l().getLooper();
        }
        return Looper.getMainLooper();
    }
}
