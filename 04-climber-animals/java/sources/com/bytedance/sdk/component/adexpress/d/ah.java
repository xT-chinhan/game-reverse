package com.bytedance.sdk.component.adexpress.d;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    public static boolean ms(Context context) {
        if (context == null) {
            return false;
        }
        return (TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1) && (context.getApplicationInfo().flags & 4194304) == 4194304;
    }
}
