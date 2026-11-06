package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends Drawable {
    private int ah;
    private RectF d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Paint f841ms;
    private int xr;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public ah(int i, int i2) {
        this.ah = i;
        this.xr = i2;
        Paint paint = new Paint();
        this.f841ms = paint;
        paint.setColor(0);
        this.f841ms.setAntiAlias(true);
        this.f841ms.setShadowLayer(i2, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.f841ms.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.xr;
        this.d = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.d;
        int i = this.ah;
        canvas.drawRoundRect(rectF, i, i, this.f841ms);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f841ms.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f841ms.setColorFilter(colorFilter);
    }
}
