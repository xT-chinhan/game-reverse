package com.smartdigimkt.l4;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements Executor {
    public Runnable a;
    public Runnable b;

    public final void a(Runnable runnable) {
        try {
            runnable.run();
            synchronized (this) {
                Runnable runnable2 = this.b;
                this.a = runnable2;
                this.b = null;
                if (runnable2 != null) {
                    u.a().execute(this.a);
                }
            }
        } catch (Throwable th) {
            a();
            throw th;
        }
    }

    public final Runnable b(final Runnable runnable) {
        return new Runnable() { // from class: com.smartdigimkt.l4.v$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(runnable);
            }
        };
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.a == null) {
            this.a = b(runnable);
            u.a().execute(this.a);
        } else if (this.b == null) {
            this.b = b(runnable);
        }
    }

    public final synchronized void a() {
        Runnable runnable = this.b;
        this.a = runnable;
        this.b = null;
        if (runnable != null) {
            u.a().execute(this.a);
        }
    }
}
