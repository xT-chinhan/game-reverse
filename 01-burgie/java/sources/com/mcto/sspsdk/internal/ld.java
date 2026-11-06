package com.mcto.sspsdk.internal;

import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ld {
    public long a;
    public long c;
    public boolean d = true;
    public final kd e = new kd(this, Looper.getMainLooper());
    public final long b = 1000;

    public ld(long j) {
        this.a = j;
    }

    public final synchronized void a() {
        if (!this.d) {
            this.d = true;
            this.a = this.c - SystemClock.elapsedRealtime();
        }
        this.e.removeMessages(1);
    }

    public abstract void a(long j);

    public abstract void b();

    public final synchronized void c() {
        if (this.d) {
            this.d = false;
            if (this.a <= 0) {
                b();
                return;
            }
            this.c = SystemClock.elapsedRealtime() + this.a;
            kd kdVar = this.e;
            kdVar.sendMessage(kdVar.obtainMessage(1));
        }
    }
}
