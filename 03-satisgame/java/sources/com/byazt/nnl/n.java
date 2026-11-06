package com.byazt.nnl;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 720, 19})
public class n {
    public static volatile boolean n = false;
    public static s qg;
    public static q s;

    public static void n(s sVar, q qVar) {
        if (n) {
            return;
        }
        n = true;
        qg = sVar;
        s = qVar;
    }

    public static s n() {
        return qg;
    }

    public static q qg() {
        return s;
    }
}
