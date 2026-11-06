package com.byazt.fho;

import android.os.Handler;
import android.os.HandlerThread;
import com.byazt.tk.k;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 528, 19})
public final class n {
    public static volatile Handler n;
    public static final Map<Runnable, Runnable> qg = new WeakHashMap();

    private n() {
    }

    public static Handler n() {
        Handler handler;
        Handler handler2 = n;
        if (handler2 != null) {
            return handler2;
        }
        synchronized (n.class) {
            if (n == null) {
                HandlerThread handlerThread = new HandlerThread("csj-perf-monitor");
                handlerThread.start();
                n = new Handler(handlerThread.getLooper());
            }
            handler = n;
        }
        return handler;
    }

    public static boolean n(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        Runnable runnableS = s(runnable);
        qg(runnable, runnableS);
        return n().post(runnableS);
    }

    public static boolean n(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        Runnable runnableS = s(runnable);
        qg(runnable, runnableS);
        return n().postDelayed(runnableS, j);
    }

    public static void qg(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        Runnable runnableQ = q(runnable);
        Handler handlerN = n();
        if (runnableQ != null) {
            runnable = runnableQ;
        }
        handlerN.removeCallbacks(runnable);
    }

    private static Runnable s(final Runnable runnable) {
        return new Runnable() { // from class: com.byazt.fho.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    try {
                        k.qg("PerfMonitor", "perf-monitor task err: " + th.getMessage());
                    } finally {
                        n.s(runnable, this);
                    }
                }
            }
        };
    }

    private static void qg(Runnable runnable, Runnable runnable2) {
        Map<Runnable, Runnable> map = qg;
        synchronized (map) {
            map.put(runnable, runnable2);
        }
    }

    private static Runnable q(Runnable runnable) {
        Runnable runnableRemove;
        Map<Runnable, Runnable> map = qg;
        synchronized (map) {
            runnableRemove = map.remove(runnable);
        }
        return runnableRemove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s(Runnable runnable, Runnable runnable2) {
        Map<Runnable, Runnable> map = qg;
        synchronized (map) {
            if (map.get(runnable) == runnable2) {
                map.remove(runnable);
            }
        }
    }
}
