package com.anythink.core.common.r.a;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class i implements Executor {
    private Runnable a;
    private Runnable b;

    i() {
    }

    @Override // java.util.concurrent.Executor
    public final synchronized void execute(Runnable runnable) {
        if (this.a == null) {
            this.a = a(runnable);
            h.a().execute(this.a);
        } else {
            if (this.b == null) {
                this.b = a(runnable);
            }
        }
    }

    private Runnable a(final Runnable runnable) {
        return new com.anythink.core.common.u.b.d(com.anythink.core.common.u.b.e.dA, new Runnable() { // from class: com.anythink.core.common.r.a.i.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    runnable.run();
                } finally {
                    i.this.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.b;
        this.a = runnable;
        this.b = null;
        if (runnable != null) {
            h.a().execute(this.a);
        }
    }
}
