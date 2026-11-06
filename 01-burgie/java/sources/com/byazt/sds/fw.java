package com.byazt.sds;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1663, 62})
public class fw {
    public static volatile Handler hn = null;
    public static volatile Handler hw;
    public static volatile HandlerThread pr;

    public static HandlerThread pr() {
        if (pr == null) {
            synchronized (fw.class) {
                if (pr == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    pr = handlerThread;
                    handlerThread.start();
                    hw = new Handler(pr.getLooper());
                }
            }
        }
        return pr;
    }

    public static Handler hw() {
        if (hw == null) {
            pr();
        }
        return hw;
    }
}
