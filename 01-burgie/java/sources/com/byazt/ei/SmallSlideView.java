package com.byazt.ei;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.byazt.ca.g;
import com.byazt.wt.er;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 893})
public class SmallSlideView extends RelativeLayout {
    public ObjectAnimator hn;
    public final hw hw;
    public final View pr;
    public ObjectAnimator x;

    public SmallSlideView(Context context) {
        super(context);
        View prVar = new pr(context);
        this.pr = prVar;
        hw hwVar = new hw(context);
        this.hw = hwVar;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(er.hn(context, 10.0f), 0);
        layoutParams.setMargins(0, er.hn(context, 8.0f), 0, er.hn(context, 8.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        addView(hwVar, layoutParams);
        addView(prVar);
        setLayoutParams(new LinearLayout.LayoutParams(er.hn(context, 80.0f), er.hn(context, 80.0f)));
    }

    public void pr() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pr, "translationY", er.hn(getContext(), 30.0f), er.hn(getContext(), -20.0f));
        this.hn = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(800L);
        this.hn.setRepeatCount(1);
        this.hn.setRepeatMode(1);
        this.hn.start();
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.hw, "newHeight", er.hn(getContext(), 0.0f), er.hn(getContext(), 48.0f));
        this.x = objectAnimatorOfInt;
        objectAnimatorOfInt.setDuration(800L);
        this.x.setRepeatCount(1);
        this.x.setRepeatMode(1);
        this.x.start();
    }

    public void hw() {
        ObjectAnimator objectAnimator = this.hn;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.x;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, 1486})
    private static class pr extends FrameLayout {
        public pr(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            g.pr(context, "tt_splash_slide_up_finger", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.leftMargin = er.hn(context, 38.0f);
            layoutParams.bottomMargin = er.hn(context, 10.0f);
            ImageView imageView2 = new ImageView(context);
            g.pr(context, "tt_splash_slide_up_circle", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            int iHn = er.hn(context, 30.0f);
            layoutParams2.setMargins(iHn, iHn, iHn, iHn);
            addView(imageView2, layoutParams2);
            addView(imageView, layoutParams);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS, AVMDLDataLoader.KeyIsIsTestSpeedVersion})
    private static class hw extends FrameLayout {
        public hw(Context context) {
            super(context);
            ImageView imageView = new ImageView(context);
            g.pr(context, "tt_splash_slide_up_bg", (View) imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            addView(imageView);
        }
    }
}
