package com.byazt.ky;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.hb.hn;
import com.byazt.hg.qi;
import com.byazt.pi.TTRoundRectImageView;
import com.byazt.ub.hw;
import com.byazt.vzx.pr;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, 1470})
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    public SaasAuthProductEnvelope(Context context, qi.pr prVar) {
        super(context);
        pr(context, prVar);
    }

    private void pr(Context context, qi.pr prVar) {
        if (prVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutPr = pr(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            hw.pr(hn.pr("saas_reward_goods_bg.webp")).pr(imageView);
        } catch (Error e) {
        }
        relativeLayoutPr.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387802);
        layoutParams.topMargin = er.hn(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("超值好物");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        relativeLayoutPr.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = er.hn(context, 20.0f);
        textView2.setId(2114387462);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(er.hn(context, 200.0f));
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(prVar.pr());
        textView2.setTextColor(Color.parseColor("#161823"));
        relativeLayoutPr.addView(textView2);
        int iHn = er.hn(context, 80.0f);
        int iHn2 = er.hn(context, 10.0f);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context, iHn2, iHn2);
        tTRoundRectImageView.setId(2114387456);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iHn, iHn);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.topMargin = er.hn(context, 12.0f);
        hw.pr(prVar.hw()).pr(iHn).hw(iHn).pr(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(layoutParams3);
        relativeLayoutPr.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387457);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, tTRoundRectImageView.getId());
        layoutParams4.topMargin = er.hn(context, 12.0f);
        linearLayout.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("¥");
        linearLayout.addView(textView3);
        double dX = prVar.x();
        int iFloor = (int) Math.floor(dX);
        int i = (int) ((dX - ((double) iFloor)) * 100.0d);
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
        textView5.setText("." + i + (i >= 10 ? "" : "0"));
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("￥" + prVar.hn());
        linearLayout.addView(textView6);
        relativeLayoutPr.addView(linearLayout);
        pr(context, "一键关联抖音购买", relativeLayoutPr);
        addView(relativeLayoutPr);
    }

    @Override // com.byazt.ky.BaseSaasEnvelope
    public void pr() {
    }

    @Override // com.byazt.ky.BaseSaasEnvelope
    public void hw() {
        super.hw();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hw();
    }
}
