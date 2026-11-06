package com.bytedance.ms.xr.ka;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class ab {
    private static volatile Handler ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile HandlerThread f565ms;
    private static volatile Handler xr;

    public static HandlerThread ms() {
        if (f565ms == null) {
            synchronized (ab.class) {
                if (f565ms == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    f565ms = handlerThread;
                    handlerThread.start();
                    xr = new Handler(f565ms.getLooper());
                }
            }
        }
        return f565ms;
    }

    public static Handler xr() {
        if (xr == null) {
            ms();
        }
        return xr;
    }
}
