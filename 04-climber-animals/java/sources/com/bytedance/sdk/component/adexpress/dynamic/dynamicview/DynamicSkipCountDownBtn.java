package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicSkipCountDownBtn extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int[] f828ms;
    private int t;
    private int xr;

    public DynamicSkipCountDownBtn(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        ((TextView) this.ub).setText("");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ka() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ab, this.x);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.ub).getText())) {
            setMeasuredDimension(0, this.x);
        } else {
            setMeasuredDimension(this.ab, this.x);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ah
    public void ms(CharSequence charSequence, boolean z, int i, boolean z2) {
        String strMs = t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_screen_skip_tx");
        if (i == 0) {
            this.ub.setVisibility(0);
            ((TextView) this.ub).setText("| ".concat(String.valueOf(strMs)));
            this.ub.measure(-2, -2);
            this.f828ms = new int[]{this.ub.getMeasuredWidth() + 1, this.ub.getMeasuredHeight()};
            View view = this.ub;
            int[] iArr = this.f828ms;
            view.setLayoutParams(new FrameLayout.LayoutParams(iArr[0], iArr[1]));
            ((TextView) this.ub).setGravity(17);
            ((TextView) this.ub).setIncludeFontPadding(false);
            ny();
            this.ub.setPadding(this.sl.ah(), this.xr, this.sl.d(), this.t);
        }
        requestLayout();
    }

    private void ny() {
        int iMs = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ka());
        this.xr = ((this.x - iMs) / 2) - this.sl.ms();
        this.t = 0;
    }
}
