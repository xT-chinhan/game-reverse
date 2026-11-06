package com.mcto.sspsdk.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class j8 implements Runnable {
    public final /* synthetic */ k8 a;

    public j8(k8 k8Var) {
        this.a = k8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.t.await(3000L, TimeUnit.MILLISECONDS)) {
                kh.a.a(new i8(this));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
