package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.re;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static String f2927ms = "com.bytedance.openadsdk";
    public static String xr = "content://" + f2927ms + ".TTMultiProvider";

    static {
        ms();
    }

    public static void ms() {
        if (re.getContext() != null) {
            f2927ms = re.getContext().getPackageName();
            xr = "content://" + f2927ms + ".TTMultiProvider";
        }
    }
}
