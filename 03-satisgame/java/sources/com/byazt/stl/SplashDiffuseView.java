package com.byazt.stl;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 1848})
public class SplashDiffuseView extends View {
    public static int s = 50;
    public Paint n;
    public ObjectAnimator q;
    public int qg;

    public SplashDiffuseView(Context context) {
        this(context, null);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qg = 10;
        s();
    }

    private void s() {
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setColor(Color.parseColor("#FFFFFFFF"));
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setStrokeWidth(18.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        this.q = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(200L);
    }

    @Override // android.view.View
    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.n.setShader(new LinearGradient(getMeasuredWidth() / 2, 0.0f, getMeasuredWidth() / 2, getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        canvas.drawCircle(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f, this.qg, this.n);
    }

    public void n() {
        int iMin = ((int) Math.min(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f)) - 18;
        s = iMin;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(10, iMin);
        valueAnimatorOfInt.setInterpolator(new PathInterpolator(0.0f, 0.2f, 0.3f, 1.0f));
        valueAnimatorOfInt.setDuration(800L);
        valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.stl.SplashDiffuseView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SplashDiffuseView.this.qg = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashDiffuseView.this.invalidate();
            }
        });
        valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.byazt.stl.SplashDiffuseView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SplashDiffuseView.this.setVisibility(0);
                SplashDiffuseView.this.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SplashDiffuseView.this.q.start();
            }
        });
        valueAnimatorOfInt.start();
    }

    public void qg() {
        clearAnimation();
    }
}
