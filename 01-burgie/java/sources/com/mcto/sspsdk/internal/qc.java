package com.mcto.sspsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes2.dex */
public final class qc extends ae {
    public final Paint a;
    public final RectF b;
    public final PorterDuffXfermode c;
    public int d;
    public int e;
    public float f;

    public qc(Context context) {
        super(context);
        this.d = -1;
        this.e = -7829368;
        this.a = new Paint();
        this.b = new RectF();
        this.c = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    }

    @Override // com.mcto.sspsdk.internal.ae
    public final void a(int i, int i2) {
        this.d = i;
        this.e = i2;
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
        this.a.setColor(this.d);
        Paint paint = this.a;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.a.setStrokeWidth(iMin);
        this.a.setAntiAlias(true);
        this.b.set(i4, i5, i4 + i3, i3 + i5);
        canvas.drawArc(this.b, 220.0f, 100.0f, false, this.a);
        this.a.setStyle(style);
        this.a.setColor(this.e);
        this.a.setAntiAlias(true);
        this.a.setXfermode(this.c);
        this.a.setStrokeWidth(iMin * 2);
        canvas.drawArc(this.b, 220.0f, this.f * 100.0f, false, this.a);
        this.a.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // com.mcto.sspsdk.internal.ae
    public final void a(float f) {
        this.f = Math.max(0.0f, Math.min(1.0f, f));
        invalidate();
    }
}
