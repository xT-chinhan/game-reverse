package com.byazt.rhv;

import android.os.Handler;
import android.os.Looper;
import com.byazt.ca.aj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1125, 13})
public class hw {
    public static final Handler pr = new Handler(Looper.getMainLooper());

    public static void pr(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            pr.post(runnable);
        }
    }

    public static void hw(Runnable runnable) {
        pr.post(runnable);
    }

    public static void hn(Runnable runnable) {
        aj.hn().post(runnable);
    }
}
