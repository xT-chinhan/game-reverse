package com.byazt.un;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.ndr.RoundImageView;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 14, 19})
public abstract class n implements com.byazt.lz.n {
    public RelativeLayout n(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(Color.parseColor("#99000000"));
        if (i != 0) {
            relativeLayout.setId(i);
        }
        return relativeLayout;
    }

    public View qg(Context context, int i) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387911);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 66.0f), com.byazt.okk.s.s(context, 66.0f));
        layoutParams.addRule(14);
        if (i != 0) {
            layoutParams.setMargins(0, com.byazt.okk.s.s(context, i), 0, 0);
        }
        relativeLayout.setLayoutParams(layoutParams);
        sz.n(context, "tt_live_avatar_bg", relativeLayout, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        RoundImageView roundImageView = new RoundImageView(context);
        roundImageView.setId(2114387831);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 65.0f), com.byazt.okk.s.s(context, 65.0f));
        layoutParams2.addRule(14);
        layoutParams2.addRule(10);
        roundImageView.setLayoutParams(layoutParams2);
        relativeLayout.addView(roundImageView);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387608);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 42.0f), com.byazt.okk.s.s(context, 18.0f));
        layoutParams3.addRule(13);
        layoutParams3.addRule(12);
        imageView.setLayoutParams(layoutParams3);
        sz.n(context, "tt_live_ad_status_icon", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout.addView(imageView);
        return relativeLayout;
    }

    public View n(Context context, int i, int i2) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387693);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.byazt.okk.s.s(context, 44.0f));
        layoutParams.addRule(12);
        layoutParams.setMargins(com.byazt.okk.s.s(context, 40.0f), 0, com.byazt.okk.s.s(context, 40.0f), com.byazt.okk.s.s(context, i));
        relativeLayout.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(com.byazt.okk.s.s(context, 5.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setGravity(17);
        ImageView imageView = new ImageView(context);
        imageView.setId(2114387876);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 14.0f), com.byazt.okk.s.s(context, 16.0f));
        layoutParams2.addRule(15);
        layoutParams2.setMargins(0, 0, com.byazt.okk.s.s(context, i2), 0);
        imageView.setLayoutParams(layoutParams2);
        sz.n(context, "tt_live_ad_loading_btn_status", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout.addView(imageView);
        TextView textView = new TextView(context);
        textView.setId(2114387752);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(1, 2114387876);
        layoutParams3.addRule(17, 2114387876);
        layoutParams3.addRule(15);
        textView.setLayoutParams(layoutParams3);
        textView.setGravity(16);
        textView.setSingleLine(true);
        textView.setText("进入直播间");
        textView.setTextColor(-1);
        relativeLayout.addView(textView);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 14.0f), com.byazt.okk.s.s(context, 16.0f));
        layoutParams4.addRule(1, 2114387752);
        layoutParams4.addRule(13);
        layoutParams4.setMargins(0, 0, com.byazt.okk.s.s(context, 6.0f), 0);
        imageView2.setLayoutParams(layoutParams4);
        sz.n(context, "tt_splash_click_bar_go", (View) imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }
}
