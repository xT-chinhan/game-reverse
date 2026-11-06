package com.byazt.jm;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.ca.g;
import com.byazt.sd.a;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 859})
public class SlideUpView extends RelativeLayout {
    public AnimatorSet c;
    public AnimatorSet fw;
    public ImageView hn;
    public ImageView hw;
    public ImageView pr;
    public AnimatorSet uc;
    public ImageView x;
    public AnimatorSet zo;

    public SlideUpView(Context context) {
        super(context);
        hw(context);
    }

    private View pr(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.hn = imageView;
        imageView.setId(2114387639);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387761);
        layoutParams2.bottomMargin = er.hn(context, -24.0f);
        g.pr(context, "tt_splash_slide_up_circle", (View) this.hn, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.hn.setAlpha(0.0f);
        this.hn.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.hn);
        ImageView imageView2 = new ImageView(context);
        this.hw = imageView2;
        imageView2.setId(2114387939);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387761);
        layoutParams3.addRule(8, 2114387761);
        g.pr(context, "tt_splash_slide_up_bg", (View) this.hw, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        layoutParams3.leftMargin = er.hn(context, -7.0f);
        this.hw.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.hw);
        ImageView imageView3 = new ImageView(context);
        this.pr = imageView3;
        imageView3.setId(2114387644);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387761);
        layoutParams4.addRule(8, 2114387761);
        g.pr(context, "tt_splash_slide_up_finger", (View) this.pr, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        layoutParams4.leftMargin = er.hn(context, -7.0f);
        layoutParams4.bottomMargin = er.hn(context, -20.0f);
        this.pr.setAlpha(0.0f);
        this.pr.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.pr);
        ImageView imageView4 = new ImageView(context);
        this.x = imageView4;
        imageView4.setId(2114387761);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        g.pr(context, "tt_splash_slide_up_arrow", (View) this.x, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.x.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.x);
        return relativeLayout;
    }

    private void hw(Context context) {
        if (context == null) {
            context = a.getContext();
        }
        View viewPr = pr(context);
        if (viewPr == null) {
            return;
        }
        addView(viewPr);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.c;
    }

    public void pr() {
        this.uc = new AnimatorSet();
        this.fw = new AnimatorSet();
        this.zo = new AnimatorSet();
        this.c = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pr, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pr, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.pr, "translationY", 0.0f, er.hn(getContext(), -110.0f));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, er.hn(getContext(), 110.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jm.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.hw.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.hw.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.hw, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.hw, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.hn, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.hn, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.hn, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.hn, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.hn, "translationY", 0.0f, er.hn(getContext(), -110.0f));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.uc.setDuration(50L);
        this.zo.setDuration(1500L);
        this.fw.setDuration(50L);
        this.uc.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.fw.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.zo.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.c.playSequentially(this.fw, this.zo, this.uc);
    }

    public void hw() {
        AnimatorSet animatorSet = this.c;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.fw;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.uc;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.zo;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }
}
