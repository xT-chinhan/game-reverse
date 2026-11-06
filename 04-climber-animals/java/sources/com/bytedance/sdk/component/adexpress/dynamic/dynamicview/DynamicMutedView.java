package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.d.ny;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicMutedView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.xr {
    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean d() {
        return true;
    }

    public DynamicMutedView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.ub = new ImageView(context);
        this.ub.setTag(5);
        addView(this.ub, getWidgetLayoutParams());
        dynamicRootView.setMuteListener(this);
        if (dynamicRootView.getRenderRequest() == null || dynamicRootView.getRenderRequest().le()) {
            return;
        }
        this.ub.setVisibility(8);
        setVisibility(8);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            ((ImageView) this.ub).setScaleType(ImageView.ScaleType.CENTER);
        }
        setSoundMute(this.u.xr);
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            Drawable drawableMs = com.bytedance.sdk.component.adexpress.d.d.ms(getContext(), this.sl);
            if (drawableMs != null) {
                ((ImageView) this.ub).setBackground(drawableMs);
            }
        } else {
            ((ImageView) this.ub).setBackgroundDrawable(ny.ms(0, Integer.valueOf(this.sl.le()), new int[]{this.x / 2}, null, null, null));
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.xr
    public void setSoundMute(boolean z) {
        int iKa;
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            if (z) {
                iKa = t.ka(getContext(), "tt_reward_full_mute");
            } else {
                iKa = t.ka(getContext(), "tt_reward_full_unmute");
            }
        } else if (z) {
            iKa = t.ka(getContext(), "tt_mute");
        } else {
            iKa = t.ka(getContext(), "tt_unmute");
        }
        ((ImageView) this.ub).setImageResource(iKa);
        if (((ImageView) this.ub).getDrawable() != null) {
            ((ImageView) this.ub).getDrawable().setAutoMirrored(true);
        }
    }
}
