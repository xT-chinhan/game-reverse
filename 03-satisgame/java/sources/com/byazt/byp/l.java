package com.byazt.byp;

import com.byazt.nf.rv;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 74, 18})
public class l {
    public static String n = "com.bytedance.openadsdk";
    public static String qg = "content://" + n + ".TTMultiProvider";

    static {
        n();
    }

    public static void n() {
        if (rv.getContext() != null) {
            n = rv.getContext().getPackageName();
            qg = "content://" + n + ".TTMultiProvider";
        }
    }
}
