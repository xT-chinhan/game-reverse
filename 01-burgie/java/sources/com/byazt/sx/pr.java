package com.byazt.sx;

import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 892, 37})
public abstract class pr implements Runnable {
    public final long hn;
    public final long hw;
    public Handler pr;

    public pr(Handler handler, long j, long j2) {
        this.pr = handler;
        this.hw = j;
        this.hn = j2;
    }

    public void pr() {
        if (hw() > 0) {
            this.pr.postDelayed(this, hw());
        } else {
            this.pr.post(this);
        }
    }

    public void pr(long j) {
        if (j > 0) {
            this.pr.postDelayed(this, j);
        } else {
            this.pr.post(this);
        }
    }

    public long hw() {
        return this.hw;
    }

    public long hn() {
        return this.hn;
    }
}
