package com.smartdigimkt.sdk.basead.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes3.dex */
public class AutoResizeTextView extends TextView {
    public final TextPaint a;
    public float b;
    public float c;
    public boolean d;
    public boolean e;

    public AutoResizeTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 1.0f;
        this.c = 0.0f;
        this.d = false;
        this.e = false;
        this.a = new TextPaint();
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        if (this.e) {
            return;
        }
        if (!this.d) {
            super.onDraw(canvas);
            return;
        }
        CharSequence text = getText();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        if (width == 0 || height == 0 || TextUtils.isEmpty(text)) {
            return;
        }
        this.e = true;
        int textSize = (int) getTextSize();
        while (textSize >= 5) {
            this.a.setTextSize(textSize);
            int iMeasureText = (int) this.a.measureText(text, 0, text.length());
            int height2 = new StaticLayout(text, this.a, width, Layout.Alignment.ALIGN_NORMAL, this.b, this.c, true).getHeight();
            if (iMeasureText < width && height2 < height) {
                break;
            } else {
                textSize--;
            }
        }
        setTextSize(0, textSize);
        this.e = false;
        this.d = false;
        invalidate();
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.d = true;
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        this.d = true;
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.b = f2;
        this.c = f;
    }

    public AutoResizeTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 1.0f;
        this.c = 0.0f;
        this.d = false;
        this.e = false;
        this.a = new TextPaint();
    }

    public AutoResizeTextView(Context context) {
        super(context);
        this.b = 1.0f;
        this.c = 0.0f;
        this.d = false;
        this.e = false;
        this.a = new TextPaint();
    }
}
