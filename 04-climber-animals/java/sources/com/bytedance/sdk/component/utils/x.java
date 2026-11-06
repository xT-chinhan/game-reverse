package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile Handler f1370ms;

    public static Handler ms() {
        return com.bytedance.sdk.component.ch.xr.ms.ms().xr();
    }

    public static Handler xr() {
        if (f1370ms == null) {
            synchronized (x.class) {
                if (f1370ms == null) {
                    f1370ms = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f1370ms;
    }

    public static Handler ah() {
        return com.bytedance.sdk.component.ch.xr.ms.ms().ah();
    }
}
