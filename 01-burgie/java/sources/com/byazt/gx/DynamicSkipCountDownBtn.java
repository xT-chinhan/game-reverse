package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 2376})
public class DynamicSkipCountDownBtn extends DynamicButton implements com.byazt.imd.hn {
    public int a;
    public int hw;
    public int[] pr;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.byazt.gx.DynamicButton, com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        ((TextView) this.ho).setText("");
        return true;
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fw, this.zo);
        layoutParams.gravity = 8388629;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.ho).getText())) {
            setMeasuredDimension(0, this.zo);
        } else {
            setMeasuredDimension(this.fw, this.zo);
        }
    }

    @Override // com.byazt.imd.hn
    public void pr(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            this.ho.setVisibility(0);
            ((TextView) this.ho).setText("| 跳过");
            this.ho.measure(-2, -2);
            this.pr = new int[]{this.ho.getMeasuredWidth() + 1, this.ho.getMeasuredHeight()};
            View view = this.ho;
            int[] iArr = this.pr;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.ho).setGravity(17);
            ((TextView) this.ho).setIncludeFontPadding(false);
            aj();
            this.ho.setPadding(this.k.hn(), this.hw, this.k.x(), this.a);
        }
        requestLayout();
    }

    private void aj() {
        int iPr = (int) com.byazt.js.zo.pr(this.w, this.k.c());
        this.hw = ((this.zo - iPr) / 2) - this.k.pr();
        this.a = 0;
    }
}
