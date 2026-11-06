package com.byazt.rt;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 949, 26})
public class qg implements Choreographer.FrameCallback {
    public final n n;
    public long qg = 0;
    public boolean s = false;
    public double q = 16.66666603088379d;

    public interface n {
        void n(double d);
    }

    public qg(n nVar) {
        this.n = nVar;
    }

    public void n() {
        if (this.s) {
            return;
        }
        this.s = true;
        this.qg = 0L;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void qg() {
        if (this.s) {
            this.s = false;
            Choreographer.getInstance().removeFrameCallback(this);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.s) {
            long j2 = this.qg;
            if (j2 != 0) {
                double d = (j - j2) / 1000000.0d;
                if (d > 100.0d) {
                    d = 100.0d;
                }
                if (d >= this.q * 0.5d) {
                    this.n.n(d);
                    this.qg = j;
                }
            } else {
                this.qg = j;
            }
            Choreographer.getInstance().postFrameCallback(this);
        }
    }
}
