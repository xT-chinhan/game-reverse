package com.byazt.eq;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 661, 62})
public class fw {
    public static pr pr;

    public interface pr {
        void pr(String str, String str2, Throwable th);
    }

    public static void pr(pr prVar) {
        pr = prVar;
    }

    public static boolean pr() {
        return pr != null;
    }

    public static void pr(String str, String str2, Throwable th) {
        if (pr == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        pr.pr(str, str2, th);
    }
}
