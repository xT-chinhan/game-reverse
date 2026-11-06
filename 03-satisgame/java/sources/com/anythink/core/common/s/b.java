package com.anythink.core.common.s;

import android.os.SystemClock;
import com.anythink.core.common.d.s;
import com.anythink.core.common.u.b.e;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    long a;
    long b;
    Runnable c;
    boolean d;
    boolean e;
    com.anythink.core.common.u.b.d f;
    private final a g;

    private b(long j, Runnable runnable) {
        this.d = false;
        this.e = true;
        this.g = c.a();
        this.f = new com.anythink.core.common.u.b.d(e.dt, new Runnable() { // from class: com.anythink.core.common.s.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.this.d = false;
                b.this.b = -1L;
                if (b.this.e) {
                    s.b();
                    s.b(b.this.c);
                } else {
                    com.anythink.core.common.u.b.c.a().a(new com.anythink.core.common.u.b.d(e.cW, b.this.c));
                }
            }
        });
        this.b = j;
        this.c = runnable;
    }

    public b(long j, Runnable runnable, byte b) {
        this(j, runnable);
        this.e = false;
    }

    public final synchronized void a() {
        if (this.b >= 0 && !this.d) {
            this.d = true;
            this.a = SystemClock.elapsedRealtime();
            this.g.a(this.f, this.b);
        }
    }

    private synchronized void c() {
        if (this.d) {
            this.d = false;
            this.b -= SystemClock.elapsedRealtime() - this.a;
            this.g.a(this.f);
        }
    }

    public final synchronized void b() {
        this.d = false;
        this.g.a(this.f);
        this.b = -1L;
    }
}
