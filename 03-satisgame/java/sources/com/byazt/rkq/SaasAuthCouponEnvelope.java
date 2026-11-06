package com.byazt.rkq;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.cp.n;
import com.byazt.gct.dg;
import com.byazt.imu.s;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 2344})
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {
    public TextView n;

    public SaasAuthCouponEnvelope(Context context, dg.qg qgVar) {
        super(context);
        n(context, qgVar);
    }

    private void n(Context context, dg.qg qgVar) {
        if (qgVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutN = n(context);
        ImageView imageView = new ImageView(context);
        try {
            s.n(com.byazt.iu.n.n("saas_reward_coupon_bg.webp")).n(imageView);
        } catch (Error unused) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayoutN.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387802);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = com.byazt.okk.s.s(context, 20.0f);
        textView.setText("优惠券");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        relativeLayoutN.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387461);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        this.n = textView2;
        textView2.setId(2114387460);
        this.n.setText(String.valueOf(qgVar.n()));
        this.n.setTextColor(Color.parseColor("#F93F3F"));
        this.n.setTextSize(2, 60.0f);
        linearLayout.addView(this.n, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("元");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        relativeLayoutN.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387459);
        textView4.setText("满" + qgVar.qg() + "元可用");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = com.byazt.okk.s.s(context, -4.0f);
        relativeLayoutN.addView(textView4, layoutParams3);
        TextView textView5 = new TextView(context);
        textView5.setText("领取后30分钟内有效");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, textView4.getId());
        layoutParams4.topMargin = com.byazt.okk.s.s(context, 8.0f);
        relativeLayoutN.addView(textView5, layoutParams4);
        n(context, "一键关联抖音领取", relativeLayoutN);
        addView(relativeLayoutN);
    }

    @Override // com.byazt.rkq.BaseSaasEnvelope
    public void n() {
        setVisibility(0);
    }

    @Override // com.byazt.rkq.BaseSaasEnvelope
    public void qg() {
        setVisibility(8);
        super.qg();
    }
}
