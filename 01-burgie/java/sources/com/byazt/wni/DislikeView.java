package com.byazt.wni;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.byazt.ik.hn;
import com.byazt.llk.c;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1241, 1610})
public class DislikeView extends View {
    public int aj;
    public Paint c;
    public float fw;
    public int hn;
    public int hw;
    public c pr;
    public Paint uc;
    public RectF x;
    public Paint zo;

    public DislikeView(Context context) {
        super(context);
        pr();
    }

    private void pr() {
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.zo = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.uc = paint3;
        paint3.setAntiAlias(true);
        setBackgroundColor(0);
    }

    public void setRadius(float f) {
        this.fw = f;
    }

    public void setDislikeColor(int i) {
        this.zo.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.zo.setStrokeWidth(i);
    }

    public void setStrokeColor(int i) {
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.c.setStrokeWidth(i);
        this.aj = i;
    }

    public void setBgColor(int i) {
        this.uc.setStyle(Paint.Style.FILL);
        this.uc.setColor(i);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.pr;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            super.onMeasure(iArrPr[0], iArrPr[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(0);
        RectF rectF = this.x;
        float f = this.fw;
        canvas.drawRoundRect(rectF, f, f, this.uc);
        RectF rectF2 = this.x;
        float f2 = this.fw;
        canvas.drawRoundRect(rectF2, f2, f2, this.c);
        int i = this.hw;
        int i2 = this.hn;
        canvas.drawLine(i * 0.3f, i2 * 0.3f, i * 0.7f, i2 * 0.7f, this.zo);
        int i3 = this.hw;
        int i4 = this.hn;
        canvas.drawLine(i3 * 0.7f, i4 * 0.3f, i3 * 0.3f, i4 * 0.7f, this.zo);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.hw = i;
        this.hn = i2;
        int i5 = this.aj;
        this.x = new RectF(i5, i5, this.hw - i5, this.hn - i5);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }

    public void pr(hn hnVar) {
        this.pr = hnVar;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(z);
        }
    }
}
