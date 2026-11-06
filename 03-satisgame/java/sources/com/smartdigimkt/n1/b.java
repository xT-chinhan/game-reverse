package com.smartdigimkt.n1;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ boolean a = true;
    public final /* synthetic */ Rect b;

    public b(Rect rect) {
        this.b = rect;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            return windowInsets;
        }
        boolean z = this.a;
        int i = Build.VERSION.SDK_INT;
        Rect rectB = i >= 30 ? f.b(windowInsets, z) : d.c(windowInsets);
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        View rootView = view.getRootView();
        int iMin = Math.min(view.getWidth(), Math.max(0, rectB.left - iArr[0]));
        int iMin2 = Math.min(view.getHeight(), Math.max(0, rectB.top - iArr[1]));
        int iMin3 = Math.min(view.getWidth(), Math.max(0, ((view.getWidth() + iArr[0]) - rootView.getWidth()) + rectB.right));
        int iMin4 = Math.min(view.getHeight(), Math.max(0, ((view.getHeight() + iArr[1]) - rootView.getHeight()) + rectB.bottom));
        Rect rect = this.b;
        view.setPadding(rect.left + iMin, rect.top + iMin2, rect.right + iMin3, rect.bottom + iMin4);
        return i >= 30 ? f.a(windowInsets, this.a) : d.a(windowInsets);
    }
}
