package com.mcto.sspsdk.internal;

import android.view.View;
import android.view.WindowInsets;
import com.mcto.sspsdk.ssp.activity.QyDetailPageActivityNew;

/* JADX INFO: loaded from: classes2.dex */
public final class md implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ QyDetailPageActivityNew a;

    public md(QyDetailPageActivityNew qyDetailPageActivityNew) {
        this.a = qyDetailPageActivityNew;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        int systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
        int systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
        int systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
        int systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
        if (this.a.getResources().getConfiguration().orientation == 2) {
            systemWindowInsetTop = 0;
        }
        view.setPadding(systemWindowInsetLeft, systemWindowInsetTop, systemWindowInsetRight, systemWindowInsetBottom);
        return windowInsets.consumeSystemWindowInsets();
    }
}
