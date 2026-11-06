package com.byazt.hf;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 938, 113})
public final class d {
    public final CountDownLatch n = new CountDownLatch(1);
    public long qg = -1;
    public long s = -1;

    public void n() {
        if (this.qg != -1) {
            throw new IllegalStateException();
        }
        this.qg = System.nanoTime();
    }

    public void qg() {
        if (this.s != -1 || this.qg == -1) {
            throw new IllegalStateException();
        }
        this.s = System.nanoTime();
        this.n.countDown();
    }

    public void s() {
        if (this.s == -1) {
            long j = this.qg;
            if (j != -1) {
                this.s = j - 1;
                this.n.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
