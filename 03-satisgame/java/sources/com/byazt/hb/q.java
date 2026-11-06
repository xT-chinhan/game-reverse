package com.byazt.hb;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 583, 5})
public final class q {
    public static String n;
    public static Resources qg;
    public static Context s;

    private static String n(Context context) {
        if (n == null) {
            n = context.getPackageName();
        }
        return n;
    }

    private static int n(Context context, String str, String str2) {
        if (qg == null) {
            qg = context.getResources();
        }
        return qg.getIdentifier(str, str2, n(context));
    }

    public static int n(Context context, String str) {
        return n(context, str, "raw");
    }

    public static int qg(Context context, String str) {
        return n(context, str, "drawable");
    }
}
