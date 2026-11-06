package com.anythink.core.common.s.a;

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
            this.a = new i$$ExternalSyntheticLambda0(this, runnable);
            h.a().execute(this.a);
        } else {
            if (this.b == null) {
                this.b = new i$$ExternalSyntheticLambda0(this, runnable);
            }
        }
    }

    private Runnable a(Runnable runnable) {
        return new i$$ExternalSyntheticLambda0(this, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            a();
        }
    }

    private synchronized void a() {
        Runnable runnable = this.b;
        this.a = runnable;
        this.b = null;
        if (runnable != null) {
            h.a().execute(this.a);
        }
    }
}
