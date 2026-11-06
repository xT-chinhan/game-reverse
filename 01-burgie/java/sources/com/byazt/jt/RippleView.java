package com.byazt.jt;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1374})
public class RippleView extends View {
    public Animator.AnimatorListener aj;
    public Paint c;
    public float fw;
    public ValueAnimator hn;
    public float hw;
    public float pr;
    public long uc;
    public int vk;
    public ValueAnimator x;
    public float zo;

    public RippleView(Context context, int i) {
        super(context);
        this.uc = 300L;
        this.fw = 0.0f;
        this.vk = i;
        pr();
    }

    public void pr() {
        Paint paint = new Paint(1);
        this.c = paint;
        paint.setStyle(Paint.Style.FILL);
        this.c.setColor(this.vk);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pr = i / 2.0f;
        this.hw = i2 / 2.0f;
        this.zo = (float) (Math.hypot(i, i2) / 2.0d);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.pr, this.hw, this.fw, this.c);
    }

    public void hw() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.zo);
        this.hn = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.uc);
        this.hn.setInterpolator(new LinearInterpolator());
        this.hn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jt.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.fw = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.hn.start();
    }

    public void hn() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.zo, 0.0f);
        this.x = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.uc);
        this.x.setInterpolator(new LinearInterpolator());
        this.x.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jt.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.fw = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.aj;
        if (animatorListener != null) {
            this.x.addListener(animatorListener);
        }
        this.x.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.aj = animatorListener;
    }
}
