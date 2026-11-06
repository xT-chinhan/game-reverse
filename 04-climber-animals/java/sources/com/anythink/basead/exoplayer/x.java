package com.anythink.basead.exoplayer;

import android.os.Handler;
import android.os.SystemClock;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public final class x {
    private final b a;
    private final a b;
    private final ae c;
    private int d;
    private Object e;
    private Handler f;
    private int g;
    private long h = -9223372036854775807L;
    private boolean i = true;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    public interface a {
        void a(x xVar);
    }

    public interface b {
        void a(int i, Object obj);
    }

    public x(a aVar, b bVar, ae aeVar, int i, Handler handler) {
        this.b = aVar;
        this.a = bVar;
        this.c = aeVar;
        this.f = handler;
        this.g = i;
    }

    public final ae a() {
        return this.c;
    }

    public final b b() {
        return this.a;
    }

    public final x a(int i) {
        com.anythink.basead.exoplayer.k.a.b(!this.j);
        this.d = i;
        return this;
    }

    public final int c() {
        return this.d;
    }

    public final x a(Object obj) {
        com.anythink.basead.exoplayer.k.a.b(!this.j);
        this.e = obj;
        return this;
    }

    public final Object d() {
        return this.e;
    }

    private x a(Handler handler) {
        com.anythink.basead.exoplayer.k.a.b(!this.j);
        this.f = handler;
        return this;
    }

    public final Handler e() {
        return this.f;
    }

    private x a(long j) {
        com.anythink.basead.exoplayer.k.a.b(!this.j);
        this.h = j;
        return this;
    }

    public final long f() {
        return this.h;
    }

    private x a(int i, long j) {
        com.anythink.basead.exoplayer.k.a.b(!this.j);
        com.anythink.basead.exoplayer.k.a.a(j != -9223372036854775807L);
        if (i < 0 || (!this.c.a() && i >= this.c.b())) {
            throw new o(this.c, i, j);
        }
        this.g = i;
        this.h = j;
        return this;
    }

    public final int g() {
        return this.g;
    }

    private x b(boolean z) {
        com.anythink.basead.exoplayer.k.a.b(!this.j);
        this.i = z;
        return this;
    }

    public final boolean h() {
        return this.i;
    }

    public final x i() {
        com.anythink.basead.exoplayer.k.a.b(!this.j);
        if (this.h == -9223372036854775807L) {
            com.anythink.basead.exoplayer.k.a.a(this.i);
        }
        this.j = true;
        this.b.a(this);
        return this;
    }

    private synchronized x l() {
        com.anythink.basead.exoplayer.k.a.b(this.j);
        this.m = true;
        a(false);
        return this;
    }

    public final synchronized boolean j() {
        return this.m;
    }

    public final synchronized boolean k() {
        boolean z;
        com.anythink.basead.exoplayer.k.a.b(this.j);
        com.anythink.basead.exoplayer.k.a.b(this.f.getLooper().getThread() != Thread.currentThread());
        long jElapsedRealtime = 500;
        long jElapsedRealtime2 = SystemClock.elapsedRealtime() + 500;
        while (true) {
            z = this.l;
            if (z || jElapsedRealtime <= 0) {
                break;
            }
            wait(jElapsedRealtime);
            jElapsedRealtime = jElapsedRealtime2 - SystemClock.elapsedRealtime();
        }
        if (!z) {
            throw new TimeoutException("Message delivery time out");
        }
        return this.k;
    }

    public final synchronized void a(boolean z) {
        this.k = z | this.k;
        this.l = true;
        notifyAll();
    }
}
