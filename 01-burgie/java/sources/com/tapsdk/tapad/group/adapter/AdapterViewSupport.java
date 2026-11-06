package com.tapsdk.tapad.group.adapter;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class AdapterViewSupport {
    private AdapterViewSupport() {
    }

    private static DisplayMetrics appMetrics(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics();
    }

    public static boolean attachBanner(Activity activity, View view, int i, int i2) {
        if (activity == null || view == null) {
            return false;
        }
        View viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        if (!(viewFindViewById instanceof FrameLayout)) {
            return false;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (i == 0) {
            layoutParams.setMargins(0, i2, 0, 0);
            layoutParams.gravity = 49;
        } else {
            layoutParams.setMargins(0, 0, 0, i2);
            layoutParams.gravity = 81;
        }
        ((FrameLayout) viewFindViewById).addView(view, layoutParams);
        return true;
    }

    public static int dpToPx(Context context, float f) {
        return (int) (f * metrics(context).density);
    }

    private static DisplayMetrics metrics(Context context) {
        return context.getResources().getDisplayMetrics();
    }

    public static float pxToDp(Context context, float f) {
        return f / metrics(context).density;
    }

    public static int screenHeightPx(Context context) {
        return appMetrics(context).heightPixels;
    }

    public static float screenWidthDp(Context context) {
        DisplayMetrics displayMetricsMetrics = metrics(context);
        float f = displayMetricsMetrics.widthPixels;
        float f2 = displayMetricsMetrics.density;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (f / f2) + 0.5f;
    }

    public static int screenWidthPx(Context context) {
        return appMetrics(context).widthPixels;
    }
}
