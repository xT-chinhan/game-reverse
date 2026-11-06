package com.byazt.id;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.byazt.ch.c;
import com.byazt.iza.fw;
import com.byazt.iza.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 92, 891})
public class UGTextView extends TextView implements c, fw {
    public float c;
    public float fw;
    public zo hn;
    public float hw;
    public com.byazt.llk.c pr;
    public float uc;
    public float x;

    public UGTextView(Context context) {
        super(context);
        this.x = -1.0f;
        this.uc = 1.0f;
        this.fw = 0.0f;
        this.hn = new zo(this);
    }

    public void pr(com.byazt.llk.c cVar) {
        this.pr = cVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            super.onMeasure(iArrPr[0], iArrPr[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
        if (z && this.x > 0.0f) {
            pr(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.byazt.ch.c, com.byazt.iza.fw
    public float getRipple() {
        return this.hw;
    }

    public void setShine(float f) {
        zo zoVar = this.hn;
        if (zoVar != null) {
            zoVar.hn(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getShine() {
        return this.hn.getShine();
    }

    public void setStretch(float f) {
        zo zoVar = this.hn;
        if (zoVar != null) {
            zoVar.x(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getStretch() {
        return this.hn.getStretch();
    }

    public void setRubIn(float f) {
        zo zoVar = this.hn;
        if (zoVar != null) {
            zoVar.c(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getRubIn() {
        return this.hn.getRubIn();
    }

    public void setRipple(float f) {
        this.hw = f;
        zo zoVar = this.hn;
        if (zoVar != null) {
            zoVar.hw(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(canvas, this);
            this.pr.pr(canvas);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            cVar.hw(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.llk.c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(z);
        }
    }

    public void setBorderRadius(float f) {
        zo zoVar = this.hn;
        if (zoVar != null) {
            zoVar.pr(f);
        }
    }

    public float getBorderRadius() {
        return this.hn.pr();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.hn.pr(i);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.c = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.c = getTextSize();
    }

    public void setMinTextSize(float f) {
        this.x = f;
    }

    private void pr(int i, int i2) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i2 <= 0 || i <= 0 || this.c == 0.0f) {
            return;
        }
        TextPaint paint = getPaint();
        float fMax = this.c;
        int iPr = pr(text, paint, i, fMax);
        while (iPr > i2) {
            float f = this.x;
            if (fMax <= f) {
                break;
            }
            fMax = Math.max(fMax - 1.0f, f);
            iPr = pr(text, paint, i, fMax);
        }
        setTextSize(0, fMax);
        setLineSpacing(this.fw, this.uc);
    }

    private int pr(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.uc, this.fw, true).getHeight();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.uc = f2;
        this.fw = f;
    }
}
