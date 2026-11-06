package com.byazt.aa;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 668, 121})
public final class x {
    public static String pr = null;
    public static Resources hw = null;
    public static Context hn = null;

    private static String pr(Context context) {
        if (pr == null) {
            pr = context.getPackageName();
        }
        return pr;
    }

    private static int pr(Context context, String str, String str2) {
        if (hw == null) {
            hw = context.getResources();
        }
        return hw.getIdentifier(str, str2, pr(context));
    }

    public static int pr(Context context, String str) {
        return pr(context, str, "raw");
    }

    public static int hw(Context context, String str) {
        return pr(context, str, "drawable");
    }
}
