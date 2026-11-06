package com.mcto.sspsdk.internal;

/* JADX INFO: loaded from: classes2.dex */
public final class k1 implements Runnable {
    public final /* synthetic */ r1 a;

    public k1(r1 r1Var) {
        this.a = r1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.a.o.tryLock()) {
            String str = this.a.a;
            return;
        }
        try {
            r1.a(this.a);
        } finally {
            this.a.o.unlock();
        }
    }
}
