package com.byazt.js;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 756, 20})
public class hn {
    public static boolean pr(Context context) {
        if (context == null) {
            return false;
        }
        boolean z = Build.VERSION.SDK_INT >= 17 && TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1;
        return z && (context.getApplicationInfo().flags & 4194304) == 4194304;
    }
}
