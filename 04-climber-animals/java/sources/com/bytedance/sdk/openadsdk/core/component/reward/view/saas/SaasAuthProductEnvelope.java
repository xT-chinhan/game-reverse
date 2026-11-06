package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.az;
import com.bytedance.sdk.openadsdk.core.x.ah;
import com.bytedance.sdk.openadsdk.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.x.xr;

/* JADX INFO: loaded from: classes2.dex */
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void ms() {
    }

    public SaasAuthProductEnvelope(Context context, az.ms msVar) {
        super(context);
        ms(context, msVar);
    }

    private void ms(Context context, az.ms msVar) {
        if (msVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutMs = ms(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            xr.ms(ah.ms("saas_reward_goods_bg.webp")).ms(imageView);
        } catch (Error unused) {
        }
        relativeLayoutMs.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387808);
        layoutParams.topMargin = ul.ah(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("超值好物");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        relativeLayoutMs.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = ul.ah(context, 20.0f);
        textView2.setId(2114387468);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(ul.ah(context, 200.0f));
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(msVar.ms());
        textView2.setTextColor(Color.parseColor("#161823"));
        relativeLayoutMs.addView(textView2);
        int iAh = ul.ah(context, 80.0f);
        int iAh2 = ul.ah(context, 10.0f);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context, iAh2, iAh2);
        tTRoundRectImageView.setId(2114387462);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iAh, iAh);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.topMargin = ul.ah(context, 12.0f);
        xr.ms(msVar.xr()).ms(iAh).xr(iAh).ms(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(layoutParams3);
        relativeLayoutMs.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387463);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, tTRoundRectImageView.getId());
        layoutParams4.topMargin = ul.ah(context, 12.0f);
        linearLayout.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("¥");
        linearLayout.addView(textView3);
        double d = msVar.d();
        int iFloor = (int) Math.floor(d);
        int i = (int) ((d - ((double) iFloor)) * 100.0d);
        TextView textView4 = new TextView(context);
        textView4.setTextSize(2, 16.0f);
        textView4.setTypeface(null, 1);
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setText(String.valueOf(iFloor));
        linearLayout.addView(textView4);
        TextView textView5 = new TextView(context);
        textView5.setTextSize(2, 11.0f);
        textView5.setTypeface(null, 1);
        textView5.setTextColor(Color.parseColor("#F93F3F"));
        textView5.setText(j.z + i + (i >= 10 ? "" : "0"));
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("￥" + msVar.ah());
        linearLayout.addView(textView6);
        relativeLayoutMs.addView(linearLayout);
        ms(context, "一键关联抖音购买", relativeLayoutMs);
        addView(relativeLayoutMs);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope
    public void xr() {
        super.xr();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        xr();
    }
}
