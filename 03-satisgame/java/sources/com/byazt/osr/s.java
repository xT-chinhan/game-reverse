package com.byazt.osr;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 8})
public class s extends Drawable {
    public Paint n;
    public RectF q;
    public int qg;
    public int s;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public s(int i, int i2) {
        this.s = i;
        this.qg = i2;
        Paint paint = new Paint();
        this.n = paint;
        paint.setColor(0);
        this.n.setAntiAlias(true);
        this.n.setShadowLayer(i2, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.n.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.qg;
        this.q = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.q;
        int i = this.s;
        canvas.drawRoundRect(rectF, i, i, this.n);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.n.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.n.setColorFilter(colorFilter);
    }
}
