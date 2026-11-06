package com.byazt.stl;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.cq.fs;
import com.byazt.cq.rv;
import com.byazt.tk.ur;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1456})
public class CircleLongPressView extends FrameLayout {
    public RingProgressView l;
    public Context n;
    public TextView q;
    public ImageView qg;
    public ImageView s;
    public AnimatorSet w;

    public CircleLongPressView(Context context) {
        super(context);
        this.w = new AnimatorSet();
        this.n = context;
        l();
        w();
    }

    private void l() {
        FrameLayout frameLayout = new FrameLayout(this.n);
        this.l = new RingProgressView(this.n);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) fs.n(this.n, 95.0f), (int) fs.n(this.n, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.l, layoutParams);
        this.qg = new ImageView(this.n);
        int iN = ur.n(this.n, 60.0f);
        this.qg.setImageDrawable(rv.n(1, null, null, new int[]{iN, iN}, Integer.valueOf(ur.n(this.n, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) fs.n(this.n, 75.0f), (int) fs.n(this.n, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.qg, layoutParams2);
        this.s = new ImageView(this.n);
        int iN2 = ur.n(this.n, 50.0f);
        this.s.setImageDrawable(rv.n(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iN2, iN2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) fs.n(this.n, 63.0f), (int) fs.n(this.n, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.s, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.n);
        this.q = textView;
        textView.setTextColor(-1);
        this.q.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.q, layoutParams4);
    }

    private void w() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.s, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.s, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.w.setDuration(800L);
        this.w.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    public void setGuideText(String str) {
        this.q.setText(str);
    }

    public void n() {
        this.w.start();
    }

    public void qg() {
        this.w.cancel();
    }

    public void s() {
        this.l.n();
    }

    public void q() {
        this.l.qg();
        this.l.s();
    }
}
