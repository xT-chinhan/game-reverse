package com.byazt.wd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 584, 101})
public class fs extends qg {
    public static volatile fs n;

    private fs() {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new fs();
                }
            }
        }
        return n;
    }

    @Override // com.byazt.wd.qg
    public int qg() {
        return com.byazt.ed.q.n().s();
    }

    @Override // com.byazt.wd.qg
    public long s() {
        return com.byazt.ed.q.n().qg();
    }
}
