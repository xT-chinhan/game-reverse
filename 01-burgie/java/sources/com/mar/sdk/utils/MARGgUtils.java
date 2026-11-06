package com.mar.sdk.utils;

import android.R;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class MARGgUtils {
    private static int currAdId = 0;

    public static ViewGroup generateBannerViewContainer(Activity activity, int pos) {
        View decorView = activity.getWindow().getDecorView();
        FrameLayout contentParent = (FrameLayout) decorView.findViewById(R.id.content);
        LinearLayout layout = new LinearLayout(activity);
        layout.setOrientation(1);
        layout.setGravity(7);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        contentParent.addView(layout, layoutParams);
        if (pos == 1) {
            ((FrameLayout.LayoutParams) layout.getLayoutParams()).gravity = 49;
        } else {
            ((FrameLayout.LayoutParams) layout.getLayoutParams()).gravity = 81;
        }
        layout.requestLayout();
        return layout;
    }

    public static void destroySelf(View child) {
        ViewGroup parent;
        if (child != null && (parent = (ViewGroup) child.getParent()) != null && (parent instanceof ViewGroup)) {
            parent.removeView(child);
        }
    }

    public static int nextAdId() {
        int i = currAdId + 1;
        currAdId = i;
        return i;
    }
}
