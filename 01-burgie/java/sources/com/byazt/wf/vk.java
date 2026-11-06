package com.byazt.wf;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, 50})
public final class vk {
    public static void pr(String str) {
        com.byazt.vlj.zo.c();
    }

    public static void pr(Throwable th) {
        if (com.byazt.vlj.zo.c().c()) {
            com.byazt.ca.ho.pr("npth", "NPTH Catch Error", th);
        }
    }

    public static void pr(String str, Throwable th) {
        if (com.byazt.vlj.zo.c().c()) {
            com.byazt.ca.ho.pr(str, "NPTH Catch Error", th);
        }
    }

    public static void hw(Throwable th) {
        com.byazt.vlj.zo.c();
    }
}
