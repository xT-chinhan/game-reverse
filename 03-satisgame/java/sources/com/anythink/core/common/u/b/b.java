package com.anythink.core.common.u.b;

import android.text.TextUtils;
import com.anythink.core.common.t.f;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class b implements ThreadFactory {
    private final String a;
    private volatile int b;
    private final AtomicInteger c = new AtomicInteger(0);

    public b(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public final void a(int i) {
        this.b = i;
    }

    public final int a() {
        return this.b;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.a + "_" + this.c.incrementAndGet());
        thread.setDaemon(true);
        thread.setPriority(this.b);
        final String strA = runnable instanceof d ? ((d) runnable).a() : "";
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.anythink.core.common.u.b.b$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                b.a(strA, thread2, th);
            }
        });
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, Thread thread, Throwable th) {
        try {
            f.b("Thread crash: " + thread.getName() + (!TextUtils.isEmpty(str) ? ", workerId=".concat(String.valueOf(str)) : ""), th != null ? th.getMessage() : "", "");
        } catch (Throwable unused) {
        }
    }
}
