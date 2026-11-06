package com.anythink.core.common.t;

import android.os.SystemClock;
import com.anythink.core.common.d.t;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    long a;
    long b;
    Runnable c;
    boolean d;
    boolean e;
    b f;
    private final a g;

    public c(long j, Runnable runnable) {
        this.d = false;
        this.e = true;
        this.g = d.a();
        this.f = new b() { // from class: com.anythink.core.common.t.c.1
            @Override // java.lang.Runnable
            public final void run() {
                c.this.d = false;
                c.this.b = -1L;
                if (c.this.e) {
                    t.b().b(c.this.c);
                } else {
                    t.b();
                    t.c(c.this.c);
                }
            }
        };
        this.b = j;
        this.c = runnable;
    }

    public c(long j, Runnable runnable, boolean z) {
        this(j, runnable);
        this.e = z;
    }

    public final synchronized void a() {
        if (this.b >= 0 && !this.d) {
            this.d = true;
            this.a = SystemClock.elapsedRealtime();
            this.g.a(this.f, this.b, false);
        }
    }

    public final synchronized void b() {
        if (this.d) {
            this.d = false;
            this.b -= SystemClock.elapsedRealtime() - this.a;
            this.g.b(this.f);
        }
    }

    public final synchronized void c() {
        this.d = false;
        this.g.b(this.f);
        this.b = -1L;
    }
}
