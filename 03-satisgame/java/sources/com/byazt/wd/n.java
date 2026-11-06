package com.byazt.wd;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 584, 19})
public class n extends qg {
    public static volatile n n;

    private n() {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    @Override // com.byazt.wd.qg
    public synchronized int qg() {
        int iS = com.byazt.ed.q.n().s();
        float fQ = com.byazt.ed.q.n().q();
        if (fQ <= 0.0f) {
            return iS;
        }
        return (int) Math.ceil(fQ * iS);
    }

    @Override // com.byazt.wd.qg
    public synchronized long s() {
        return com.byazt.ed.q.n().qg();
    }
}
