package com.byazt.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, 21})
public class x {
    public static volatile x n;
    public com.byazt.ky.w qg = null;

    private x() {
    }

    public static x n() {
        if (n == null) {
            synchronized (x.class) {
                if (n == null) {
                    n = new x();
                }
            }
        }
        return n;
    }

    public com.byazt.ky.w qg() {
        return this.qg;
    }
}
