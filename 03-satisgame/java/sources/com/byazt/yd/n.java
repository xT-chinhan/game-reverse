package com.byazt.yd;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 169, 19})
public abstract class n implements Runnable {
    public Handler n;
    public final long qg;
    public final long s;

    public n(Handler handler, long j, long j2) {
        this.n = handler;
        this.qg = j;
        this.s = j2;
    }

    public void n() {
        if (qg() > 0) {
            this.n.postDelayed(this, qg());
        } else {
            this.n.post(this);
        }
    }

    public void n(long j) {
        if (j > 0) {
            this.n.postDelayed(this, j);
        } else {
            this.n.post(this);
        }
    }

    public long qg() {
        return this.qg;
    }

    public long s() {
        return this.s;
    }
}
