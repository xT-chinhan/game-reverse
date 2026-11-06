package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.rk.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 2251})
public class DynamicTimeOuterSkip extends DynamicButton implements com.byazt.imd.hn {
    public boolean pr;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.pr = dynamicRootView.getRenderRequest().ho();
        }
    }

    @Override // com.byazt.gx.DynamicButton, com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        if (TextUtils.equals(this.m.vk().getType(), "skip-with-time-skip-btn")) {
            ((TextView) this.ho).setText("");
            return true;
        }
        return true;
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
        if (TextUtils.equals("skip-with-time-skip-btn", this.m.vk().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fw, this.zo);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            if (Build.VERSION.SDK_INT >= 17) {
                this.ho.setTextAlignment(1);
            }
            ((TextView) this.ho).setGravity(17);
        } else {
            super.c();
        }
        if (!"skip-with-time-skip-btn".equals(this.m.vk().getType()) && Build.VERSION.SDK_INT >= 17) {
            this.ho.setTextAlignment(1);
            ((TextView) this.ho).setGravity(17);
        }
        setVisibility(8);
    }

    private String pr(boolean z) {
        String str = "跳过";
        if (!"skip-with-time-skip-btn".equals(this.m.vk().getType())) {
            return "跳过";
        }
        if (com.byazt.dj.x.pr() && this.pr) {
            str = "X";
        }
        return z ? str : "| ".concat(String.valueOf(str));
    }

    @Override // com.byazt.imd.hn
    public void pr(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.ho).setText(pr(z2));
        } else {
            if (z2) {
                ((TextView) this.ho).setText(pr(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
