package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.animation.view.AnimationButton;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.ub = new AnimationButton(context);
        this.ub.setTag(Integer.valueOf(getClickArea()));
        addView(this.ub, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp
    protected FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.bytedance.sdk.component.adexpress.d.ms() && "fillButton".equals(this.zb.ch().getType())) {
            ((TextView) this.ub).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.ub).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.sl.qv() * 2;
            widgetLayoutParams.height -= this.sl.qv() * 2;
            widgetLayoutParams.topMargin += this.sl.qv();
            widgetLayoutParams.leftMargin += this.sl.qv();
            widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
            widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        if (TextUtils.equals("download-progress-button", this.zb.ch().getType()) && TextUtils.isEmpty(this.sl.ch())) {
            this.ub.setVisibility(4);
            return true;
        }
        this.ub.setTextAlignment(this.sl.x());
        ((TextView) this.ub).setText(this.sl.ch());
        ((TextView) this.ub).setTextColor(this.sl.ab());
        ((TextView) this.ub).setTextSize(this.sl.ka());
        ((TextView) this.ub).setGravity(17);
        ((TextView) this.ub).setIncludeFontPadding(false);
        if ("fillButton".equals(this.zb.ch().getType())) {
            this.ub.setPadding(0, 0, 0, 0);
        } else {
            this.ub.setPadding(this.sl.ah(), this.sl.xr(), this.sl.d(), this.sl.ms());
        }
        return true;
    }
}
