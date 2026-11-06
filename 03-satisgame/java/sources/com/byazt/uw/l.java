package com.byazt.uw;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1462, 18})
public final class l {
    public static HandlerThread n;
    public static Handler qg;
    public volatile int cp;
    public volatile boolean fs;
    public long rv;
    public final q s;
    public volatile int tj;
    public w q = new w();
    public w l = new w();
    public w w = new w();
    public final Object x = new Object();
    public final Runnable d = new Runnable() { // from class: com.byazt.uw.l.1
        @Override // java.lang.Runnable
        public void run() {
            float f;
            if (l.this.fs) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (l.this.rv == 0) {
                    f = 0.016f;
                } else {
                    f = (jUptimeMillis - l.this.rv) / 1000.0f;
                    if (f > 0.033333335f) {
                        f = 0.033333335f;
                    }
                }
                l.this.rv = jUptimeMillis;
                l.this.s.n(l.this.tj, l.this.cp);
                l.this.s.update(f);
                l.this.s.n(l.this.q);
                synchronized (l.this.x) {
                    w wVar = l.this.l;
                    l lVar = l.this;
                    lVar.l = lVar.q;
                    l.this.q = wVar;
                }
                if (l.this.fs) {
                    l.fs().postDelayed(this, 16L);
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Handler fs() {
        if (n == null) {
            HandlerThread handlerThread = new HandlerThread("ugen-particle-physics", 10);
            n = handlerThread;
            handlerThread.start();
            qg = new Handler(n.getLooper());
        }
        return qg;
    }

    public l(qg qgVar) {
        this.s = new q(qgVar);
    }

    public void n(int i, int i2) {
        this.tj = i;
        this.cp = i2;
    }

    public w n() {
        w wVar;
        synchronized (this.x) {
            w wVar2 = this.w;
            wVar = this.l;
            this.w = wVar;
            this.l = wVar2;
        }
        return wVar;
    }

    public qg qg() {
        return this.s.qg();
    }

    public qg.q[] s() {
        return this.s.n();
    }

    public void q() {
        if (this.fs) {
            return;
        }
        this.fs = true;
        this.rv = 0L;
        fs().post(this.d);
    }

    public void l() {
        this.fs = false;
        fs().removeCallbacks(this.d);
    }

    public void w() {
        l();
        synchronized (this.x) {
            this.q = new w();
            this.l = new w();
            this.w = new w();
        }
    }
}
