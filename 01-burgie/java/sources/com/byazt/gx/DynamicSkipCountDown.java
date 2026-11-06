package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1889})
public class DynamicSkipCountDown extends DynamicButton implements com.byazt.imd.hn {
    public DynamicSkipCountDown(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        dynamicRootView.setTimeOutListener(this);
    }

    @Override // com.byazt.gx.DynamicButton, com.byazt.gx.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.ho).getText())) {
            setMeasuredDimension(0, this.zo);
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fw, this.zo);
        layoutParams.leftMargin = this.aj;
        layoutParams.gravity = 16;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.imd.hn
    public void pr(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (i == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).removeView(this);
            }
        } else {
            ((TextView) this.ho).setText(" | " + String.format("%1$ss后可跳过", Integer.valueOf(i)));
        }
        requestLayout();
    }
}
