package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicTimeOuterRewardFullSkip extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f834ms;

    public DynamicTimeOuterRewardFullSkip(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (dynamicRootView.getRenderRequest() != null) {
            this.f834ms = dynamicRootView.getRenderRequest().ao();
        }
        this.ab = this.x;
        this.ub = new ImageView(context);
        this.ub.setTag(Integer.valueOf(getClickArea()));
        addView(this.ub, getWidgetLayoutParams());
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().le()) {
            return;
        }
        this.ub.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        Drawable drawableAh;
        super.x();
        ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_CROP);
        Drawable drawableMs = com.bytedance.sdk.component.adexpress.d.d.ms(getContext(), this.sl);
        if (drawableMs != null) {
            ((ImageView) this.ub).setBackground(drawableMs);
        }
        if (this.f834ms) {
            drawableAh = t.ah(getContext(), "tt_close_btn");
        } else {
            drawableAh = t.ah(getContext(), "tt_skip_btn");
            if (drawableAh != null) {
                drawableAh.setAutoMirrored(true);
            }
        }
        if (drawableAh != null) {
            ((ImageView) this.ub).setImageDrawable(drawableAh);
        }
        setVisibility(8);
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ah
    public void ms(CharSequence charSequence, boolean z, int i, boolean z2) {
        int i2 = 0;
        if (!z && !z2) {
            i2 = 8;
        }
        setVisibility(i2);
    }
}
