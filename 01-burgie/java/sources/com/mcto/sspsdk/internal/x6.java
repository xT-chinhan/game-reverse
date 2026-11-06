package com.mcto.sspsdk.internal;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;

/* JADX INFO: loaded from: classes2.dex */
public final class x6 extends ReplacementSpan {
    public final int a = -1;
    public final int b = -8277;
    public final int c = 2;
    public final float d;

    public x6(float f) {
        this.d = f;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        LinearGradient linearGradient;
        Shader shader = paint.getShader();
        float textSize = paint.getTextSize();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        paint.setTextSize(this.d);
        int i6 = (i4 + fontMetricsInt.descent) - paint.getFontMetricsInt().descent;
        float fMeasureText = paint.measureText(charSequence, i, i2);
        if (this.c == 1) {
            float f2 = i6;
            linearGradient = new LinearGradient(f, f2, f + fMeasureText, f2, this.a, this.b, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(f, i3, f, i5, this.a, this.b, Shader.TileMode.CLAMP);
        }
        paint.setShader(linearGradient);
        canvas.drawText(charSequence, i, i2, f, i6, paint);
        paint.setShader(shader);
        paint.setTextSize(textSize);
    }

    @Override // android.text.style.ReplacementSpan
    public final int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
        paint.setTextSize(this.d);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return (int) paint.measureText(charSequence, i, i2);
    }
}
