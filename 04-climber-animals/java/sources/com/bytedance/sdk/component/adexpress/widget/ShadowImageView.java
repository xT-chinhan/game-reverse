package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowImageView extends ImageView {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Paint f965ms;
    private RectF xr;

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
        canvas.drawRoundRect(rectF, rectF.right / 2.0f, this.xr.bottom / 2.0f, this.f965ms);
        super.onDraw(canvas);
    }
}
