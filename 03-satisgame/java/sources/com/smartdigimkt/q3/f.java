package com.smartdigimkt.q3;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static volatile f c;
    public final b a = new b();
    public final Handler b = new Handler(Looper.getMainLooper());

    public static f a() {
        if (c == null) {
            synchronized (f.class) {
                if (c == null) {
                    c = new f();
                }
            }
        }
        return c;
    }

    public final void b(Runnable runnable) {
        if (c()) {
            a(runnable, 0L, 13);
        } else {
            runnable.run();
        }
    }

    public final void c(Runnable runnable) {
        a(runnable, 0L, 2);
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final ScheduledThreadPoolExecutor b() {
        b bVar = this.a;
        if (bVar == null) {
            return null;
        }
        if (bVar.j == null) {
            synchronized (b.class) {
                if (bVar.j == null) {
                    bVar.j = new ScheduledThreadPoolExecutor(1, new g(), new a(bVar));
                }
            }
        }
        return bVar.j;
    }

    public final void a(h hVar, int i) {
        try {
            this.a.a(hVar, i);
        } catch (Throwable unused) {
        }
    }

    public final void a(com.smartdigimkt.n3.f fVar) {
        a(fVar, 0L, 8);
    }

    public final void a(Runnable runnable, long j, int i) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutorB;
        if (runnable != null) {
            if (j > 0 && (scheduledThreadPoolExecutorB = b()) != null) {
                scheduledThreadPoolExecutorB.schedule(new c(this, runnable, i), j, TimeUnit.MILLISECONDS);
                return;
            }
            d dVar = new d(runnable);
            Long.valueOf(System.currentTimeMillis() / 1000).intValue();
            a(dVar, i);
        }
    }

    public final void a(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.b.post(runnable);
        }
    }

    public final void a(long j, Runnable runnable) {
        if (j <= 0 && Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            this.b.postDelayed(runnable, j);
        }
    }
}
