package com.mcto.sspsdk.internal;

import android.view.View;
import android.view.WindowInsets;
import com.mcto.sspsdk.ssp.activity.QyRewardActivity;

/* JADX INFO: loaded from: classes2.dex */
public final class ce implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ QyRewardActivity a;

    public ce(QyRewardActivity qyRewardActivity) {
        this.a = qyRewardActivity;
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
