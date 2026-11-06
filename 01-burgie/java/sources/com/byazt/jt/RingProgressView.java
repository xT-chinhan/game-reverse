package com.byazt.jt;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 2001})
public class RingProgressView extends View {
    public ValueAnimator c;
    public boolean fw;
    public RectF hn;
    public Paint hw;
    public Context pr;
    public int uc;
    public float x;

    public RingProgressView(Context context) {
        super(context);
        this.uc = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.pr = context;
        Paint paint = new Paint();
        this.hw = paint;
        paint.setAntiAlias(true);
        this.hw.setStyle(Paint.Style.STROKE);
        this.hw.setStrokeWidth(10.0f);
        this.hw.setColor(Color.parseColor("#80FFFFFF"));
        this.hn = new RectF();
    }

    public void pr() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.c = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.uc);
        this.c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.jt.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.x = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.c.start();
    }

    public void hw() {
        ValueAnimator valueAnimator = this.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void hn() {
        this.fw = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.uc = i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.fw) {
            return;
        }
        canvas.drawArc(this.hn, 270.0f, this.x, false, this.hw);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.hn.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
