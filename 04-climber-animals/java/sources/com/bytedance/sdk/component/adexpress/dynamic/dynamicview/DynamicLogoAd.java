package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.d.hi;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicLogoAd extends DynamicBaseWidgetImp {
    public DynamicLogoAd(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.ub = new TextView(context);
        this.ub.setTag(Integer.valueOf(getClickArea()));
        addView(this.ub, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        this.ub.setTextAlignment(this.sl.x());
        ((TextView) this.ub).setTextColor(this.sl.ab());
        ((TextView) this.ub).setTextSize(this.sl.ka());
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            ((TextView) this.ub).setIncludeFontPadding(false);
            ((TextView) this.ub).setTextSize(Math.min(((com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), this.x) - this.sl.xr()) - this.sl.ms()) - 0.5f, this.sl.ka()));
            ((TextView) this.ub).setText(t.ms(getContext(), "tt_logo_en"));
            return true;
        }
        if (ny()) {
            if (hi.xr()) {
                ((TextView) this.ub).setText(hi.ms());
                return true;
            }
            ((TextView) this.ub).setText(hi.ms(this.sl.xr));
            return true;
        }
        ((TextView) this.ub).setText(t.xr(getContext(), "tt_logo_cn"));
        return true;
    }

    private boolean ny() {
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            return false;
        }
        return (!TextUtils.isEmpty(this.sl.xr) && this.sl.xr.contains("adx:")) || hi.xr();
    }
}
