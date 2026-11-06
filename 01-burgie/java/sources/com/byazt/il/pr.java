package com.byazt.il;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2238, 37})
public class pr extends Drawable {
    public float hn;
    public int hw;
    public Paint pr;

    public pr(int i) {
        this.hw = i;
        Paint paint = new Paint();
        this.pr = paint;
        paint.setAntiAlias(true);
        this.pr.setFilterBitmap(true);
    }

    public void pr(int i) {
        this.pr.setColor(i);
    }

    public void pr(float f) {
        this.pr.setStrokeWidth(f);
        this.hn = f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.hw) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.hw) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fCenterX = getBounds().centerX();
        float fCenterY = getBounds().centerY();
        float f = this.hw / 2.0f;
        float f2 = fCenterX - ((3.0f * f) / 4.0f);
        float f3 = fCenterX + (f / 4.0f);
        float f4 = f3 - f2;
        canvas.drawLine(f2, fCenterY + (this.hn / 4.0f), f3, fCenterY - f4, this.pr);
        canvas.drawLine(f2, fCenterY - (this.hn / 4.0f), f3, f4 + fCenterY, this.pr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.pr.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.pr.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.pr.getAlpha();
    }
}
