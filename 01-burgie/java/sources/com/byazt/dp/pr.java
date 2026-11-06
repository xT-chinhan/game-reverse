package com.byazt.dp;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 480, 37})
public class pr {
    public static void pr(String str) {
        hw.pr.pr(str, 1, 0);
    }

    public static void pr(String str, long j, long j2) {
        if (j > 0) {
            hw.pr.pr(str, 3, (int) ((j2 * 100) / j));
        }
    }

    public static void hw(String str, long j, long j2) {
        if (j > 0) {
            hw.pr.pr(str, 2, (int) ((j2 * 100) / j));
        }
    }

    public static void hn(String str, long j, long j2) {
        if (j > 0) {
            hw.pr.pr(str, 4, (int) ((j2 * 100) / j));
        }
    }

    public static void hw(String str) {
        hw.pr.pr(str, 5, 100);
    }

    public static void hn(String str) {
        hw.pr.pr(str, 6, 100);
    }
}
