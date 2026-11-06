package com.byazt.ya;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1039, 20})
public class hn {
    public static String pr = "com.bytedance.openadsdk";
    public static String hw = "content://" + pr + ".TTMultiProvider";

    public static String pr(Context context) {
        if (context != null) {
            pr = context.getPackageName();
            hw = "content://" + pr + ".TTMultiProvider";
        }
        return hw;
    }
}
