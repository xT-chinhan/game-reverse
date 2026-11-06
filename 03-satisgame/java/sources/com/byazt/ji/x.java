package com.byazt.ji;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 115, 21})
public class x {
    public int n(w.n nVar) {
        if (nVar == null) {
            return 100;
        }
        int i = ((100 - (nVar.rv * 20)) - (nVar.tj * 10)) - (nVar.cp * 15);
        if (nVar.x > 0 && nVar.fs == 0) {
            i -= 20;
        }
        return Math.max(i, 0);
    }
}
