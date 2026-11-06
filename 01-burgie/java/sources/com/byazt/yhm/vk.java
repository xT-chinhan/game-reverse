package com.byazt.yhm;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.ca.ve;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.DynamicLottieView;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 50})
public class vk implements fw<ViewGroup> {
    public final FrameLayout hw;
    public final DynamicLottieView pr;

    public vk(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar, String str, String str2) {
        int iR;
        DynamicLottieView dynamicLottieView = new DynamicLottieView(context);
        this.pr = dynamicLottieView;
        dynamicLottieView.setAnimationsLoop(true);
        dynamicLottieView.setOnlyLoadNetImage(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.hw = frameLayout;
        frameLayout.addView(dynamicLottieView, new FrameLayout.LayoutParams(-2, -2));
        double dMw = fwVar.mw();
        dMw = dMw == 0.0d ? 1.0d : dMw;
        double dSv = fwVar.sv();
        double d = dSv != 0.0d ? dSv : 1.0d;
        if ("24".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/swiper_up_star.json" : str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) com.byazt.js.zo.pr(context, 250.0f));
            layoutParams.gravity = 81;
            layoutParams.bottomMargin = (int) com.byazt.js.zo.pr(context, 120.0f);
            frameLayout.setLayoutParams(layoutParams);
            return;
        }
        if ("20".equals(str2)) {
            dynamicLottieView.setImageLottieTosPath(TextUtils.isEmpty(str) ? "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/brush_mask.json" : str);
            pr(context, frameLayout, fwVar);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.gravity = 81;
            if (fwVar.r() > 0) {
                iR = fwVar.r();
            } else {
                iR = com.byazt.dj.x.pr() ? 0 : 120;
            }
            layoutParams2.bottomMargin = (int) com.byazt.js.zo.pr(context, iR);
            frameLayout.setLayoutParams(layoutParams2);
            frameLayout.setClipChildren(false);
            return;
        }
        dynamicLottieView.setImageLottieTosPath(str);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * dMw), (int) (((double) dynamicBaseWidget.getDynamicWidth()) * 0.32d * d));
        layoutParams3.gravity = 17;
        frameLayout.setLayoutParams(layoutParams3);
    }

    private void pr(Context context, FrameLayout frameLayout, com.byazt.rk.fw fwVar) {
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.setMargins(0, -ve.pr(context, 5.0f), 0, 0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText("滑动或者点击擦亮");
        textView.setTextColor(-1);
        textView.setTextSize(2, 20.0f);
        TextView textView2 = new TextView(context);
        textView2.setId(2097610738);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(0, ve.pr(context, 5.0f), 0, 0);
        textView2.setLayoutParams(layoutParams2);
        textView2.setText("跳转详情页或第三方应用");
        if (fwVar != null && !TextUtils.isEmpty(fwVar.o())) {
            textView2.setText(fwVar.o());
        }
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 14.0f);
        linearLayout.addView(textView);
        linearLayout.addView(textView2);
        frameLayout.addView(linearLayout);
    }

    @Override // com.byazt.yhm.fw
    public void pr() {
        DynamicLottieView dynamicLottieView = this.pr;
        if (dynamicLottieView != null) {
            dynamicLottieView.zo();
        }
    }

    @Override // com.byazt.yhm.fw
    public void hw() {
        try {
            this.pr.fw();
            ViewParent parent = this.hw.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.hw);
            }
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.yhm.fw
    public ViewGroup hn() {
        return this.hw;
    }
}
