package com.byazt.jz;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2277, 18})
public class l {
    public static String n = "com.bytedance.openadsdk";
    public static String qg = "content://" + n + ".TTMultiProvider";

    static {
        n();
    }

    public static void n() {
        Context context = qg.getContext();
        if (context != null) {
            n = context.getPackageName();
            qg = "content://" + n + ".TTMultiProvider";
        }
    }
}
