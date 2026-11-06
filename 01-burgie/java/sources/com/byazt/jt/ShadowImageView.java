package com.byazt.jt;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 2100})
public class ShadowImageView extends ImageView {
    public RectF hw;
    public Paint pr;

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.hw.right != getMeasuredWidth() || this.hw.bottom != getMeasuredHeight()) {
            this.hw.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.hw;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.hw.bottom / 2.0f, this.pr);
        super.onDraw(canvas);
    }
}
