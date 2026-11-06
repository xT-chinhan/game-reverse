package com.smartdigimkt.n1;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f {
    public static void a(Window window) {
        window.setDecorFitsSystemWindows(false);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 3;
        window.setAttributes(attributes);
    }

    public static Rect b(WindowInsets windowInsets, boolean z) {
        int iSystemBars = WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        if (z) {
            iSystemBars |= WindowInsets.Type.ime();
        }
        Insets insets = windowInsets.getInsets(iSystemBars);
        return new Rect(insets.left, insets.top, insets.right, insets.bottom);
    }

    public static WindowInsets a(WindowInsets windowInsets, boolean z) {
        int iSystemBars = WindowInsets.Type.systemBars() | WindowInsets.Type.displayCutout();
        if (z) {
            iSystemBars |= WindowInsets.Type.ime();
        }
        return new WindowInsets.Builder(windowInsets).setInsets(iSystemBars, Insets.NONE).setDisplayCutout(null).build();
    }

    public static Rect a(WindowInsets windowInsets) {
        Insets insets = windowInsets.getInsets(WindowInsets.Type.statusBars() | WindowInsets.Type.displayCutout());
        return new Rect(insets.left, insets.top, insets.right, insets.bottom);
    }
}
