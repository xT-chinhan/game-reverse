package com.byazt.hi;

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
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST})
public class SlideUpView extends RelativeLayout {
    public AnimatorSet fs;
    public AnimatorSet l;
    public ImageView n;
    public ImageView q;
    public ImageView qg;
    public ImageView s;
    public AnimatorSet w;
    public AnimatorSet x;

    public SlideUpView(Context context) {
        super(context);
        qg(context);
    }

    private View n(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.s = imageView;
        imageView.setId(2114387639);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387761);
        layoutParams2.bottomMargin = com.byazt.okk.s.s(context, -24.0f);
        sz.n(context, "tt_splash_slide_up_circle", (View) this.s, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.s.setAlpha(0.0f);
        this.s.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.s);
        ImageView imageView2 = new ImageView(context);
        this.qg = imageView2;
        imageView2.setId(2114387939);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387761);
        layoutParams3.addRule(8, 2114387761);
        sz.n(context, "tt_splash_slide_up_bg", (View) this.qg, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        layoutParams3.leftMargin = com.byazt.okk.s.s(context, -7.0f);
        this.qg.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.qg);
        ImageView imageView3 = new ImageView(context);
        this.n = imageView3;
        imageView3.setId(2114387644);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387761);
        layoutParams4.addRule(8, 2114387761);
        sz.n(context, "tt_splash_slide_up_finger", (View) this.n, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        layoutParams4.leftMargin = com.byazt.okk.s.s(context, -7.0f);
        layoutParams4.bottomMargin = com.byazt.okk.s.s(context, -20.0f);
        this.n.setAlpha(0.0f);
        this.n.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.n);
        ImageView imageView4 = new ImageView(context);
        this.q = imageView4;
        imageView4.setId(2114387761);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        sz.n(context, "tt_splash_slide_up_arrow", (View) this.q, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        this.q.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.q);
        return relativeLayout;
    }

    private void qg(Context context) {
        if (context == null) {
            context = com.byazt.nf.rv.getContext();
        }
        View viewN = n(context);
        if (viewN == null) {
            return;
        }
        addView(viewN);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.l;
    }

    public void n() {
        this.w = new AnimatorSet();
        this.x = new AnimatorSet();
        this.fs = new AnimatorSet();
        this.l = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.n, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.n, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.n, "translationY", 0.0f, com.byazt.okk.s.s(getContext(), -110.0f));
        objectAnimatorOfFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, com.byazt.okk.s.s(getContext(), 110.0f));
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.hi.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.qg.getLayoutParams();
                layoutParams.height = num.intValue();
                SlideUpView.this.qg.setLayoutParams(layoutParams);
            }
        });
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.qg, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.qg, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.s, "alpha", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(this.s, "alpha", 1.0f, 0.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(this.s, "scaleX", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat9 = ObjectAnimator.ofFloat(this.s, "scaleY", 0.0f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat10 = ObjectAnimator.ofFloat(this.s, "translationY", 0.0f, com.byazt.okk.s.s(getContext(), -110.0f));
        objectAnimatorOfFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.w.setDuration(50L);
        this.fs.setDuration(1500L);
        this.x.setDuration(50L);
        this.w.playTogether(objectAnimatorOfFloat2, objectAnimatorOfFloat7, objectAnimatorOfFloat5);
        this.x.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat6, objectAnimatorOfFloat8, objectAnimatorOfFloat9, objectAnimatorOfFloat4);
        this.fs.playTogether(objectAnimatorOfFloat3, valueAnimatorOfInt, objectAnimatorOfFloat10);
        this.l.playSequentially(this.x, this.fs, this.w);
    }

    public void qg() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.x;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.w;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.fs;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }
}
