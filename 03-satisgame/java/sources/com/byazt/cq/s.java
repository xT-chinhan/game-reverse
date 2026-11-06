package com.byazt.cq;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 883, 8})
public class s {
    public static boolean n(Context context) {
        if (context == null) {
            return false;
        }
        return (TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1) && (context.getApplicationInfo().flags & 4194304) == 4194304;
    }
}
