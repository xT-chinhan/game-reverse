package com.tapsdk.tapad.internal.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tapsdk.tapad.R;

/* JADX INFO: loaded from: classes3.dex */
public class ShakeAnimationView extends View implements com.tapsdk.tapad.internal.animation.b {
    private f a;
    private AnimationDrawable b;
    private Float c;
    private ValueAnimator d;
    private Paint e;
    private int f;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (valueAnimator == null) {
                return;
            }
            float animatedFraction = valueAnimator.getAnimatedFraction();
            ShakeAnimationView shakeAnimationView = ShakeAnimationView.this;
            shakeAnimationView.c = Float.valueOf(shakeAnimationView.getWidth() * animatedFraction);
            ShakeAnimationView.this.invalidate();
        }
    }

    class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ShakeAnimationView.this.a.a(ShakeAnimationView.this.f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public ShakeAnimationView(Context context) {
        super(context);
        this.c = Float.valueOf(0.0f);
        this.e = new Paint();
        d();
    }

    public ShakeAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = Float.valueOf(0.0f);
        this.e = new Paint();
        d();
    }

    public ShakeAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = Float.valueOf(0.0f);
        this.e = new Paint();
        d();
    }

    public ShakeAnimationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = Float.valueOf(0.0f);
        this.e = new Paint();
        d();
    }

    private void d() {
        setBackgroundResource(R.drawable.tapad_shake_frame_animation);
        this.b = (AnimationDrawable) getBackground();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.d = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.d.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.addUpdateListener(new a());
        this.d.addListener(new b());
    }

    @Override // com.tapsdk.tapad.internal.animation.b
    public void a() {
        this.c = Float.valueOf(0.0f);
        this.b.start();
    }

    @Override // com.tapsdk.tapad.internal.animation.b
    public void a(int i) {
        this.f = i;
        if (isAttachedToWindow()) {
            this.d.start();
        }
    }

    @Override // com.tapsdk.tapad.internal.animation.b
    public void b() {
        this.b.stop();
    }

    @Override // com.tapsdk.tapad.internal.animation.b
    public void c() {
        this.d.end();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        this.e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.OVERLAY));
        this.e.setColor(-1);
        canvas.drawRect((getWidth() - this.c.floatValue()) / 2.0f, 0.0f, (getWidth() + this.c.floatValue()) / 2.0f, getHeight() * 0.3f, this.e);
        this.e.setXfermode(null);
    }

    @Override // com.tapsdk.tapad.internal.animation.b
    public void setListener(f fVar) {
        this.a = fVar;
    }
}
