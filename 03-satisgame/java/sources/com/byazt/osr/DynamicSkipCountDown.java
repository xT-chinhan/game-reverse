package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2057})
public class DynamicSkipCountDown extends DynamicButton implements com.byazt.tq.s {
    public DynamicSkipCountDown(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.byazt.osr.DynamicButton, com.byazt.osr.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.k).getText())) {
            setMeasuredDimension(0, this.fs);
        }
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public void l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.fs);
        layoutParams.leftMargin = this.rv;
        layoutParams.gravity = 16;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.tq.s
    public void n(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else {
            ((TextView) this.k).setText(" | " + String.format("%1$ss后可跳过", Integer.valueOf(i)));
        }
        requestLayout();
    }
}
