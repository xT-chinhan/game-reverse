package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public final class lh {
    public final Handler a = new Handler(Looper.getMainLooper());

    public final void a(Runnable runnable) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.a.post(runnable);
            }
        } catch (Exception e) {
            r9.a("ssp_sdk", "run ui error", e);
        }
    }
}
