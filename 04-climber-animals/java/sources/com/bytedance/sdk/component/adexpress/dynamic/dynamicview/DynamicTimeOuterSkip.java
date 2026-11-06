package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuterSkip extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f835ms;

    public DynamicTimeOuterSkip(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null) {
            this.f835ms = dynamicRootView.getRenderRequest().ao();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        if (!TextUtils.equals(this.zb.ch().getType(), "skip-with-time-skip-btn")) {
            return true;
        }
        ((TextView) this.ub).setText("");
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.ub).getText())) {
            setMeasuredDimension(0, this.x);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ka() {
        if (TextUtils.equals("skip-with-time-skip-btn", this.zb.ch().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ab, this.x);
            layoutParams.gravity = 8388629;
            setLayoutParams(layoutParams);
            this.ub.setTextAlignment(1);
            ((TextView) this.ub).setGravity(17);
        } else {
            super.ka();
        }
        if (!"skip-with-time-skip-btn".equals(this.zb.ch().getType())) {
            this.ub.setTextAlignment(1);
            ((TextView) this.ub).setGravity(17);
        }
        setVisibility(8);
    }

    private String ms(boolean z) {
        String strMs = t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_screen_skip_tx");
        if (!"skip-with-time-skip-btn".equals(this.zb.ch().getType())) {
            return strMs;
        }
        if (com.bytedance.sdk.component.adexpress.d.ms() && this.f835ms) {
            strMs = "X";
        }
        return z ? strMs : "| ".concat(String.valueOf(strMs));
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ah
    public void ms(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (z) {
            ((TextView) this.ub).setText(ms(z2));
        } else {
            if (z2) {
                ((TextView) this.ub).setText(ms(z2));
            }
            if (!z2) {
                i2 = 8;
            }
        }
        setVisibility(i2);
    }
}
