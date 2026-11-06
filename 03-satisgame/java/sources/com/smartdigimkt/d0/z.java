package com.smartdigimkt.d0;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements Runnable {
    public final /* synthetic */ ExecutorService a;
    public final /* synthetic */ a0 b;

    public z(a0 a0Var, ExecutorService executorService) {
        this.b = a0Var;
        this.a = executorService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b0 b0VarA = c0.a(com.smartdigimkt.i3.n.a().b(4, com.smartdigimkt.r4.i.b(this.b.a.i)));
            if (b0VarA != null) {
                com.smartdigimkt.b3.c cVar = this.b.a;
                cVar.G = b0VarA.a;
                cVar.H = b0VarA.b;
            }
        } catch (Throwable unused) {
        }
        try {
            synchronized (this.a) {
                this.a.notifyAll();
            }
        } catch (Throwable unused2) {
        }
    }
}
