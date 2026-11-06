package com.byazt.at;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.byazt.gu.l;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 887, 1756})
public class DislikeView extends View {
    public Paint fs;
    public Paint l;
    public l n;
    public RectF q;
    public int qg;
    public int rv;
    public int s;
    public Paint w;
    public float x;

    public DislikeView(Context context) {
        super(context);
        n();
    }

    private void n() {
        Paint paint = new Paint();
        this.l = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.fs = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.w = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    public void setRadius(float f) {
        this.x = f;
    }

    public void setDislikeColor(int i) {
        this.fs.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.fs.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.l.setStyle(Paint.Style.STROKE);
        this.l.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.l.setStrokeWidth(i);
        this.rv = i;
    }

    public void setBgColor(int i) {
        this.w.setStyle(Paint.Style.FILL);
        this.w.setColor(i);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.n;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            super.onMeasure(iArrN[0], iArrN[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.q;
        float f = this.x;
        canvas.drawRoundRect(rectF, f, f, this.w);
        RectF rectF2 = this.q;
        float f2 = this.x;
        canvas.drawRoundRect(rectF2, f2, f2, this.l);
        int i = this.qg;
        int i2 = this.s;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.fs);
        int i3 = this.qg;
        int i4 = this.s;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.fs);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.qg = i;
        this.s = i2;
        int i5 = this.rv;
        this.q = new RectF(i5, i5, this.qg - i5, this.s - i5);
        l lVar = this.n;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    public void n(s sVar) {
        this.n = sVar;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(z);
        }
    }
}
