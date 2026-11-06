package com.byazt.bq;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 290, 29})
public class cp {
    public static volatile int l = -1;
    public static volatile float n = -1.0f;
    public static volatile int q = -1;
    public static volatile int qg = -1;
    public static volatile float s = -1.0f;

    public static void n(Context context) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (n()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            n = displayMetrics.density;
            qg = displayMetrics.densityDpi;
            s = displayMetrics.scaledDensity;
            q = displayMetrics.widthPixels;
            l = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (q > l) {
                    int i = q;
                    q = l;
                    l = i;
                    return;
                }
                return;
            }
            if (q < l) {
                int i2 = q;
                q = l;
                l = i2;
            }
        }
    }

    private static boolean n() {
        return n < 0.0f || qg < 0 || s < 0.0f || q < 0 || l < 0;
    }

    public static int qg(Context context) {
        n(context);
        return qg;
    }

    public static int s(Context context) {
        n(context);
        return q;
    }

    public static int q(Context context) {
        n(context);
        return l;
    }
}
