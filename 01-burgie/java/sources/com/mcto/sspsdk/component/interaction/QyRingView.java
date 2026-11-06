package com.mcto.sspsdk.component.interaction;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.mcto.sspsdk.internal.de;

/* JADX INFO: loaded from: classes2.dex */
public class QyRingView extends View {
    private static final int[] h = {-1509949440, 1275068416, -1};
    private final float[] a;
    private float b;
    private float c;
    private final Paint d;
    private final Paint e;
    private ValueAnimator f;
    private final Path g;

    public QyRingView(Context context) {
        super(context);
        this.a = new float[]{0.0f, 0.96f, 1.0f};
        Paint paint = new Paint(1);
        this.d = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setColor(-855638017);
        paint2.setStyle(style);
        this.g = new Path();
    }

    public final void a(float f) {
        this.c = f;
        invalidate();
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin = Math.min(width, height);
        float fMax = Math.max(fMin - this.c, 0.0f);
        this.a[0] = fMax / fMin;
        RadialGradient radialGradient = new RadialGradient(width, height, fMin, h, this.a, Shader.TileMode.CLAMP);
        this.g.reset();
        this.d.setShader(radialGradient);
        this.g.addCircle(width, height, fMin, Path.Direction.CW);
        this.g.addCircle(width, height, fMax, Path.Direction.CCW);
        this.g.setFillType(Path.FillType.EVEN_ODD);
        canvas.drawPath(this.g, this.d);
        canvas.drawCircle(width, height, fMax, this.e);
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float fMin = Math.min(i, i2) * 0.325f;
        this.b = fMin;
        this.c = fMin;
        ValueAnimator valueAnimator = this.f;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f.cancel();
        }
        a();
    }

    public final void a() {
        float f = this.b;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.95f * f, f);
        this.f = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(600L);
        this.f.setRepeatCount(-1);
        this.f.setRepeatMode(2);
        this.f.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f.addUpdateListener(new de(this));
        this.f.start();
    }

    public QyRingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new float[]{0.0f, 0.96f, 1.0f};
        Paint paint = new Paint(1);
        this.d = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        Paint paint2 = new Paint(1);
        this.e = paint2;
        paint2.setColor(-855638017);
        paint2.setStyle(style);
        this.g = new Path();
    }
}
