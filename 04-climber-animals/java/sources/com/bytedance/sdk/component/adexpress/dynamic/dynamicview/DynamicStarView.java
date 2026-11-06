package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.widget.TTRatingBar2;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicStarView extends DynamicBaseWidgetImp {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f830ms;

    public DynamicStarView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.f830ms = 0;
        this.ub = new TTRatingBar2(context, null);
        this.ub.setTag(Integer.valueOf(getClickArea()));
        addView(this.ub, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        int iMs = (int) ((com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ka()) * 5.0f) + com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ah() + com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.d())));
        if (this.ab > iMs && 4 == this.sl.x()) {
            this.f830ms = (this.ab - iMs) / 2;
        }
        this.ab = iMs;
        return new FrameLayout.LayoutParams(this.ab, this.x);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public void ka() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.ab, this.x);
        layoutParams.topMargin = this.ch;
        layoutParams.leftMargin = this.ny + this.f830ms;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        setLayoutParams(layoutParams);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        double dZb = this.sl.zb();
        if (com.bytedance.sdk.component.adexpress.d.ms() && (dZb < 0.0d || dZb > 5.0d || (this.u != null && this.u.getRenderRequest() != null && this.u.getRenderRequest().zb() != 4))) {
            this.ub.setVisibility(8);
            return true;
        }
        double d = (dZb < 0.0d || dZb > 5.0d) ? 5.0d : dZb;
        this.ub.setVisibility(0);
        ((TTRatingBar2) this.ub).ms(d, this.sl.ab(), (int) this.sl.ka(), ((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.xr())) + ((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ms())) + ((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ka())));
        return true;
    }
}
