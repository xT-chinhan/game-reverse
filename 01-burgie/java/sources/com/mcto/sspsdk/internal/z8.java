package com.mcto.sspsdk.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class z8 implements Runnable {
    public final /* synthetic */ d9 a;

    public z8(d9 d9Var) {
        this.a = d9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.a.p.await(1500L, TimeUnit.MILLISECONDS)) {
                kh.a.a(new y8(this));
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
