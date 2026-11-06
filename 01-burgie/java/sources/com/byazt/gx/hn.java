package com.byazt.gx;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 20})
public class hn extends Drawable {
    public int hn;
    public int hw;
    public Paint pr;
    public RectF x;

    public hn(int i, int i2) {
        this.hn = i;
        this.hw = i2;
        Paint paint = new Paint();
        this.pr = paint;
        paint.setColor(0);
        this.pr.setAntiAlias(true);
        this.pr.setShadowLayer(i2, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
        this.pr.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.hw;
        this.x = new RectF(i + i5, i2 + i5, i3 - i5, i4 - i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.x;
        int i = this.hn;
        canvas.drawRoundRect(rectF, i, i, this.pr);
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
        return -3;
    }
}
