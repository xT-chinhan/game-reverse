package com.byazt.equ;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 777, 18})
public abstract class l implements Runnable {
    public final String qg;

    public abstract void q();

    public l(String str, Object... objArr) {
        this.qg = tj.n(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.qg);
        try {
            q();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
