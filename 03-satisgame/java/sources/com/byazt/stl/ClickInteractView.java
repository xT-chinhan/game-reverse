package com.byazt.stl;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.cq.fs;
import com.byazt.tk.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 769})
public class ClickInteractView extends FrameLayout {
    public ImageView n;
    public AnimatorSet qg;

    public ClickInteractView(Context context) {
        super(context);
        s();
        q();
    }

    private void s() {
        this.n = new ImageView(getContext());
        sz.n(getContext(), "tt_white_hand", this.n, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        int iN = (int) fs.n(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iN, iN);
        layoutParams.gravity = 17;
        addView(this.n, layoutParams);
    }

    private void q() {
        this.qg = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.n, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(2000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.n, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(2000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.qg.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void n() {
        AnimatorSet animatorSet = this.qg;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void qg() {
        AnimatorSet animatorSet = this.qg;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
