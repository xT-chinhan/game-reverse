package com.byazt.er;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 717, 8})
public class s {
    public static String n = "com.bytedance.openadsdk";
    public static String qg = "content://" + n + ".TTMultiProvider";

    public static String n(Context context) {
        if (context != null) {
            n = context.getPackageName();
            qg = "content://" + n + ".TTMultiProvider";
        }
        return qg;
    }
}
