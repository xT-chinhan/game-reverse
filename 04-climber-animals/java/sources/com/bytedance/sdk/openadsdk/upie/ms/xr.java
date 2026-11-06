package com.bytedance.sdk.openadsdk.upie.ms;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.x;

/* JADX INFO: loaded from: classes2.dex */
public class xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final Handler f4237ms = new Handler(Looper.getMainLooper());

    public static void ms(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f4237ms.post(runnable);
        }
    }

    public static void xr(Runnable runnable) {
        f4237ms.post(runnable);
    }

    public static void ah(Runnable runnable) {
        x.ah().post(runnable);
    }
}
