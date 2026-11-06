package com.byazt.oo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1330, 8})
public class s extends com.byazt.ncu.s implements Runnable {
    public final Runnable q;

    public s(Runnable runnable) {
        super(runnable);
        this.q = runnable;
        qg(false);
        n(false);
    }

    @Override // com.byazt.ncu.s, java.lang.Runnable
    public void run() {
        this.q.run();
    }
}
