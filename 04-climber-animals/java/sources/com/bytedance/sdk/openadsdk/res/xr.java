package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends Drawable {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Paint f4092ms;
    private int xr;

    public xr(int i) {
        this.xr = i;
        Paint paint = new Paint();
        this.f4092ms = paint;
        paint.setAntiAlias(true);
        this.f4092ms.setFilterBitmap(true);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) (((double) this.xr) * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) (((double) this.xr) * 1.3d);
    }

    public void ms(int i) {
        this.f4092ms.setColor(i);
    }

    public void ms(float f) {
        this.f4092ms.setStrokeWidth(f);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.xr / 2.0f, this.f4092ms);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4092ms.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4092ms.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4092ms.getAlpha();
    }
}
