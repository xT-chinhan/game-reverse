package com.byazt.cpq;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 405, 250})
public final class k {
    public final CountDownLatch pr = new CountDownLatch(1);
    public long hw = -1;
    public long hn = -1;

    public void pr() {
        if (this.hw != -1) {
            throw new IllegalStateException();
        }
        this.hw = System.nanoTime();
    }

    public void hw() {
        if (this.hn != -1 || this.hw == -1) {
            throw new IllegalStateException();
        }
        this.hn = System.nanoTime();
        this.pr.countDown();
    }

    public void hn() {
        if (this.hn == -1) {
            long j = this.hw;
            if (j != -1) {
                this.hn = j - 1;
                this.pr.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
