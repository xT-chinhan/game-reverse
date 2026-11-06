package com.byazt.pi;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, 2307})
public class TTLoadingProgressBar extends LinearLayout {
    public View hn;
    public ImageView hw;
    public View pr;

    public View getProgressBar() {
        return this.pr;
    }

    public ImageView getProgressIcon() {
        return this.hw;
    }

    public void setProgress(int i) {
        if (this.hw.getVisibility() == 0 && i > 3) {
            ((LinearLayout.LayoutParams) this.hw.getLayoutParams()).leftMargin = pr(this.pr.getContext(), -7.0f);
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.pr.getLayoutParams();
        float f = i / 100.0f;
        layoutParams.weight = f;
        this.pr.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hn.getLayoutParams();
        layoutParams2.weight = 1.0f - f;
        this.hn.setLayoutParams(layoutParams2);
        requestLayout();
    }

    private int pr(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
