package com.byazt.stl;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1483})
public class RippleView extends View {
    public float fs;
    public Paint l;
    public float n;
    public ValueAnimator q;
    public float qg;
    public Animator.AnimatorListener rv;
    public ValueAnimator s;
    public int tj;
    public long w;
    public float x;

    public RippleView(Context context, int i) {
        super(context);
        this.w = 300L;
        this.x = 0.0f;
        this.tj = i;
        n();
    }

    public void n() {
        Paint paint = new Paint(1);
        this.l = paint;
        paint.setStyle(Paint.Style.FILL);
        this.l.setColor(this.tj);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.n = i / 2.0f;
        this.qg = i2 / 2.0f;
        this.fs = (float) (Math.hypot(i, i2) / 2.0d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.n, this.qg, this.x, this.l);
    }

    public void qg() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.fs);
        this.s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.w);
        this.s.setInterpolator(new LinearInterpolator());
        this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.stl.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.s.start();
    }

    public void s() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.fs, 0.0f);
        this.q = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.w);
        this.q.setInterpolator(new LinearInterpolator());
        this.q.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.stl.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.rv;
        if (animatorListener != null) {
            this.q.addListener(animatorListener);
        }
        this.q.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.rv = animatorListener;
    }
}
