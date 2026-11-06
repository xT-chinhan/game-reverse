package com.byazt.rb;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1315, 13})
public class w {
    public static int l = -1;
    public static float n = -1.0f;
    public static int q = -1;
    public static int qg = -1;
    public static float s = -1.0f;

    static {
        n(com.byazt.qt.qg.getContext());
    }

    public static void n(Context context) {
        Context context2 = context == null ? com.byazt.qt.qg.getContext() : context;
        if (context2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        n = displayMetrics.density;
        qg = displayMetrics.densityDpi;
        s = displayMetrics.scaledDensity;
        q = displayMetrics.widthPixels;
        l = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i = q;
            int i2 = l;
            if (i > i2) {
                q = i2;
                l = i;
                return;
            }
            return;
        }
        int i3 = q;
        int i4 = l;
        if (i3 < i4) {
            q = i4;
            l = i3;
        }
    }

    public static int n(Context context, float f) {
        n(context);
        float fQ = q(context);
        if (fQ <= 0.0f) {
            fQ = 1.0f;
        }
        return (int) ((f / fQ) + 0.5f);
    }

    public static int qg(Context context) {
        n(context);
        return q;
    }

    public static int s(Context context) {
        n(context);
        return l;
    }

    public static float q(Context context) {
        n(context);
        return n;
    }

    public static int qg(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
