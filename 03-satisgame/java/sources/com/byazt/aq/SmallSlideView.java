package com.byazt.aq;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 947})
public class SmallSlideView extends RelativeLayout {
    public final View n;
    public ObjectAnimator q;
    public final qg qg;
    public ObjectAnimator s;

    public SmallSlideView(Context context) {
        super(context);
        View nVar = new n(context);
        this.n = nVar;
        qg qgVar = new qg(context);
        this.qg = qgVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.byazt.okk.s.s(context, 10.0f), 0);
        layoutParams.setMargins(0, com.byazt.okk.s.s(context, 8.0f), 0, com.byazt.okk.s.s(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(qgVar, layoutParams);
        addView(nVar);
        setLayoutParams(new LinearLayout.LayoutParams(com.byazt.okk.s.s(context, 80.0f), com.byazt.okk.s.s(context, 80.0f)));
    }

    public void n() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.n, "translationY", com.byazt.okk.s.s(getContext(), 30.0f), com.byazt.okk.s.s(getContext(), -20.0f));
        this.s = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(800L);
        this.s.setRepeatCount(1);
        this.s.setRepeatMode(1);
        this.s.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.qg, "newHeight", com.byazt.okk.s.s(getContext(), 0.0f), com.byazt.okk.s.s(getContext(), 48.0f));
        this.q = objectAnimatorOfInt;
        objectAnimatorOfInt.setDuration(800L);
        this.q.setRepeatCount(1);
        this.q.setRepeatMode(1);
        this.q.start();
    }

    public void qg() {
        ObjectAnimator objectAnimator = this.s;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.q;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 1980})
    private static class n extends FrameLayout {
        public n(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            sz.n(context, "tt_splash_slide_up_finger", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = com.byazt.okk.s.s(context, 38.0f);
            layoutParams.bottomMargin = com.byazt.okk.s.s(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            sz.n(context, "tt_splash_slide_up_circle", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int iS = com.byazt.okk.s.s(context, 30.0f);
            layoutParams2.setMargins(iS, iS, iS, iS);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN, 1620})
    private static class qg extends FrameLayout {
        public qg(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            sz.n(context, "tt_splash_slide_up_bg", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            addView(imageView);
        }
    }
}
