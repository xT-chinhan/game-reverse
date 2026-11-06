package com.byazt.stl;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA, 2221})
public class RingProgressView extends View {
    public ValueAnimator l;
    public Context n;
    public float q;
    public Paint qg;
    public RectF s;
    public int w;
    public boolean x;

    public RingProgressView(Context context) {
        super(context);
        this.w = 1500;
        this.n = context;
        Paint paint = new Paint();
        this.qg = paint;
        paint.setAntiAlias(true);
        this.qg.setStyle(Paint.Style.STROKE);
        this.qg.setStrokeWidth(10.0f);
        this.qg.setColor(Color.parseColor("#80FFFFFF"));
        this.s = new RectF();
    }

    public void n() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.l = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.w);
        this.l.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.stl.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.l.start();
    }

    public void qg() {
        ValueAnimator valueAnimator = this.l;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void s() {
        this.x = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.w = i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.x) {
            return;
        }
        canvas.drawArc(this.s, 270.0f, this.q, false, this.qg);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.s.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
