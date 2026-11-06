package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class RippleView extends View {
    private float ab;
    private ValueAnimator ah;
    private long c;
    private int ch;
    private ValueAnimator d;
    private Paint ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f962ms;
    private Animator.AnimatorListener ny;
    private float x;
    private float xr;

    public RippleView(Context context, int i) {
        super(context);
        this.c = 300L;
        this.ab = 0.0f;
        this.ch = i;
        ms();
    }

    public void ms() {
        Paint paint = new Paint(1);
        this.ka = paint;
        paint.setStyle(Paint.Style.FILL);
        this.ka.setColor(this.ch);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f962ms = i / 2.0f;
        this.xr = i2 / 2.0f;
        this.x = (float) (Math.hypot(i, i2) / 2.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.f962ms, this.xr, this.ab, this.ka);
    }

    public void xr() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, this.x);
        this.ah = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.c);
        this.ah.setInterpolator(new LinearInterpolator());
        this.ah.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.ab = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        this.ah.start();
    }

    public void ah() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.x, 0.0f);
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.c);
        this.d.setInterpolator(new LinearInterpolator());
        this.d.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RippleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RippleView.this.ab = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RippleView.this.invalidate();
            }
        });
        Animator.AnimatorListener animatorListener = this.ny;
        if (animatorListener != null) {
            this.d.addListener(animatorListener);
        }
        this.d.start();
    }

    public void setAnimationListener(Animator.AnimatorListener animatorListener) {
        this.ny = animatorListener;
    }
}
