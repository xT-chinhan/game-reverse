package com.anythink.core.common.v.b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;
    private static volatile b s;
    private final a t = new a();

    private static void e() {
    }

    private b() {
    }

    public static b a() {
        if (s == null) {
            synchronized (b.class) {
                if (s == null) {
                    s = new b();
                }
            }
        }
        return s;
    }

    public final void a(d dVar, int i2) {
        try {
            this.t.a(dVar, i2);
        } catch (Throwable unused) {
        }
    }

    public final void b(Runnable runnable, int i2) {
        a(runnable, 0L, i2);
    }

    private void d(Runnable runnable) {
        c(runnable, 13);
    }

    public final void c(Runnable runnable, int i2) {
        if (b()) {
            a(runnable, i2);
        } else {
            runnable.run();
        }
    }

    public final void a(Runnable runnable, long j2) {
        a(runnable, j2, 2);
    }

    public final void a(final Runnable runnable, final long j2, int i2) {
        if (runnable != null) {
            d dVar = new d() { // from class: com.anythink.core.common.v.b.b.1
                @Override // com.anythink.core.common.v.b.d
                public final void a() {
                    long j3 = j2;
                    if (j3 > 0) {
                        try {
                            Thread.sleep(j3);
                        } catch (InterruptedException unused) {
                        }
                    }
                    b();
                    runnable.run();
                }
            };
            dVar.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a(dVar, i2);
        }
    }

    public final void b(final Runnable runnable) {
        if (TextUtils.equals(Thread.currentThread().getName(), a.b(6))) {
            runnable.run();
        } else if (runnable != null) {
            d dVar = new d() { // from class: com.anythink.core.common.v.b.b.2
                @Override // com.anythink.core.common.v.b.d
                public final void a() {
                    runnable.run();
                }
            };
            dVar.a(Long.valueOf(System.currentTimeMillis() / 1000).intValue());
            a(dVar, 6);
        }
    }

    public final void c(Runnable runnable) {
        a(runnable, 1000L, 2);
    }

    public final Handler a(int i2) {
        return this.t.a(i2);
    }

    public static boolean b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public final Executor c() {
        a aVar = this.t;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public final ExecutorService d() {
        a aVar = this.t;
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public final void a(Runnable runnable) {
        a(runnable, 0L, 2);
    }

    public final void a(Runnable runnable, int i2) {
        a(runnable, 0L, i2);
    }

    private void e(Runnable runnable) {
        a(runnable, 0L, 2);
    }

    private void f(Runnable runnable) {
        a(runnable, 0L, 2);
    }
}
