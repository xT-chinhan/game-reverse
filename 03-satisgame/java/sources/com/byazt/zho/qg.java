package com.byazt.zho;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1548, 26})
public abstract class qg implements Runnable {
    public final String qg;

    public abstract void w();

    public qg(String str, Object... objArr) {
        this.qg = s.n(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.qg);
        try {
            w();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
