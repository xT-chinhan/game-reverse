package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends Drawable {
    private float ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Paint f4091ms;
    private int xr;

    public ms(int i) {
        this.xr = i;
        Paint paint = new Paint();
        this.f4091ms = paint;
        paint.setAntiAlias(true);
        this.f4091ms.setFilterBitmap(true);
    }

    public void ms(int i) {
        this.f4091ms.setColor(i);
    }

    public void ms(float f) {
        this.f4091ms.setStrokeWidth(f);
        this.ah = f;
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
        float f = this.xr / 2.0f;
        float f2 = fCenterX - ((3.0f * f) / 4.0f);
        float f3 = fCenterX + (f / 4.0f);
        float f4 = f3 - f2;
        canvas.drawLine(f2, fCenterY + (this.ah / 4.0f), f3, fCenterY - f4, this.f4091ms);
        canvas.drawLine(f2, fCenterY - (this.ah / 4.0f), f3, f4 + fCenterY, this.f4091ms);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f4091ms.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f4091ms.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f4091ms.getAlpha();
    }
}
