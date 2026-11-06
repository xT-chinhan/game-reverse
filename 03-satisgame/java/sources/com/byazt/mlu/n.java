package com.byazt.mlu;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1911, 19})
public class n {
    public static volatile n n;
    public int qg;

    private n() {
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    public int qg() {
        return this.qg;
    }
}
