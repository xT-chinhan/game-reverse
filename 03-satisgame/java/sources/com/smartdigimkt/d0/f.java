package com.smartdigimkt.d0;

import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ q b;

    public f(q qVar, AtomicBoolean atomicBoolean) {
        this.b = qVar;
        this.a = atomicBoolean;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.compareAndSet(false, true)) {
            this.b.getClass();
            SystemClock.elapsedRealtime();
            this.b.a(4);
        }
    }
}
