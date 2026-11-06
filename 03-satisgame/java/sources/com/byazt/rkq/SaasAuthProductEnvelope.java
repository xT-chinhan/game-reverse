package com.byazt.rkq;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.anythink.core.common.d.i;
import com.byazt.cp.n;
import com.byazt.gct.dg;
import com.byazt.imu.s;
import com.byazt.ndr.TTRoundRectImageView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 1590})
public class SaasAuthProductEnvelope extends BaseSaasEnvelope {
    @Override // com.byazt.rkq.BaseSaasEnvelope
    public void n() {
    }

    public SaasAuthProductEnvelope(Context context, dg.n nVar) {
        super(context);
        n(context, nVar);
    }

    private void n(Context context, dg.n nVar) {
        if (nVar == null) {
            setVisibility(8);
            return;
        }
        RelativeLayout relativeLayoutN = n(context);
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        try {
            s.n(com.byazt.iu.n.n("saas_reward_goods_bg.webp")).n(imageView);
        } catch (Error unused) {
        }
        relativeLayoutN.addView(imageView);
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        textView.setId(2114387802);
        layoutParams.topMargin = com.byazt.okk.s.s(context, 20.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText("超值好物");
        textView.setTextColor(Color.parseColor("#A9512C"));
        textView.setTypeface(null, 1);
        relativeLayoutN.addView(textView);
        TextView textView2 = new TextView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(14);
        layoutParams2.addRule(3, textView.getId());
        layoutParams2.topMargin = com.byazt.okk.s.s(context, 20.0f);
        textView2.setId(2114387462);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setMaxLines(1);
        textView2.setMaxWidth(com.byazt.okk.s.s(context, 200.0f));
        textView2.setLayoutParams(layoutParams2);
        textView2.setTextSize(2, 12.0f);
        textView2.setGravity(17);
        textView2.setText(nVar.n());
        textView2.setTextColor(Color.parseColor("#161823"));
        relativeLayoutN.addView(textView2);
        int iS = com.byazt.okk.s.s(context, 80.0f);
        int iS2 = com.byazt.okk.s.s(context, 10.0f);
        TTRoundRectImageView tTRoundRectImageView = new TTRoundRectImageView(context, iS2, iS2);
        tTRoundRectImageView.setId(2114387456);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iS, iS);
        layoutParams3.addRule(14);
        layoutParams3.addRule(3, textView2.getId());
        layoutParams3.topMargin = com.byazt.okk.s.s(context, 12.0f);
        s.n(nVar.qg()).n(iS).qg(iS).n(tTRoundRectImageView);
        tTRoundRectImageView.setLayoutParams(layoutParams3);
        relativeLayoutN.addView(tTRoundRectImageView);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(2114387457);
        linearLayout.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(3, tTRoundRectImageView.getId());
        layoutParams4.topMargin = com.byazt.okk.s.s(context, 12.0f);
        linearLayout.setLayoutParams(layoutParams4);
        TextView textView3 = new TextView(context);
        textView3.setTextSize(2, 11.0f);
        textView3.setTypeface(null, 1);
        textView3.setTextColor(Color.parseColor("#F93F3F"));
        textView3.setText("¥");
        linearLayout.addView(textView3);
        double dQ = nVar.q();
        int iFloor = (int) Math.floor(dQ);
        int i = (int) ((dQ - ((double) iFloor)) * 100.0d);
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
        textView5.setText(i.E + i + (i >= 10 ? "" : "0"));
        linearLayout.addView(textView5);
        TextView textView6 = new TextView(context);
        textView6.getPaint().setFlags(16);
        textView6.setTextSize(2, 11.0f);
        textView6.setTextColor(Color.parseColor("#161823"));
        textView6.setText("￥" + nVar.s());
        linearLayout.addView(textView6);
        relativeLayoutN.addView(linearLayout);
        n(context, "一键关联抖音购买", relativeLayoutN);
        addView(relativeLayoutN);
    }

    @Override // com.byazt.rkq.BaseSaasEnvelope
    public void qg() {
        super.qg();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qg();
    }
}
