package com.anythink.core.common.u.b;

import android.os.SystemClock;
import com.anythink.core.common.d.s;
import com.anythink.core.common.t.f;
import com.anythink.core.common.u.p;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class a implements RejectedExecutionHandler {
    private static final long d = 1000;
    private final String a;
    private final ThreadLocal<Boolean> b = new ThreadLocal<>();
    private final AtomicLong c = new AtomicLong(0);

    public a(String str) {
        this.a = str;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        String strA = runnable instanceof d ? ((d) runnable).a() : "";
        if (!Boolean.TRUE.equals(this.b.get())) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.c.get();
            if (jElapsedRealtime - j >= d && this.c.compareAndSet(j, jElapsedRealtime)) {
                this.b.set(Boolean.TRUE);
                try {
                    f.b("ThreadPool rejected: " + this.a, "workerId=" + strA + ". queueSize=" + threadPoolExecutor.getQueue().size() + ", activeCount=" + threadPoolExecutor.getActiveCount() + ", poolSize=" + threadPoolExecutor.getPoolSize() + ", waterFlush=" + com.anythink.core.common.t.a.a.a().d() + ", stack=" + p.a(new Throwable().getStackTrace()), s.b().r());
                } catch (Throwable unused) {
                }
                this.b.remove();
            }
        }
        c.a().a(new d(e.aj + "_" + strA, runnable));
    }
}
