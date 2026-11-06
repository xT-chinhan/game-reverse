package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.widget.DislikeView;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDislike extends DynamicBaseWidgetImp {
    public DynamicDislike(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            this.ub = new ImageView(context);
        } else {
            this.ub = new DislikeView(context);
        }
        this.ub.setTag(3);
        addView(this.ub, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ub);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            Drawable drawableMs = com.bytedance.sdk.component.adexpress.d.d.ms(getContext(), this.sl);
            if (drawableMs != null) {
                this.ub.setBackground(drawableMs);
            }
            int iKa = t.ka(getContext(), "tt_close_btn");
            if (iKa > 0) {
                ((ImageView) this.ub).setImageResource(iKa);
            }
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.FIT_XY);
            return true;
        }
        int iMs = (int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.h());
        if (this.ub instanceof DislikeView) {
            ((DislikeView) this.ub).setRadius((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, this.sl.ub()));
            ((DislikeView) this.ub).setStrokeWidth(iMs);
            ((DislikeView) this.ub).setStrokeColor(this.sl.ao());
            ((DislikeView) this.ub).setBgColor(this.sl.le());
            ((DislikeView) this.ub).setDislikeColor(this.sl.ab());
            ((DislikeView) this.ub).setDislikeWidth((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.hi, 1.0f));
        }
        return true;
    }
}
