package com.anythink.unitybridge.utils;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class CommonUtil {
    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getResId(Context context, String str, String str2) {
        if (context == null) {
            return -1;
        }
        return context.getResources().getIdentifier("anythink_" + str, str2, context.getPackageName());
    }
}
