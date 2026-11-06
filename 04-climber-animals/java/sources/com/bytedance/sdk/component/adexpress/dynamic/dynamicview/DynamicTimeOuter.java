package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.d.ab;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.d.hi;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuter extends DynamicButton implements com.bytedance.sdk.component.adexpress.dynamic.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f832ms;
    private boolean t;
    private boolean xr;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(xVar.ch().getType())) {
            dynamicRootView.setTimedown(this.x);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicButton, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        if (ab.xr(this.u.getRenderRequest().c())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.zb.ch().getType())) {
            ((TextView) this.ub).setText(String.valueOf((int) Double.parseDouble(this.sl.ch())));
            return true;
        }
        ((TextView) this.ub).setText(((int) Double.parseDouble(this.sl.ch())) + "s");
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ka() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.zb.ch().getType()) || TextUtils.equals("skip-with-time-countdown", this.zb.ch().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ab, this.x);
            layoutParams.gravity = 8388627;
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                layoutParams.leftMargin = this.ny;
            }
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
            setLayoutParams(layoutParams);
            return;
        }
        super.ka();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.ub).getText())) {
            setMeasuredDimension(0, this.x);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ah
    public void ms(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 || this.t) {
            ((TextView) this.ub).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception unused) {
        }
        setVisibility(0);
        if (!z && this.u.getRenderRequest().ah() && ab.xr(this.u.getRenderRequest().c())) {
            if (com.bytedance.sdk.component.adexpress.d.ms()) {
                ((TextView) this.ub).setText(i + "s");
            } else {
                ((TextView) this.ub).setText(String.format(t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_full_skip"), Integer.valueOf(i)));
            }
            this.f832ms = true;
            return;
        }
        if (com.bytedance.sdk.component.adexpress.d.ms() && !"open_ad".equals(this.u.getRenderRequest().c()) && this.u.getRenderRequest().ah()) {
            this.t = true;
            setVisibility(8);
            return;
        }
        if ("timedown".equals(this.zb.ch().getType())) {
            ((TextView) this.ub).setText(charSequence);
            return;
        }
        ((TextView) this.ub).setText(((Object) charSequence) + "s");
        this.xr = true;
        if (this.f832ms) {
            CharSequence text = ((TextView) this.ub).getText();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (hi.xr(text != null ? text.toString() : "", this.sl.ka(), true)[0] + com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ah() + this.sl.d())), this.x);
            layoutParams.gravity = 8388629;
            this.ub.setLayoutParams(layoutParams);
            this.f832ms = false;
            requestLayout();
        }
    }
}
