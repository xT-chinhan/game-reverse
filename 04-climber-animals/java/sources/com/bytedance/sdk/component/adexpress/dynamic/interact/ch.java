package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.DynamicLottieView;
import com.bytedance.sdk.component.utils.cv;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class ch implements ab<ViewGroup> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final DynamicLottieView f850ms;
    private final FrameLayout xr;

    public ch(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, String str, String str2) {
        int iXn;
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.f850ms = dynamicLottieView;
        dynamicLottieView.setAnimationsLoop(true);
        dynamicLottieView.setOnlyLoadNetImage(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.xr = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double dZf = abVar.zf();
        dZf = dZf == 0.0d ? 1.0d : dZf;
        double dRt = abVar.rt();
        double d = dRt != 0.0d ? dRt : 1.0d;
        if ("24".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/swiper_up_star.json" : str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if ("20".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/brush_mask.json" : str);
            ms(context, frameLayout, abVar);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            if (abVar.xn() > 0) {
                iXn = abVar.xn();
            } else {
                iXn = com.bytedance.sdk.component.adexpress.d.ms() ? 0 : 120;
            }
            layoutParams2.bottomMargin = (int) com.bytedance.sdk.component.adexpress.d.x.ms(context, iXn);
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.setClipChildren(false);
            return;
        }
        dynamicLottieView.setImageLottieTosPath(str);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dZf), (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d));
        layoutParams3.gravity = 17;
        frameLayout.setLayoutParams(layoutParams3);
    }

    private void ms(Context context, FrameLayout frameLayout, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -cv.ms(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(context.getString(t.xr(context, "tt_splash_brush_mask_title")));
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, cv.ms(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText(context.getString(t.xr(context, "tt_splash_brush_mask_hint")));
        if (abVar != null && !TextUtils.isEmpty(abVar.am())) {
            textView2.setText(abVar.am());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        DynamicLottieView dynamicLottieView = this.f850ms;
        if (dynamicLottieView != null) {
            dynamicLottieView.ny();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        try {
            this.f850ms.ab();
            ViewParent parent = this.xr.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.xr);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public ViewGroup ah() {
        return this.xr;
    }
}
