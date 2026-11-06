package com.byazt.ai;

import android.os.Handler;
import android.os.HandlerThread;
import com.byazt.ca.ho;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 570, 37})
public final class pr {
    public static final Map<Runnable, Runnable> hw = new WeakHashMap();
    public static volatile Handler pr;

    private pr() {
    }

    public static Handler pr() {
        Handler handler;
        Handler handler2 = pr;
        if (handler2 != null) {
            return handler2;
        }
        synchronized (pr.class) {
            if (pr == null) {
                HandlerThread handlerThread = new HandlerThread("csj-perf-monitor");
                handlerThread.start();
                pr = new Handler(handlerThread.getLooper());
            }
            handler = pr;
        }
        return handler;
    }

    public static boolean pr(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        Runnable runnableHn = hn(runnable);
        hw(runnable, runnableHn);
        return pr().post(runnableHn);
    }

    public static boolean pr(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        Runnable runnableHn = hn(runnable);
        hw(runnable, runnableHn);
        return pr().postDelayed(runnableHn, j);
    }

    public static void hw(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        Runnable runnableX = x(runnable);
        Handler handlerPr = pr();
        if (runnableX != null) {
            runnable = runnableX;
        }
        handlerPr.removeCallbacks(runnable);
    }

    private static Runnable hn(final Runnable runnable) {
        return new Runnable() { // from class: com.byazt.ai.pr.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    try {
                        ho.hw("PerfMonitor", "perf-monitor task err: " + th.getMessage());
                    } finally {
                        pr.hn(runnable, this);
                    }
                }
            }
        };
    }

    private static void hw(Runnable runnable, Runnable runnable2) {
        Map<Runnable, Runnable> map = hw;
        synchronized (map) {
            map.put(runnable, runnable2);
        }
    }

    private static Runnable x(Runnable runnable) {
        Runnable runnableRemove;
        Map<Runnable, Runnable> map = hw;
        synchronized (map) {
            runnableRemove = map.remove(runnable);
        }
        return runnableRemove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hn(Runnable runnable, Runnable runnable2) {
        Map<Runnable, Runnable> map = hw;
        synchronized (map) {
            if (map.get(runnable) == runnable2) {
                map.remove(runnable);
            }
        }
    }
}
