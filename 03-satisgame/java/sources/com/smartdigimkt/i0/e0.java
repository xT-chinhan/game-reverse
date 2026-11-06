package com.smartdigimkt.i0;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public final class e0 {
    public final a a;
    public final d0 b;
    public int c;
    public Object d;
    public final Handler e;
    public boolean f;
    public boolean g;
    public boolean h;

    public e0(p pVar, a aVar, m0 m0Var, int i, Handler handler) {
        this.b = pVar;
        this.a = aVar;
        this.e = handler;
    }

    public final synchronized void a() {
        boolean z;
        if (!this.f) {
            throw new IllegalStateException();
        }
        if (this.e.getLooper().getThread() == Thread.currentThread()) {
            throw new IllegalStateException();
        }
        long jElapsedRealtime = 500;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() + 500;
        while (true) {
            z = this.h;
            if (z || jElapsedRealtime <= 0) {
                break;
            }
            wait(jElapsedRealtime);
            jElapsedRealtime = jElapsedRealtime2 - SystemClock.elapsedRealtime();
        }
        if (!z) {
            throw new TimeoutException("Message delivery time out");
        }
    }

    public final e0 b() {
        if (!(!this.f)) {
            throw new IllegalStateException();
        }
        this.f = true;
        p pVar = (p) this.b;
        synchronized (pVar) {
            if (pVar.u) {
                a(false);
            } else {
                pVar.f.a.obtainMessage(14, this).sendToTarget();
            }
        }
        return this;
    }

    public final synchronized void a(boolean z) {
        this.g = z | this.g;
        this.h = true;
        notifyAll();
    }
}
