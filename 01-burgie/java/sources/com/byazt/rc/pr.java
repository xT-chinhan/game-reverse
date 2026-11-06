package com.byazt.rc;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 91, 37})
public class pr {
    public static x hn;
    public static hn hw;
    public static volatile boolean pr = false;

    public static void pr(hn hnVar, x xVar) {
        if (!pr) {
            pr = true;
            hw = hnVar;
            hn = xVar;
        }
    }

    public static hn pr() {
        return hw;
    }

    public static x hw() {
        return hn;
    }
}
