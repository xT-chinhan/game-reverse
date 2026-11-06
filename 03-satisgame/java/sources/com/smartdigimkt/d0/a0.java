package com.smartdigimkt.d0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.c a;

    public a0(com.smartdigimkt.b3.c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        executorServiceNewFixedThreadPool.submit(new z(this, executorServiceNewFixedThreadPool));
        try {
            synchronized (executorServiceNewFixedThreadPool) {
                executorServiceNewFixedThreadPool.wait(5000L);
            }
            executorServiceNewFixedThreadPool.shutdownNow();
        } catch (Throwable unused) {
        }
    }
}
