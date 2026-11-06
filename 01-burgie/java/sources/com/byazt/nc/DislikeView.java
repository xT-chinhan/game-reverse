package com.byazt.nc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 1610})
public class DislikeView extends View {
    public Paint c;
    public Paint fw;
    public RectF hn;
    public int hw;
    public int pr;
    public int uc;
    public Paint x;
    public int zo;

    public void setRadius(int i) {
        this.uc = i;
    }

    public void setDislikeColor(int i) {
        this.fw.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.fw.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.x.setStyle(Paint.Style.STROKE);
        this.x.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.x.setStrokeWidth(i);
        this.zo = i;
    }

    public void setBgColor(int i) {
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(i);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.hn;
        int i = this.uc;
        canvas.drawRoundRect(rectF, i, i, this.c);
        RectF rectF2 = this.hn;
        int i2 = this.uc;
        canvas.drawRoundRect(rectF2, i2, i2, this.x);
        int i3 = this.pr;
        int i4 = this.hw;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.fw);
        int i5 = this.pr;
        int i6 = this.hw;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.fw);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.pr = i;
        this.hw = i2;
        int i5 = this.zo;
        this.hn = new RectF(i5, i5, this.pr - i5, this.hw - i5);
    }
}
