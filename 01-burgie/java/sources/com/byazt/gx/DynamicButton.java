package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.rk.zo;
import com.byazt.vry.AnimationButton;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1948})
public class DynamicButton extends DynamicBaseWidgetImp {
    public DynamicButton(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.ho = new AnimationButton(context);
        this.ho.setTag(Integer.valueOf(getClickArea()));
        addView(this.ho, getWidgetLayoutParams());
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        if (com.byazt.dj.x.pr() && "fillButton".equals(this.m.vk().getType())) {
            ((TextView) this.ho).setEllipsize(TextUtils.TruncateAt.END);
            ((TextView) this.ho).setMaxLines(1);
            FrameLayout.LayoutParams widgetLayoutParams = super.getWidgetLayoutParams();
            widgetLayoutParams.width -= this.k.lb() * 2;
            widgetLayoutParams.height -= this.k.lb() * 2;
            widgetLayoutParams.topMargin += this.k.lb();
            widgetLayoutParams.leftMargin += this.k.lb();
            if (Build.VERSION.SDK_INT >= 17) {
                widgetLayoutParams.setMarginStart(widgetLayoutParams.leftMargin);
                widgetLayoutParams.setMarginEnd(widgetLayoutParams.rightMargin);
            }
            return widgetLayoutParams;
        }
        return super.getWidgetLayoutParams();
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        if (TextUtils.equals("download-progress-button", this.m.vk().getType()) && TextUtils.isEmpty(this.k.vk())) {
            this.ho.setVisibility(4);
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            this.ho.setTextAlignment(this.k.zo());
        }
        ((TextView) this.ho).setText(this.k.vk());
        ((TextView) this.ho).setTextColor(this.k.fw());
        ((TextView) this.ho).setTextSize(this.k.c());
        ((TextView) this.ho).setGravity(17);
        ((TextView) this.ho).setIncludeFontPadding(false);
        if ("fillButton".equals(this.m.vk().getType())) {
            this.ho.setPadding(0, 0, 0, 0);
        } else {
            this.ho.setPadding(this.k.hn(), this.k.hw(), this.k.x(), this.k.pr());
        }
        return true;
    }
}
