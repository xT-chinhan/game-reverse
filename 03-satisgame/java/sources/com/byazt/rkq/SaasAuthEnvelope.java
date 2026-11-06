package com.byazt.rkq;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.cp.n;
import com.byazt.imu.s;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME})
public class SaasAuthEnvelope extends RelativeLayout {
    public AnimationSet n;
    public ImageView qg;
    public ImageView s;

    public SaasAuthEnvelope(Context context) {
        super(context);
        n(context);
        setVisibility(8);
    }

    private void n(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387464);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        this.s = new ImageView(context);
        try {
            s.n(com.byazt.iu.n.n("saas_red_envelope.webp")).n(this.s);
        } catch (Error unused) {
        }
        linearLayout.addView(this.s, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView = new ImageView(context);
        this.qg = imageView;
        try {
            sz.n(context, "tt_saas_close", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.byazt.okk.s.s(context, 25.0f);
        linearLayout.addView(this.qg, layoutParams2);
    }

    public void n() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.n = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.n.addAnimation(scaleAnimation);
        startAnimation(this.n);
    }

    public void qg() {
        AnimationSet animationSet = this.n;
        if (animationSet != null) {
            animationSet.cancel();
            this.n = null;
        }
        setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        qg();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.qg;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
