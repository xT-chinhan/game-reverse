package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2564})
public class DynamicSkipCountDownBtn extends DynamicButton implements com.byazt.tq.s {
    public int a;
    public int[] n;
    public int qg;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.byazt.osr.DynamicButton, com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        ((TextView) this.k).setText("");
        return true;
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public void l() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.fs);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.k).getText())) {
            setMeasuredDimension(0, this.fs);
        } else {
            setMeasuredDimension(this.x, this.fs);
        }
    }

    @Override // com.byazt.tq.s
    public void n(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            this.k.setVisibility(0);
            ((TextView) this.k).setText("| 跳过");
            this.k.measure(-2, -2);
            this.n = new int[]{this.k.getMeasuredWidth() + 1, this.k.getMeasuredHeight()};
            View view = this.k;
            int[] iArr = this.n;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.k).setGravity(17);
            ((TextView) this.k).setIncludeFontPadding(false);
            rv();
            this.k.setPadding(this.d.s(), this.qg, this.d.q(), this.a);
        }
        requestLayout();
    }

    private void rv() {
        int iN = (int) com.byazt.cq.fs.n(this.cp, this.d.l());
        this.qg = ((this.fs - iN) / 2) - this.d.n();
        this.a = 0;
    }
}
