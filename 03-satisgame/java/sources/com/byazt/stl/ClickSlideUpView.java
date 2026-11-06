package com.byazt.stl;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.byazt.cq.fs;
import com.byazt.xta.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1458})
public class ClickSlideUpView extends SlideUpView {
    public TextView n;
    public View qg;
    public AnimatorSet s;

    @Override // com.byazt.stl.SlideUpView
    public void n(Context context) {
    }

    public ClickSlideUpView(Context context) {
        super(context);
        this.s = new AnimatorSet();
        qg(context);
    }

    private void qg(Context context) {
        View viewN = qg.n(context);
        this.qg = viewN;
        addView(viewN);
        setClipChildren(false);
        this.n = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.n == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.n.setText(str);
    }

    private void q() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.qg, "translationY", 0.0f, fs.n(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.qg, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.s.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.s.setDuration(1000L);
        this.s.start();
    }

    @Override // com.byazt.stl.SlideUpView
    public void n() {
        q();
    }

    @Override // com.byazt.stl.SlideUpView
    public void qg() {
        this.s.cancel();
    }
}
