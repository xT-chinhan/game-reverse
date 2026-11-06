package com.smartdigimkt.sdk.basead.ui.simpleview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.smartdigimkt.g2.b;

/* JADX INFO: loaded from: classes3.dex */
public class SimpleCircleView extends View {
    public final Paint a;
    public ValueAnimator b;

    public SimpleCircleView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        canvas.drawCircle(width, height, Math.min(width, height), this.a);
    }

    public SimpleCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(1711276032);
        paint.setAntiAlias(true);
        post(new b(this));
    }
}
