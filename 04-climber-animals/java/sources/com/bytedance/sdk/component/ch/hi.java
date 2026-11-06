package com.bytedance.sdk.component.ch;

import com.tapsdk.tapad.e.a;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final int f1216ms = ab.f1196ms;
    public static final hi xr = new hi();
    private int b;
    private com.bytedance.sdk.component.ch.ms.ka h;
    private com.bytedance.sdk.component.ch.ms.xr i;
    private volatile boolean ny;
    private volatile boolean op;
    private volatile ThreadPoolExecutor qv;
    private volatile ScheduledExecutorService t;
    private boolean w;
    private volatile ThreadPoolExecutor y;
    private volatile boolean yu;
    public volatile boolean ah = true;
    private long c = 5000;
    private long ab = 20000;
    private volatile boolean x = true;
    private boolean ch = true;
    private long hi = 100;
    private long sl = 50;
    private long zb = 1000;
    private long u = a.f;
    private boolean ub = false;
    private volatile boolean ao = true;
    private boolean nw = true;
    private boolean re = true;
    private volatile boolean le = true;
    private volatile boolean cv = true;
    private int d = Math.min(f1216ms, 4);
    private int ka = 50;

    private hi() {
    }

    public void ms(int i) {
        this.b = i;
    }

    public boolean xr(int i) {
        return (this.b & i) == i;
    }

    public boolean ms() {
        return this.ch;
    }

    public void ms(boolean z) {
        this.ch = z;
    }

    public boolean xr() {
        return this.nw;
    }

    public void xr(boolean z) {
        this.nw = z;
    }

    public com.bytedance.sdk.component.ch.ms.xr ah() {
        return this.i;
    }

    public void ms(com.bytedance.sdk.component.ch.ms.xr xrVar) {
        this.i = xrVar;
    }

    public long d() {
        return this.hi;
    }

    public boolean ka() {
        return this.ah;
    }

    public void ah(boolean z) {
        this.ah = z;
    }

    public boolean c() {
        return this.w;
    }

    public void d(boolean z) {
        this.w = z;
    }

    public com.bytedance.sdk.component.ch.ms.ka ab() {
        if (this.h == null) {
            this.h = new com.bytedance.sdk.component.ch.ms.ka();
        }
        return this.h;
    }

    public int x() {
        return this.d;
    }

    public void ah(int i) {
        this.d = i;
        ny().setCorePoolSize(i);
        ch().setCorePoolSize(i);
    }

    public ThreadPoolExecutor ny() {
        if (this.qv == null) {
            synchronized (this) {
                if (this.qv == null) {
                    this.qv = new com.bytedance.sdk.component.ch.ah.d(this.d, this.ka, this.ab, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ch(10, "a") { // from class: com.bytedance.sdk.component.ch.hi.1
                        @Override // com.bytedance.sdk.component.ch.ch
                        protected Thread ms(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.qv;
    }

    public ThreadPoolExecutor ch() {
        if (this.y == null) {
            synchronized (this) {
                if (this.y == null) {
                    this.y = new com.bytedance.sdk.component.ch.ah.xr(this.d, this.ka, this.c, TimeUnit.MILLISECONDS, new ch(10, "b") { // from class: com.bytedance.sdk.component.ch.hi.2
                        @Override // com.bytedance.sdk.component.ch.ch
                        protected Thread ms(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.cv) {
                        try {
                            this.y.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.y;
    }

    public void ms(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.y;
        this.y = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ka.ms(threadPoolExecutor, threadPoolExecutor2);
    }

    public void xr(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.qv;
        this.qv = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ((com.bytedance.sdk.component.ch.ah.d) threadPoolExecutor2).ah();
        ka.ms(threadPoolExecutor, threadPoolExecutor2);
    }

    public void d(int i) {
        this.ka = i;
        ny().setMaximumPoolSize(i);
        ch().setMaximumPoolSize(i);
    }

    public int hi() {
        return this.ka;
    }

    public void ka(boolean z) {
        this.ny = z;
    }

    public ScheduledExecutorService sl() {
        if (this.t == null) {
            synchronized (this) {
                if (this.t == null) {
                    this.t = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.bytedance.sdk.component.ch.hi.3
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, hi.this.w ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.bytedance.sdk.component.ch.d.ms.f1214ms);
                }
            }
        }
        return this.t;
    }

    public void ms(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            return;
        }
        final ScheduledExecutorService scheduledExecutorService2 = this.t;
        this.t = scheduledExecutorService;
        if (scheduledExecutorService2 == null || scheduledExecutorService2 == scheduledExecutorService) {
            return;
        }
        this.t.schedule(new Runnable() { // from class: com.bytedance.sdk.component.ch.hi.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scheduledExecutorService2.shutdown();
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ah("ThreadCenter", e);
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    public ThreadPoolExecutor zb() {
        if (this.ny) {
            return ch();
        }
        return ny();
    }

    public void ms(long j) {
        this.c = j;
        ch().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }

    public void c(boolean z) {
        this.x = z;
    }

    public boolean u() {
        return this.yu;
    }

    public void ab(boolean z) {
        if (z) {
            x(false);
            ab.ms(false);
        }
        this.yu = z;
    }

    public boolean ub() {
        return this.op;
    }

    public boolean ao() {
        return this.le && ab.ka();
    }

    public void x(boolean z) {
        if (this.yu) {
            return;
        }
        if (this.y != null) {
            this.y.allowCoreThreadTimeOut(z);
        }
        this.cv = z;
    }

    public long h() {
        return this.sl;
    }

    public void xr(long j) {
        this.sl = j;
    }

    public long qv() {
        return this.zb;
    }

    public void ah(long j) {
        this.zb = j;
    }

    public long y() {
        return this.u;
    }

    public void d(long j) {
        this.u = j;
    }

    public boolean t() {
        return this.ub;
    }

    public void ny(boolean z) {
        this.ub = z;
    }
}
