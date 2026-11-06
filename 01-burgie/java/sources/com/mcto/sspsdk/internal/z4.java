package com.mcto.sspsdk.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final class z4 implements Callable {
    public final /* synthetic */ f5 a;

    public z4(f5 f5Var) {
        this.a = f5Var;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        synchronized (this.a) {
            f5 f5Var = this.a;
            if (f5Var.i == null) {
                return null;
            }
            f5Var.e();
            f5 f5Var2 = this.a;
            int i = f5Var2.k;
            if (i >= 1000 && i >= f5Var2.j.size()) {
                this.a.d();
                this.a.k = 0;
            }
            return null;
        }
    }
}
