package com.mcto.sspsdk.internal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: loaded from: classes2.dex */
public final class x3 extends ImageSpan {
    public x3(Drawable drawable) {
        super(drawable, 1);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        canvas.translate(f, (((fontMetrics.descent + fontMetrics.ascent) / 2.0f) + i4) - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Rect bounds = getDrawable().getBounds();
        float fHeight = bounds.height();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = fontMetrics.descent;
        float f2 = fontMetrics.ascent;
        if (fontMetricsInt != null) {
            int i3 = (int) (((f + f2) / 2.0f) - (fHeight / 2.0f));
            fontMetricsInt.top = i3;
            fontMetricsInt.ascent = i3;
            int i4 = (int) (fHeight + i3);
            fontMetricsInt.bottom = i4;
            fontMetricsInt.descent = i4;
        }
        return bounds.right;
    }
}
