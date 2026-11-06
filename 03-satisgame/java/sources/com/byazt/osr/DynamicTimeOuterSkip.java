package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.lh.fs;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 2438})
public class DynamicTimeOuterSkip extends DynamicButton implements com.byazt.tq.s {
    public boolean n;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.n = dynamicRootView.getRenderRequest().k();
        }
    }

    @Override // com.byazt.osr.DynamicButton, com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        if (!TextUtils.equals(this.oa.tj().getType(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.k).setText("");
        return true;
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
        if (TextUtils.equals("skip-with-time-skip-btn", this.oa.tj().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.x, this.fs);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.k.setTextAlignment(1);
            ((TextView) this.k).setGravity(17);
        } else {
            super.l();
        }
        if (!"skip-with-time-skip-btn".equals(this.oa.tj().getType())) {
            this.k.setTextAlignment(1);
            ((TextView) this.k).setGravity(17);
        }
        setVisibility(8);
    }

    private String n(boolean z) {
        String str = "跳过";
        if (!"skip-with-time-skip-btn".equals(this.oa.tj().getType())) {
            return "跳过";
        }
        if (com.byazt.twc.q.n() && this.n) {
            str = "X";
        }
        return z ? str : "| ".concat(str);
    }

    @Override // com.byazt.tq.s
    public void n(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.k).setText(n(z2));
        } else {
            if (z2) {
                ((TextView) this.k).setText(n(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
