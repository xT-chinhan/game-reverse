package com.byazt.ky;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.ca.g;
import com.byazt.hb.hn;
import com.byazt.ub.hw;
import com.byazt.vzx.pr;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS})
public class SaasAuthEnvelope extends RelativeLayout {
    public ImageView hn;
    public ImageView hw;
    public AnimationSet pr;

    public SaasAuthEnvelope(Context context) {
        super(context);
        pr(context);
        setVisibility(8);
    }

    private void pr(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387464);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.hn = new ImageView(context);
        try {
            hw.pr(hn.pr("saas_red_envelope.webp")).pr(this.hn);
        } catch (Error e) {
        }
        linearLayout.addView(this.hn, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.hw = imageView;
        try {
            g.pr(context, "tt_saas_close", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } catch (Error e2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = er.hn(context, 25.0f);
        linearLayout.addView(this.hw, layoutParams2);
    }

    public void pr() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.pr = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.pr.addAnimation(scaleAnimation);
        startAnimation(this.pr);
    }

    public void hw() {
        AnimationSet animationSet = this.pr;
        if (animationSet != null) {
            animationSet.cancel();
            this.pr = null;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hw();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.hw;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
