package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.bytedance.sdk.component.adexpress.dynamic.ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    TextView f840ms;
    boolean t;
    FrameLayout xr;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public boolean d() {
        return true;
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.t = false;
        this.ub = new View(context);
        this.ub.setTag(Integer.valueOf(getClickArea()));
        this.f840ms = new TextView(context);
        this.xr = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 40.0f), (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 15.0f));
        layoutParams.gravity = 8388693;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.f840ms.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f840ms.setBackground(gradientDrawable);
        this.f840ms.setTextSize(10.0f);
        this.f840ms.setGravity(17);
        this.f840ms.setTextColor(-1);
        this.f840ms.setVisibility(8);
        if (com.bytedance.sdk.component.adexpress.d.ms()) {
            addView(this.xr, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.f840ms);
        addView(this.ub, getWidgetLayoutParams());
        if (!com.bytedance.sdk.component.adexpress.d.ms()) {
            addView(this.xr, getWidgetLayoutParams());
        }
        dynamicRootView.ah = this.xr;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        double dKa = 0.0d;
        double d = 0.0d;
        for (x xVarSl = this.zb; xVarSl != null; xVarSl = xVarSl.sl()) {
            double dC = d + ((double) xVarSl.c());
            double dAb = dKa + ((double) xVarSl.ab());
            d = dC - ((double) xVarSl.d());
            dKa = dAb - ((double) xVarSl.ka());
        }
        try {
            float f = (float) d;
            int iMs = (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), f);
            int iMs2 = (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), f + this.ka);
            if (com.bytedance.sdk.component.adexpress.d.ah.ms(getContext())) {
                DynamicRoot dynamicRoot = (DynamicRoot) this.u.getChildAt(0);
                int dynamicWidth = dynamicRoot.getDynamicWidth();
                int i = dynamicWidth - iMs2;
                iMs2 = dynamicWidth - iMs;
                iMs = i;
            }
            if (!"open_ad".equals(this.u.getRenderRequest().c())) {
                DynamicRoot dynamicRoot2 = (DynamicRoot) this.u.getChildAt(0);
                float f2 = (float) dKa;
                dynamicRoot2.f826ms.update(iMs, (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), f2), iMs2, (int) com.bytedance.sdk.component.adexpress.d.x.ms(getContext(), f2 + this.c));
            } else {
                this.u.ah = this.xr;
            }
        } catch (Exception unused) {
        }
        this.u.ms(d, dKa, this.ka, this.c, this.sl.ub());
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.ka
    public void setTimeUpdate(int i) {
        String str;
        if (this.zb.ch().ka().a() && i > 0 && !this.t) {
            String str2 = (i >= 60 ? "0" + (i / 60) : "00") + ":";
            int i2 = i % 60;
            if (i2 > 9) {
                str = str2 + i2;
            } else {
                str = str2 + "0" + i2;
            }
            this.f840ms.setText(str);
            this.f840ms.setVisibility(0);
            return;
        }
        this.t = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ah(getChildAt(i3));
        }
        this.f840ms.setVisibility(8);
    }

    private void ah(View view) {
        if (view == this.f840ms || view == this.y) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.bytedance.sdk.component.adexpress.dynamic.ms.c)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            ah(viewGroup.getChildAt(i));
            i++;
        }
    }
}
