package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLogoUnion extends DynamicBaseWidgetImp {
    public DynamicLogoUnion(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.ub = new ImageView(context);
        this.ub.setTag(Integer.valueOf(getClickArea()));
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            this.x = Math.max(dynamicRootView.getLogoUnionHeight(), this.x);
        }
        addView(this.ub, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        }
        ((ImageView) this.ub).setImageResource(t.ka(getContext(), "tt_ad_logo"));
        ((ImageView) this.ub).setColorFilter(this.sl.ab(), PorterDuff.Mode.SRC_IN);
        return true;
    }
}
