package com.anythink.core.common.u.b;

import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {
    private final String a;
    private final Runnable b;
    private String d;
    private long e;
    private ThreadPoolExecutor g;
    private String c = null;
    private long f = -1;

    public d(String str, Runnable runnable) {
        this.a = str;
        this.b = runnable;
    }

    public final String a() {
        return this.a;
    }

    private void a(String str) {
        this.d = str;
    }

    private void a(long j) {
        this.e = j;
    }

    private void a(ThreadPoolExecutor threadPoolExecutor) {
        this.g = threadPoolExecutor;
    }

    private void b(long j) {
        this.f = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }
}
