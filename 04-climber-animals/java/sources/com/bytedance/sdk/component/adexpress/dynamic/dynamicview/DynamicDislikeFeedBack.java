package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicDislikeFeedBack extends DynamicBaseWidgetImp {
    public DynamicDislikeFeedBack(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            this.ub = new ImageView(context);
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ab = this.x;
        } else {
            this.ub = new TextView(context);
        }
        this.ub.setTag(3);
        addView(this.ub, getWidgetLayoutParams());
        dynamicRootView.setDislikeView(this.ub);
        if (dynamicRootView.getRenderRequest() != null) {
            if (dynamicRootView.getRenderRequest().hi() && dynamicRootView.getRenderRequest().le()) {
                return;
            }
            this.ub.setVisibility(8);
            setVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            Drawable drawableMs = com.bytedance.sdk.component.adexpress.d.d.ms(getContext(), this.sl);
            if (drawableMs != null) {
                ((ImageView) this.ub).setBackground(drawableMs);
            }
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            int iKa = t.ka(getContext(), "tt_reward_full_feedback");
            if (iKa > 0) {
                ((ImageView) this.ub).setImageResource(iKa);
            }
            return true;
        }
        ((TextView) this.ub).setText(getText());
        this.ub.setTextAlignment(this.sl.x());
        ((TextView) this.ub).setTextColor(this.sl.ab());
        ((TextView) this.ub).setTextSize(this.sl.ka());
        this.ub.setBackground(getBackgroundDrawable());
        if (!this.sl.b()) {
            ((TextView) this.ub).setMaxLines(1);
            ((TextView) this.ub).setGravity(17);
            ((TextView) this.ub).setEllipsize(TextUtils.TruncateAt.END);
        } else {
            int iRe = this.sl.re();
            if (iRe > 0) {
                ((TextView) this.ub).setLines(iRe);
                ((TextView) this.ub).setEllipsize(TextUtils.TruncateAt.END);
            }
        }
        this.ub.setPadding((int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ah()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.xr()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.d()), (int) com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), this.sl.ms()));
        ((TextView) this.ub).setGravity(17);
        return true;
    }

    public String getText() {
        return t.ms(com.bytedance.sdk.component.adexpress.d.getContext(), "tt_reward_feedback");
    }
}
