package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowImageView extends ImageView {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Paint f4292ms;
    private RectF xr;

    public ShadowImageView(Context context) {
        super(context);
        ms();
    }

    private void ms() {
        Paint paint = new Paint();
        this.f4292ms = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4292ms.setColor(Color.parseColor("#99333333"));
        this.f4292ms.setAntiAlias(true);
        this.f4292ms.setStrokeWidth(0.0f);
        this.xr = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.xr.right == getMeasuredWidth() && this.xr.bottom == getMeasuredHeight()) {
            return;
        }
        this.xr.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF = this.xr;
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.xr.bottom / 2.0f, this.f4292ms);
        super.onDraw(canvas);
    }
}
