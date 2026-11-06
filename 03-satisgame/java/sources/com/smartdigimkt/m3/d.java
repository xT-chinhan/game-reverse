package com.smartdigimkt.m3;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public long a;
    public long b;
    public final Runnable c;
    public boolean d = false;
    public final f e = g.a().a;
    public final c f = new c(this);

    public d(long j, Runnable runnable) {
        this.b = j;
        this.c = runnable;
    }

    public final synchronized void a() {
        if (this.d) {
            this.d = false;
            this.b -= SystemClock.elapsedRealtime() - this.a;
            this.e.a(this.f);
        }
    }

    public final synchronized void b() {
        if (this.b >= 0 && !this.d) {
            this.d = true;
            this.a = SystemClock.elapsedRealtime();
            this.e.a(this.f, this.b);
        }
    }

    public final synchronized void c() {
        this.d = false;
        this.e.a(this.f);
        this.b = -1L;
    }
}
