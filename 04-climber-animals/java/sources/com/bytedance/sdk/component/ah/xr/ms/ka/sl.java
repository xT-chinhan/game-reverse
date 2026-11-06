package com.bytedance.sdk.component.ah.xr.ms.ka;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes2.dex */
final class sl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final CountDownLatch f1099ms = new CountDownLatch(1);
    private long xr = -1;
    private long ah = -1;

    sl() {
    }

    void ms() {
        if (this.xr != -1) {
            throw new IllegalStateException();
        }
        this.xr = System.nanoTime();
    }

    void xr() {
        if (this.ah != -1 || this.xr == -1) {
            throw new IllegalStateException();
        }
        this.ah = System.nanoTime();
        this.f1099ms.countDown();
    }

    void ah() {
        if (this.ah == -1) {
            long j = this.xr;
            if (j != -1) {
                this.ah = j - 1;
                this.f1099ms.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
