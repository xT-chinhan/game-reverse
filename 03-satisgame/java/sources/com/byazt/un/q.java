package com.byazt.un;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 14, 5})
public class q extends n {
    @Override // com.byazt.lz.n
    public View qg(Context context) {
        RelativeLayout relativeLayoutN = n(context, 2114387616);
        relativeLayoutN.setVisibility(8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        relativeLayoutN.addView(relativeLayout, layoutParams);
        relativeLayout.addView(qg(context, 0));
        TextView textView = new TextView(context);
        textView.setId(2114387742);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, 2114387911);
        layoutParams2.addRule(14);
        layoutParams2.setMargins(0, com.byazt.okk.s.s(context, 13.0f), 0, 0);
        textView.setLayoutParams(layoutParams2);
        textView.setTextColor(context.getResources().getColor(R.color.white));
        textView.setTextSize(2, 16.0f);
        relativeLayout.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setId(2114387807);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, 2114387742);
        layoutParams3.addRule(14);
        layoutParams3.setMargins(0, com.byazt.okk.s.s(context, 8.0f), 0, 0);
        textView2.setLayoutParams(layoutParams3);
        textView2.setTextColor(context.getResources().getColor(R.color.white));
        textView2.setTextSize(2, 12.0f);
        textView2.setText("数据加载中...");
        relativeLayout.addView(textView2);
        relativeLayout.addView(n(context));
        return relativeLayoutN;
    }

    private View n(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.byazt.okk.s.s(context, 32.0f));
        layoutParams.addRule(3, 2114387807);
        layoutParams.addRule(14);
        layoutParams.topMargin = com.byazt.okk.s.s(context, 17.0f);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setMinimumWidth(com.byazt.okk.s.s(context, 110.0f));
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 12.0f), com.byazt.okk.s.s(context, 14.0f));
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = com.byazt.okk.s.s(context, 6.0f);
        imageView.setLayoutParams(layoutParams2);
        sz.n(context, "tt_live_ad_loading_btn_status", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        TextView textView = new TextView(context);
        textView.setId(2114387752);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387876);
        layoutParams3.addRule(17, 2114387876);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText("进入直播间");
        textView.setTextColor(-1);
        textView.setTextSize(2, 11.0f);
        textView.setLayoutParams(layoutParams3);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 12.0f), com.byazt.okk.s.s(context, 14.0f));
        layoutParams4.addRule(13);
        layoutParams4.addRule(1, 2114387752);
        layoutParams4.addRule(17, 2114387752);
        imageView2.setLayoutParams(layoutParams4);
        sz.n(context, "tt_splash_click_bar_go", (View) imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout.addView(imageView);
        relativeLayout.addView(textView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
