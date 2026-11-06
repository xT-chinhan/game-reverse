package com.bytedance.sdk.component.ab.ah.ms;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static String f746ms = "com.bytedance.openadsdk";
    public static String xr = "content://" + f746ms + ".TTMultiProvider";

    static {
        ms();
    }

    public static void ms() {
        Context context = xr.getContext();
        if (context != null) {
            f746ms = context.getPackageName();
            xr = "content://" + f746ms + ".TTMultiProvider";
        }
    }
}
