package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.adsdk.ugeno.ah;

/* JADX INFO: loaded from: classes2.dex */
public class DislikeView extends View {
    private float ab;
    private int ah;
    private Paint c;
    private RectF d;
    private Paint ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f404ms;
    private int ny;
    private Paint x;
    private int xr;

    public DislikeView(Context context) {
        super(context);
        ms();
    }

    private void ms() {
        Paint paint = new Paint();
        this.ka = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.x = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.c = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    public void setRadius(float f) {
        this.ab = f;
    }

    public void setDislikeColor(int i) {
        this.x.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.x.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.ka.setStyle(Paint.Style.STROKE);
        this.ka.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.ka.setStrokeWidth(i);
        this.ny = i;
    }

    public void setBgColor(int i) {
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(i);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar = this.f404ms;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            super.onMeasure(iArrMs[0], iArrMs[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.f404ms;
        if (ahVar != null) {
            ahVar.ms(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.d;
        float f = this.ab;
        canvas.drawRoundRect(rectF, f, f, this.c);
        RectF rectF2 = this.d;
        float f2 = this.ab;
        canvas.drawRoundRect(rectF2, f2, f2, this.ka);
        int i = this.xr;
        int i2 = this.ah;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.x);
        int i3 = this.xr;
        int i4 = this.ah;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.x);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.xr = i;
        this.ah = i2;
        int i5 = this.ny;
        this.d = new RectF(i5, i5, this.xr - i5, this.ah - i5);
        ah ahVar = this.f404ms;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        this.f404ms = ahVar;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.f404ms;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.f404ms;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.f404ms;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }
}
