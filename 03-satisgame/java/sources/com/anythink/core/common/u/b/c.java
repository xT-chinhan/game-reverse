package com.anythink.core.common.u.b;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.h;
import com.anythink.core.common.d.s;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final String a = "c";
    private static final String b = "anythink_core";
    private static final String c = "anythink_mediation";
    private static final String h = "anythink_tracking";
    private static final String i = "anythink_scheduler";
    private static final String j = "anythink_adapter";
    private static final String k = "anythink_kv";
    private static final int m = 6;
    private static volatile c o;
    private static final g l = g.a(2, 2, 10, 60, 4);
    private static final String d = "anythink_network";
    private static final String e = "anythink_io";
    private static final String f = "anythink_dns";
    private static final String g = "anythink_tcp";
    private static final List<String> n = Arrays.asList(d, e, f, g);
    private h A = h.g();
    private final Handler p = new Handler(Looper.getMainLooper());
    private volatile ScheduledThreadPoolExecutor q = a(b, this.A.a());
    private volatile ScheduledThreadPoolExecutor r = a(c, this.A.b());
    private volatile ThreadPoolExecutor s = b(d, this.A.c());
    private volatile ThreadPoolExecutor t = b(e, this.A.d());
    private volatile ThreadPoolExecutor w = a(h, this.A.e());
    private volatile ScheduledThreadPoolExecutor x = a(i, this.A.f());
    private final ThreadPoolExecutor u = b(f, l);
    private final ThreadPoolExecutor v = new ThreadPoolExecutor(6, 6, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(6), new b(g, 4), new ThreadPoolExecutor.AbortPolicy());
    private final ScheduledExecutorService y = Executors.newSingleThreadScheduledExecutor(new b(j, 5));
    private final ScheduledExecutorService z = Executors.newSingleThreadScheduledExecutor(new b(k, 4));

    private static Runnable p(d dVar) {
        return dVar;
    }

    private static Runnable q(d dVar) {
        return dVar;
    }

    public static c a() {
        if (o == null) {
            synchronized (c.class) {
                if (o == null) {
                    o = new c();
                }
            }
        }
        return o;
    }

    private c() {
    }

    private /* synthetic */ void e() {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        while (threadGroup.getParent() != null) {
            threadGroup = threadGroup.getParent();
        }
        Log.w(a + "_monitor", "Active threads: " + threadGroup.activeCount() + "\n   core       : core=" + this.q.getCorePoolSize() + ", max=" + this.q.getMaximumPoolSize() + ", queue=" + this.q.getQueue().size() + ", active=" + this.q.getActiveCount() + ", priority=" + a(this.q) + "\n   mediation  : core=" + this.r.getCorePoolSize() + ", max=" + this.r.getMaximumPoolSize() + ", queue=" + this.r.getQueue().size() + ", active=" + this.r.getActiveCount() + ", priority=" + a(this.r) + "\n   network    : core=" + this.s.getCorePoolSize() + ", max=" + this.s.getMaximumPoolSize() + ", queue=" + this.s.getQueue().size() + ", active=" + this.s.getActiveCount() + ", priority=" + a(this.s) + "\n   io         : core=" + this.t.getCorePoolSize() + ", max=" + this.t.getMaximumPoolSize() + ", queue=" + this.t.getQueue().size() + ", active=" + this.t.getActiveCount() + ", priority=" + a(this.t) + "\n   dns        : core=" + this.u.getCorePoolSize() + ", max=" + this.u.getMaximumPoolSize() + ", queue=" + this.u.getQueue().size() + ", active=" + this.u.getActiveCount() + ", priority=" + a(this.u) + "\n   tcp        : core=" + this.v.getCorePoolSize() + ", max=" + this.v.getMaximumPoolSize() + ", queue=" + this.v.getQueue().size() + ", active=" + this.v.getActiveCount() + ", priority=" + a(this.v) + "\n   tracking   : core=" + this.w.getCorePoolSize() + ", max=" + this.w.getMaximumPoolSize() + ", queue=" + this.w.getQueue().size() + ", active=" + this.w.getActiveCount() + ", priority=" + a(this.w) + "\n   scheduler  : core=" + this.x.getCorePoolSize() + ", max=" + this.x.getMaximumPoolSize() + ", queue=" + this.x.getQueue().size() + ", active=" + this.x.getActiveCount() + ", priority=" + a(this.x));
    }

    public final void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (c()) {
            runnable.run();
        } else {
            this.p.post(runnable);
        }
    }

    public final void a(Runnable runnable, long j2) {
        if (runnable == null) {
            return;
        }
        if (j2 <= 0 && c()) {
            runnable.run();
        } else {
            this.p.postDelayed(runnable, j2);
        }
    }

    public final void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.p.removeCallbacks(runnable);
    }

    private void j(d dVar) {
        this.q.execute(dVar);
    }

    private ScheduledFuture<?> c(d dVar, long j2) {
        return this.q.schedule(dVar, j2, TimeUnit.MILLISECONDS);
    }

    public final void b(d dVar) {
        a(dVar, true);
    }

    public final void a(d dVar, boolean z) {
        if (!z && a(c)) {
            dVar.run();
        } else {
            this.r.execute(dVar);
        }
    }

    public final ScheduledFuture<?> a(d dVar, long j2) {
        return this.r.schedule(dVar, j2, TimeUnit.MILLISECONDS);
    }

    private void k(d dVar) {
        this.s.execute(dVar);
    }

    public final ExecutorService b() {
        return this.s;
    }

    public final boolean d(d dVar) {
        try {
            this.v.execute(dVar);
            return true;
        } catch (RejectedExecutionException unused) {
            return false;
        }
    }

    private void l(d dVar) {
        this.t.execute(dVar);
    }

    private void m(d dVar) {
        this.u.execute(dVar);
    }

    private void n(d dVar) {
        this.w.execute(dVar);
    }

    private void o(d dVar) {
        this.y.execute(dVar);
    }

    private ScheduledFuture<?> d(d dVar, long j2) {
        return this.y.schedule(dVar, j2, TimeUnit.MILLISECONDS);
    }

    public final void i(d dVar) {
        this.z.execute(dVar);
    }

    public final ScheduledFuture<?> b(d dVar, long j2) {
        return this.x.schedule(dVar, j2, TimeUnit.MILLISECONDS);
    }

    private ScheduledFuture<?> a(d dVar, long j2, long j3) {
        return this.x.scheduleAtFixedRate(dVar, j2, j3, TimeUnit.MILLISECONDS);
    }

    public static void a(ScheduledFuture<?> scheduledFuture) {
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        scheduledFuture.cancel(false);
    }

    private static int a(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null || !(threadPoolExecutor.getThreadFactory() instanceof b)) {
            return -1;
        }
        return ((b) threadPoolExecutor.getThreadFactory()).a();
    }

    private static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean a(String str) {
        return Thread.currentThread().getName().startsWith(str);
    }

    private static boolean b(String str) {
        return !n.contains(str);
    }

    public final synchronized void a(h hVar) {
        if (hVar == null) {
            return;
        }
        try {
            this.q = (ScheduledThreadPoolExecutor) a(b, hVar.a(), this.A.a(), this.q, false);
            this.r = (ScheduledThreadPoolExecutor) a(c, hVar.b(), this.A.b(), this.r, false);
            this.x = (ScheduledThreadPoolExecutor) a(i, hVar.f(), this.A.f(), this.x, false);
            this.w = a(h, hVar.e(), this.A.e(), this.w, false);
            ThreadPoolExecutor threadPoolExecutor = this.s;
            ThreadPoolExecutor threadPoolExecutor2 = this.t;
            this.s = a(d, hVar.c(), this.A.c(), this.s, true);
            this.t = a(e, hVar.d(), this.A.d(), this.t, true);
            if (this.s != threadPoolExecutor) {
                threadPoolExecutor.shutdown();
            }
            if (this.t != threadPoolExecutor2) {
                threadPoolExecutor2.shutdown();
            }
            this.A = hVar;
        } catch (Throwable unused) {
            f.b("update pool config", "update failed: " + p.a(new Throwable().getStackTrace()), s.b().r());
        }
    }

    private static <T extends ThreadPoolExecutor> T a(String str, g gVar, g gVar2, T t, boolean z) {
        if (gVar != null) {
            try {
                if (gVar.a() > 0) {
                    int iMax = Math.max(1, gVar.a());
                    int iMax2 = Math.max(iMax, gVar.b());
                    if (z && gVar2 != null && gVar.c() > 0 && gVar.c() != gVar2.c()) {
                        T t2 = (T) b(str, g.a(iMax, iMax2, gVar.c(), (int) (gVar.d() > 0 ? gVar.d() : gVar2.d()), gVar.e() > 0 ? gVar.e() : gVar2.e()));
                        ArrayList arrayList = new ArrayList();
                        t.getQueue().drainTo(arrayList);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            try {
                                t2.execute((Runnable) it.next());
                            } catch (Throwable unused) {
                            }
                        }
                        return t2;
                    }
                    if (b(str)) {
                        if (iMax != t.getCorePoolSize()) {
                            t.setCorePoolSize(iMax);
                        }
                    } else if (iMax2 != t.getMaximumPoolSize() || iMax != t.getCorePoolSize()) {
                        if (iMax2 > t.getMaximumPoolSize()) {
                            t.setMaximumPoolSize(iMax2);
                            t.setCorePoolSize(iMax);
                        } else {
                            t.setCorePoolSize(iMax);
                            t.setMaximumPoolSize(iMax2);
                        }
                    }
                    long jD = gVar.d();
                    if (jD > 0 && jD != t.getKeepAliveTime(TimeUnit.SECONDS)) {
                        t.setKeepAliveTime(jD, TimeUnit.SECONDS);
                    }
                    int iE = gVar.e();
                    if (iE > 0 && ((gVar2 == null || iE != gVar2.e()) && (t.getThreadFactory() instanceof b))) {
                        ((b) t.getThreadFactory()).a(iE);
                    }
                }
            } catch (Throwable unused2) {
                f.b("apply pool config", str + " apply failed: " + p.a(new Throwable().getStackTrace()), s.b().r());
            }
        }
        return t;
    }

    private static ScheduledThreadPoolExecutor a(String str, g gVar) {
        return new ScheduledThreadPoolExecutor(Math.max(1, gVar.a()), new b(str, Math.max(1, Math.min(10, gVar.e()))));
    }

    private static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(6, 6, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(6), new b(g, 4), new ThreadPoolExecutor.AbortPolicy());
    }

    private static ThreadPoolExecutor b(String str, g gVar) {
        int iMax = Math.max(1, gVar.a());
        int iMax2 = Math.max(iMax, gVar.b());
        int iMax3 = Math.max(1, gVar.c());
        return new ThreadPoolExecutor(iMax, iMax2, Math.max(0L, gVar.d()), TimeUnit.SECONDS, b(str) ? new LinkedBlockingQueue() : new LinkedBlockingQueue(iMax3), new b(str, Math.max(1, Math.min(10, gVar.e()))), new a(str));
    }

    public final void a(d dVar) {
        this.q.execute(dVar);
    }

    public final void c(d dVar) {
        this.s.execute(dVar);
    }

    public final void e(d dVar) {
        this.t.execute(dVar);
    }

    public final void f(d dVar) {
        this.u.execute(dVar);
    }

    public final void g(d dVar) {
        this.w.execute(dVar);
    }

    public final void h(d dVar) {
        this.y.execute(dVar);
    }
}
