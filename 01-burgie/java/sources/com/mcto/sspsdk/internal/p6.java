package com.mcto.sspsdk.internal;

import android.content.res.Configuration;
import android.support.constraint.ConstraintSet;

/* JADX INFO: loaded from: classes2.dex */
public final class p6 implements Runnable {
    public final /* synthetic */ Configuration a;
    public final /* synthetic */ q6 b;

    public p6(q6 q6Var, Configuration configuration) {
        this.b = q6Var;
        this.a = configuration;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q6 q6Var = this.b;
        Configuration configuration = this.a;
        if (q6Var.t != null) {
            q6Var.t.a(new ConstraintSet(), configuration, q6Var);
        }
    }
}
