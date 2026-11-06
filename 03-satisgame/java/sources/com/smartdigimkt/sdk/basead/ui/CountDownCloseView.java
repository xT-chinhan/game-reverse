package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes3.dex */
public class CountDownCloseView extends CloseImageView {
    public final Paint d;
    public final Paint e;
    public float f;
    public int g;
    public final int h;
    public int i;
    public int j;
    public final RectF k;
    public float l;
    public long m;

    public CountDownCloseView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.l < 360.0f) {
            this.d.setColor(this.g);
            canvas.drawArc(this.k, 0.0f, 360.0f, false, this.d);
            this.d.setColor(this.h);
            canvas.drawArc(this.k, -90.0f, this.l, false, this.d);
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = i;
        this.j = i2;
        float f = this.f * 0.5f;
        float f2 = 0.0f + f;
        this.k.set(f2, f2, i - f, i2 - f);
        this.k.width();
    }

    public void refresh(long j) {
        long j2 = this.m;
        if (j2 > 0) {
            this.l = ((j * 1.0f) / j2) * 360.0f;
            if (Looper.getMainLooper() == Looper.myLooper()) {
                invalidate();
            } else {
                postInvalidate();
            }
        }
    }

    public void setDuration(long j) {
        this.m = j;
    }

    public void setThickInPx(int i) {
        float f = i;
        this.f = f;
        this.d.setStrokeWidth(f);
        float f2 = this.f * 0.5f;
        float f3 = 0.0f + f2;
        this.k.set(f3, f3, this.i - f2, this.j - f2);
        this.k.width();
    }

    public void setUnderRingColor(int i) {
        this.g = i;
    }

    public CountDownCloseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = TypedValue.applyDimension(1, 2.5f, context.getResources().getDisplayMetrics());
        this.g = Color.parseColor("#FF57575A");
        this.h = -1;
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f);
        Paint paint2 = new Paint();
        this.e = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        this.k = new RectF();
    }
}
