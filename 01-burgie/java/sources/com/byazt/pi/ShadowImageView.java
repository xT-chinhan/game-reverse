package com.byazt.pi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;
import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, 2100})
public class ShadowImageView extends ImageView {
    public RectF hw;
    public Paint pr;

    public ShadowImageView(Context context) {
        super(context);
        pr();
    }

    private void pr() {
        Paint paint = new Paint();
        this.pr = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.pr.setColor(Color.parseColor("#99333333"));
        this.pr.setAntiAlias(true);
        this.pr.setStrokeWidth(0.0f);
        this.hw = new RectF();
    }

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
