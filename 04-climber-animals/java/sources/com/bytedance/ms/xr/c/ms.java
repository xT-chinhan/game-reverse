package com.bytedance.ms.xr.c;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms implements Runnable {
    private final long ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Handler f562ms;
    private final long xr;

    ms(Handler handler, long j, long j2) {
        this.f562ms = handler;
        this.xr = j;
        this.ah = j2;
    }

    void ms() {
        if (xr() > 0) {
            this.f562ms.postDelayed(this, xr());
        } else {
            this.f562ms.post(this);
        }
    }

    void ms(long j) {
        if (j > 0) {
            this.f562ms.postDelayed(this, j);
        } else {
            this.f562ms.post(this);
        }
    }

    long xr() {
        return this.xr;
    }

    long ah() {
        return this.ah;
    }
}
