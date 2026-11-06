package com.smartdigimkt.n1;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {
    public static void a(Window window) {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return;
        }
        if (i >= 30) {
            f.a(window);
        } else {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
            d.a(window);
        }
        if (i >= 29) {
            e.a(window);
        }
        window.clearFlags(201326592);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        window.setNavigationBarColor(0);
    }

    public static void a(View view, boolean z) {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        h hVar = new h(view);
        view.setFitsSystemWindows(false);
        view.setOnApplyWindowInsetsListener(new a(hVar, z));
        view.addOnAttachStateChangeListener(hVar);
        if (view.isAttachedToWindow()) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(hVar);
            view.getViewTreeObserver().addOnGlobalLayoutListener(hVar);
            view.requestApplyInsets();
        }
    }

    public static int a(int[] iArr, int i, int i2, boolean z, boolean z2) {
        int i3;
        double dSqrt;
        if (iArr == null || (i3 = iArr[2]) <= 0) {
            return 0;
        }
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = z2 ? i2 - i5 : i5 - i2;
        if (i6 <= 0) {
            return 0;
        }
        if (i6 >= i3) {
            dSqrt = 0.0d;
        } else {
            double d = i3;
            double d2 = i6;
            dSqrt = Math.sqrt((d * d) - (d2 * d2));
        }
        double d3 = i4;
        int iCeil = (int) Math.ceil(z ? d3 - dSqrt : d3 + dSqrt);
        return Math.max(0, z ? iCeil - i : i - iCeil);
    }
}
