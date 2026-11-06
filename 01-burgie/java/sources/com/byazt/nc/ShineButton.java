package com.byazt.nc;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 1281})
public class ShineButton extends Button {
    public ValueAnimator c;
    public Matrix hn;
    public LinearGradient hw;
    public Paint pr;
    public float uc;
    public float x;

    public ShineButton(Context context) {
        super(context);
        this.pr = new Paint(1);
        this.hn = new Matrix();
        this.x = 0.0f;
        this.uc = 0.3f;
        pr(context);
    }

    private void pr(Context context) {
        this.pr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.pr.setColor(-1);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2 * this.uc;
        float f2 = -f;
        LinearGradient linearGradient = new LinearGradient(f2, f2, f, f, new int[]{0, Color.parseColor("#88ffffff"), Color.parseColor("#88ffffff"), 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.hw = linearGradient;
        this.pr.setShader(linearGradient);
        pr();
    }

    private void pr() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c.removeAllListeners();
            this.c.removeAllUpdateListeners();
            this.c = null;
        }
        float fSqrt = (float) Math.sqrt((getWidth() * getWidth()) + (getHeight() * getHeight()));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-fSqrt, fSqrt);
        this.c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(2000L);
        this.c.setRepeatCount(-1);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.nc.ShineButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShineButton.this.x = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                ShineButton.this.invalidate();
            }
        });
        this.c.start();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.hn;
        float f = this.x;
        matrix.setTranslate(f, f);
        this.hw.setLocalMatrix(this.hn);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.pr);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.c.removeAllListeners();
            this.c.removeAllUpdateListeners();
            this.c = null;
        }
    }
}
