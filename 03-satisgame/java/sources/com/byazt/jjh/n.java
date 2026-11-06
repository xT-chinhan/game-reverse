package com.byazt.jjh;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1397, 19})
public class n extends Drawable {
    public Paint n;
    public int qg;
    public float s;

    public n(int i) {
        this.qg = i;
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setFilterBitmap(true);
    }

    public void n(int i) {
        this.n.setColor(i);
    }

    public void n(float f) {
        this.n.setStrokeWidth(f);
        this.s = f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.qg) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.qg) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fCenterX = getBounds().centerX();
        float fCenterY = getBounds().centerY();
        float f = this.qg / 2.0f;
        float f2 = fCenterX - ((3.0f * f) / 4.0f);
        float f3 = fCenterX + (f / 4.0f);
        float f4 = f3 - f2;
        canvas.drawLine(f2, fCenterY + (this.s / 4.0f), f3, fCenterY - f4, this.n);
        canvas.drawLine(f2, fCenterY - (this.s / 4.0f), f3, f4 + fCenterY, this.n);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.n.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.n.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.n.getAlpha();
    }
}
