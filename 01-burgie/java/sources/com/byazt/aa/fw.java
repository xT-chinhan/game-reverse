package com.byazt.aa;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 668, 62})
public class fw {
    public static int pr(View view) {
        if (Build.VERSION.SDK_INT >= 17) {
            return view.getLayoutDirection();
        }
        return 0;
    }
}
