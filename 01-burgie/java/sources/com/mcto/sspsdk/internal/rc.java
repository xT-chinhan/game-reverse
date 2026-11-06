package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public final class rc extends ae {
    public static final double h = Math.cos(Math.toRadians(45.0d));
    public final Paint a;
    public final Path b;
    public final RectF c;
    public final PorterDuffXfermode d;
    public int e;
    public int f;
    public float g;

    public rc(Context context) {
        super(context);
        this.e = -1;
        this.f = -7829368;
        this.a = new Paint();
        this.b = new Path();
        this.c = new RectF();
        this.d = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    }

    @Override // com.mcto.sspsdk.internal.ae
    public final void a(int i, int i2) {
        this.e = i;
        this.f = i2;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int iMin = (int) (((double) Math.min(width, height)) * 0.078d);
        int i = width - iMin;
        int i2 = height - iMin;
        int iMin2 = Math.min(i, i2) / 2;
        int iSaveLayer = canvas.saveLayer(null, null, 31);
        int i3 = iMin2 * 2;
        int i4 = ((i - i3) + iMin) / 2;
        int i5 = ((i2 - i3) + iMin) / 2;
        double d = iMin;
        double d2 = h;
        double d3 = d * d2;
        double dSqrt = Math.sqrt(3.0d) * d * d2;
        this.a.setColor(this.e);
        Paint paint = this.a;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.a.setStrokeWidth(iMin);
        this.a.setAntiAlias(true);
        this.c.set(i4, i5, i3 + i4, i3 + i5);
        canvas.drawArc(this.c, 224.0f, 92.0f, false, this.a);
        Paint paint2 = this.a;
        Paint.Style style2 = Paint.Style.FILL;
        paint2.setStyle(style2);
        double d4 = iMin2;
        double d5 = i4;
        double d6 = ((d2 + 1.0d) * d4) + d5;
        double d7 = (1.0d - d2) * d4;
        double d8 = ((double) i5) + d7;
        this.b.reset();
        float f = (float) (d8 - d3);
        this.b.moveTo((float) (d6 + d3), f);
        float f2 = (float) (d8 + dSqrt);
        this.b.lineTo((float) (d6 + dSqrt), f2);
        float f3 = (float) (d8 + d3);
        this.b.lineTo((float) (d6 - d3), f3);
        this.b.close();
        canvas.drawPath(this.b, this.a);
        this.a.setStyle(style2);
        double d9 = d7 + d5;
        this.b.reset();
        this.b.moveTo((float) (d9 - d3), f);
        this.b.lineTo((float) (d9 - dSqrt), f2);
        this.b.lineTo((float) (d9 + d3), f3);
        this.b.close();
        canvas.drawPath(this.b, this.a);
        this.a.setStyle(style);
        this.a.setColor(this.f);
        this.a.setAntiAlias(true);
        this.a.setXfermode(this.d);
        this.a.setStrokeWidth(iMin * 2);
        canvas.drawArc(this.c, 270.0f, this.g * 60.0f, false, this.a);
        this.a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // com.mcto.sspsdk.internal.ae
    public final void a(float f) {
        this.g = Math.max(-1.0f, Math.min(1.0f, f));
        invalidate();
    }
}
