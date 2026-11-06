package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
public class RingProgressView extends View {
    private boolean ab;
    private RectF ah;
    private int c;
    private float d;
    private ValueAnimator ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f960ms;
    private Paint xr;

    public RingProgressView(Context context) {
        super(context);
        this.c = TTAdConstant.STYLE_SIZE_RADIO_3_2;
        this.f960ms = context;
        Paint paint = new Paint();
        this.xr = paint;
        paint.setAntiAlias(true);
        this.xr.setStyle(Paint.Style.STROKE);
        this.xr.setStrokeWidth(10.0f);
        this.xr.setColor(Color.parseColor("#80FFFFFF"));
        this.ah = new RectF();
    }

    public void ms() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.ka = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(this.c);
        this.ka.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.RingProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RingProgressView.this.d = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RingProgressView.this.requestLayout();
            }
        });
        this.ka.start();
    }

    public void xr() {
        ValueAnimator valueAnimator = this.ka;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public void ah() {
        this.ab = true;
        invalidate();
    }

    public void setDuration(int i) {
        this.c = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ab) {
            return;
        }
        canvas.drawArc(this.ah, 270.0f, this.d, false, this.xr);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ah.set(5.0f, 5.0f, i - 5, i2 - 5);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }
}
