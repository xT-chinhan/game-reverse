package com.byazt.jt;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.byazt.js.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK})
public class ClickInteractView extends FrameLayout {
    public AnimatorSet hw;
    public ImageView pr;

    public ClickInteractView(Context context) {
        super(context);
        hn();
        x();
    }

    private void hn() {
        this.pr = new ImageView(getContext());
        g.pr(getContext(), "tt_white_hand", this.pr, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        int iPr = (int) zo.pr(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iPr, iPr);
        layoutParams.gravity = 17;
        addView(this.pr, layoutParams);
    }

    private void x() {
        this.hw = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.pr, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(2000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.pr, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(2000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.hw.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void pr() {
        AnimatorSet animatorSet = this.hw;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void hw() {
        AnimatorSet animatorSet = this.hw;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
