package com.smartdigimkt.n1;

import android.graphics.Rect;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static void a(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
    }

    public static Rect b(WindowInsets windowInsets) {
        Rect rect = new Rect(0, windowInsets.getSystemWindowInsetTop(), 0, 0);
        if (windowInsets.getDisplayCutout() != null) {
            rect.left = windowInsets.getDisplayCutout().getSafeInsetLeft();
            rect.top = Math.max(rect.top, windowInsets.getDisplayCutout().getSafeInsetTop());
            rect.right = windowInsets.getDisplayCutout().getSafeInsetRight();
            rect.bottom = windowInsets.getDisplayCutout().getSafeInsetBottom();
        }
        return rect;
    }

    public static Rect c(WindowInsets windowInsets) {
        Rect rect = new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        if (windowInsets.getDisplayCutout() != null) {
            rect.left = Math.max(rect.left, windowInsets.getDisplayCutout().getSafeInsetLeft());
            rect.top = Math.max(rect.top, windowInsets.getDisplayCutout().getSafeInsetTop());
            rect.right = Math.max(rect.right, windowInsets.getDisplayCutout().getSafeInsetRight());
            rect.bottom = Math.max(rect.bottom, windowInsets.getDisplayCutout().getSafeInsetBottom());
        }
        return rect;
    }

    public static WindowInsets a(WindowInsets windowInsets) {
        return windowInsets.consumeSystemWindowInsets().consumeDisplayCutout();
    }
}
