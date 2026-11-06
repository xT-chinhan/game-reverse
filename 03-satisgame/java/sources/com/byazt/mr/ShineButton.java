package com.byazt.mr;

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
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, 1343})
public class ShineButton extends Button {
    public ValueAnimator l;
    public Paint n;
    public float q;
    public LinearGradient qg;
    public Matrix s;
    public float w;

    public ShineButton(Context context) {
        super(context);
        this.n = new Paint(1);
        this.s = new Matrix();
        this.q = 0.0f;
        this.w = 0.3f;
        n(context);
    }

    private void n(Context context) {
        this.n.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.n.setColor(-1);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2 * this.w;
        float f2 = -f;
        LinearGradient linearGradient = new LinearGradient(f2, f2, f, f, new int[]{0, Color.parseColor("#88ffffff"), Color.parseColor("#88ffffff"), 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.qg = linearGradient;
        this.n.setShader(linearGradient);
        n();
    }

    private void n() {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.l.removeAllListeners();
            this.l.removeAllUpdateListeners();
            this.l = null;
        }
        float fSqrt = (float) Math.sqrt((getWidth() * getWidth()) + (getHeight() * getHeight()));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-fSqrt, fSqrt);
        this.l = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(2000L);
        this.l.setRepeatCount(-1);
        this.l.setInterpolator(new LinearInterpolator());
        this.l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.mr.ShineButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShineButton.this.q = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                ShineButton.this.invalidate();
            }
        });
        this.l.start();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.s;
        float f = this.q;
        matrix.setTranslate(f, f);
        this.qg.setLocalMatrix(this.s);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.n);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.l.removeAllListeners();
            this.l.removeAllUpdateListeners();
            this.l = null;
        }
    }
}
