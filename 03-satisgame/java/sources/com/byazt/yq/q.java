package com.byazt.yq;

import com.byazt.kfh.SSWebView;
import com.byazt.lk.l;
import com.byazt.tk.k;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 776, 5})
public final class q {
    public static final q n = new q();
    public static final AtomicInteger qg = new AtomicInteger(0);

    private q() {
    }

    public static q n() {
        return n;
    }

    public s qg() {
        return new s(l(), w(), x(), fs(), 0L, rv());
    }

    public void s() {
        AtomicInteger atomicInteger = qg;
        if (atomicInteger.get() == Integer.MAX_VALUE) {
            return;
        }
        atomicInteger.incrementAndGet();
    }

    public void q() {
        AtomicInteger atomicInteger;
        int i;
        do {
            atomicInteger = qg;
            i = atomicInteger.get();
            if (i <= 0) {
                return;
            }
        } while (!atomicInteger.compareAndSet(i, i - 1));
    }

    private static int l() {
        try {
            return SSWebView.getAliveCount();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int w() {
        try {
            return com.byazt.vmq.q.n();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static int x() {
        return qg.get();
    }

    private static int fs() {
        try {
            com.byazt.gwu.s sVarN = l.n(com.byazt.vgx.s.q(), "sp_oom");
            if (sVarN == null) {
                return 0;
            }
            return sVarN.getInt("oom_count", 0);
        } catch (Throwable th) {
            k.qg("PerfMonitor", "countOom err: " + th.getMessage());
            return 0;
        }
    }

    private static int rv() {
        try {
            String[] list = new File("/proc/self/task").list();
            if (list != null && list.length > 0) {
                return list.length;
            }
        } catch (Throwable th) {
            k.qg("PerfMonitor", "countThreads proc err: " + th.getMessage());
        }
        return tj();
    }

    private static int tj() {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            if (threadGroup == null) {
                return 0;
            }
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            return threadGroup.activeCount();
        } catch (Throwable unused) {
            return 0;
        }
    }
}
