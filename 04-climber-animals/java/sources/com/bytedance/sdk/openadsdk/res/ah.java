package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends Drawable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Paint f4085ms;
    private int xr;

    public ah(int i) {
        this.xr = i;
        Paint paint = new Paint();
        this.f4085ms = paint;
        paint.setAntiAlias(true);
        this.f4085ms.setFilterBitmap(true);
    }

    public void ms(int i) {
        this.f4085ms.setColor(i);
    }

    public void ms(float f) {
        this.f4085ms.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.xr) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.xr) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float fCenterX = getBounds().centerX();
        float fCenterY = getBounds().centerY();
        float f = ((this.xr / 2.0f) * 3.0f) / 4.0f;
        float f2 = fCenterX - f;
        float f3 = fCenterY - f;
        float f4 = fCenterX + f;
        float f5 = fCenterY + f;
        canvas.drawLine(f2, f3, f4, f5, this.f4085ms);
        canvas.drawLine(f4, f3, f2, f5, this.f4085ms);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4085ms.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4085ms.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4085ms.getAlpha();
    }
}
