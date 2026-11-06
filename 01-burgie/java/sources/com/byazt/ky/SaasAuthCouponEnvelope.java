package com.byazt.ky;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.hb.hn;
import com.byazt.hg.qi;
import com.byazt.ub.hw;
import com.byazt.vzx.pr;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 2106})
public class SaasAuthCouponEnvelope extends BaseSaasEnvelope {
    public TextView pr;

    public SaasAuthCouponEnvelope(Context context, qi.hw hwVar) {
        super(context);
        pr(context, hwVar);
    }

    private void pr(Context context, qi.hw hwVar) {
        if (hwVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutPr = pr(context);
        ImageView imageView = new ImageView(context);
        try {
            hw.pr(hn.pr("saas_reward_coupon_bg.webp")).pr(imageView);
        } catch (Error e) {
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayoutPr.addView(imageView, new RelativeLayout.LayoutParams(-1, -1));
        TextView textView = new TextView(context);
        textView.setId(2114387802);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setLayoutParams(layoutParams);
        layoutParams.topMargin = er.hn(context, 20.0f);
        textView.setText("优惠券");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTextSize(2, 16.0f);
        relativeLayoutPr.addView(textView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387461);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        linearLayout.setLayoutParams(layoutParams2);
        TextView textView2 = new TextView(context);
        this.pr = textView2;
        textView2.setId(2114387460);
        this.pr.setText(String.valueOf(hwVar.pr()));
        this.pr.setTextColor(Color.parseColor("#F93F3F"));
        this.pr.setTextSize(2, 60.0f);
        linearLayout.addView(this.pr, new RelativeLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(context);
        textView3.setText("元");
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setTextSize(2, 20.0f);
        linearLayout.addView(textView3, new RelativeLayout.LayoutParams(-2, -2));
        relativeLayoutPr.addView(linearLayout);
        TextView textView4 = new TextView(context);
        textView4.setId(2114387459);
        textView4.setText("满" + hwVar.hw() + "元可用");
        textView4.setTextColor(Color.parseColor("#F93F3F"));
        textView4.setTextSize(2, 16.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, linearLayout.getId());
        layoutParams3.topMargin = er.hn(context, -4.0f);
        relativeLayoutPr.addView(textView4, layoutParams3);
        TextView textView5 = new TextView(context);
        textView5.setText("领取后30分钟内有效");
        textView5.setTextColor(Color.parseColor("#894200"));
        textView5.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, textView4.getId());
        layoutParams4.topMargin = er.hn(context, 8.0f);
        relativeLayoutPr.addView(textView5, layoutParams4);
        pr(context, "一键关联抖音领取", relativeLayoutPr);
        addView(relativeLayoutPr);
    }

    @Override // com.byazt.ky.BaseSaasEnvelope
    public void pr() {
        setVisibility(0);
    }

    @Override // com.byazt.ky.BaseSaasEnvelope
    public void hw() {
        setVisibility(8);
        super.hw();
    }
}
