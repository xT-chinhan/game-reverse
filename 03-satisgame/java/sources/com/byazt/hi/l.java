package com.byazt.hi;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, 18})
public class l {
    public static boolean n() {
        return (com.byazt.ed.q.n().d() & 8) == 8;
    }

    public static void n(Runnable runnable) {
        if (n()) {
            if (Looper.myLooper() == com.byazt.tk.rv.s().getLooper()) {
                runnable.run();
                return;
            } else {
                com.byazt.tk.rv.s().post(runnable);
                return;
            }
        }
        com.byazt.ag.qg.n(runnable);
    }

    public static void qg(Runnable runnable) {
        if (n() && Looper.myLooper() != com.byazt.tk.rv.s().getLooper()) {
            com.byazt.tk.rv.s().post(runnable);
        } else {
            runnable.run();
        }
    }
}
