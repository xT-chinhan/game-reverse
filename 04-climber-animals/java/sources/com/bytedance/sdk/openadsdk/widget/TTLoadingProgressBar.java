package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public class TTLoadingProgressBar extends LinearLayout {
    private View ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f4296ms;
    private ImageView xr;

    public View getProgressBar() {
        return this.f4296ms;
    }

    public ImageView getProgressIcon() {
        return this.xr;
    }

    public void setProgress(int i) {
        if (this.xr.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.xr.getLayoutParams()).leftMargin = ms(this.f4296ms.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f4296ms.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.f4296ms.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ah.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.ah.setLayoutParams(layoutParams2);
        requestLayout();
    }

    private int ms(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
