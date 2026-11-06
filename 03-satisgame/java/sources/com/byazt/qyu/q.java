package com.byazt.qyu;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1178, 5})
public class q extends Exception {
    public final int n;

    public q(int i, String str) {
        super(str);
        this.n = i;
    }

    public q(int i, String str, Throwable th) {
        super(str, th);
        this.n = i;
    }

    public int n() {
        return this.n;
    }
}
