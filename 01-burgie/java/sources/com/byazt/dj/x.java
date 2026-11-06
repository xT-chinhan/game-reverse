package com.byazt.dj;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 971, 121})
public class x {
    public static Context getContext() {
        if (com.byazt.bg.pr.pr().hn() == null) {
            return null;
        }
        return com.byazt.bg.pr.pr().hn().getContext();
    }

    public static boolean pr() {
        com.byazt.bg.hn hnVarHn = com.byazt.bg.pr.pr().hn();
        return hnVarHn != null && hnVarHn.c() == 1;
    }

    public static int hw() {
        return com.byazt.bg.pr.pr().hn().zo();
    }
}
