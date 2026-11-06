package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.az;
import com.bytedance.sdk.openadsdk.core.x.ah;
import com.bytedance.sdk.openadsdk.x.xr;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private TextView f2278ms;

    public SaasAuthCouponEnvelope(Context context, az.xr xrVar) {
        super(context);
        ms(context, xrVar);
    }

    private void ms(Context context, az.xr xrVar) {
        if (xrVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutMs = ms(context);
        ImageView imageView = new ImageView(context);
        try {
            xr.ms(ah.ms("saas_reward_coupon_bg.webp")).ms(imageView);
        } catch (Error unused) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayoutMs.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387808);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = ul.ah(context, 20.0f);
        textView.setText("优惠券");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        relativeLayoutMs.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387467);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        this.f2278ms = textView2;
        textView2.setId(2114387466);
        this.f2278ms.setText(String.valueOf(xrVar.ms()));
        this.f2278ms.setTextColor(Color.parseColor("#F93F3F"));
        this.f2278ms.setTextSize(2, 60.0f);
        linearLayout.addView(this.f2278ms, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("元");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        relativeLayoutMs.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387465);
        textView4.setText("满" + xrVar.xr() + "元可用");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = ul.ah(context, -4.0f);
        relativeLayoutMs.addView(textView4, layoutParams3);
        TextView textView5 = new TextView(context);
        textView5.setText("领取后30分钟内有效");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, textView4.getId());
        layoutParams4.topMargin = ul.ah(context, 8.0f);
        relativeLayoutMs.addView(textView5, layoutParams4);
        ms(context, "一键关联抖音领取", relativeLayoutMs);
        addView(relativeLayoutMs);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void ms() {
        setVisibility(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void xr() {
        setVisibility(8);
        super.xr();
    }
}
