package com.byazt.ud;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.TextView;
import com.byazt.kg.fs;
import com.byazt.kg.x;
import com.byazt.vh.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 106, MediaPlayer.MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE})
public class UGTextView extends TextView implements x, l {
    public float l;
    public com.byazt.gu.l n;
    public float q;
    public float qg;
    public fs s;
    public float w;
    public float x;

    public UGTextView(Context context) {
        super(context);
        this.q = -1.0f;
        this.w = 1.0f;
        this.x = 0.0f;
        this.s = new fs(this);
    }

    public void n(com.byazt.gu.l lVar) {
        this.n = lVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            super.onMeasure(iArrN[0], iArrN[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
        }
        if (z && this.q > 0.0f) {
            n(((i3 - i) - getCompoundPaddingLeft()) - getCompoundPaddingRight(), ((i4 - i2) - getCompoundPaddingBottom()) - getCompoundPaddingTop());
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.byazt.kg.x
    public float getRipple() {
        return this.qg;
    }

    public void setShine(float f) {
        fs fsVar = this.s;
        if (fsVar != null) {
            fsVar.s(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getShine() {
        return this.s.getShine();
    }

    public void setStretch(float f) {
        fs fsVar = this.s;
        if (fsVar != null) {
            fsVar.q(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getStretch() {
        return this.s.getStretch();
    }

    public void setRubIn(float f) {
        fs fsVar = this.s;
        if (fsVar != null) {
            fsVar.l(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getRubIn() {
        return this.s.getRubIn();
    }

    public void setRipple(float f) {
        this.qg = f;
        fs fsVar = this.s;
        if (fsVar != null) {
            fsVar.qg(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            lVar.n(canvas, this);
            this.n.n(canvas);
        }
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            lVar.qg(canvas);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.byazt.gu.l lVar = this.n;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    public void setBorderRadius(float f) {
        fs fsVar = this.s;
        if (fsVar != null) {
            fsVar.n(f);
        }
    }

    public float getBorderRadius() {
        return this.s.n();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.s.n(i);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f) {
        super.setTextSize(f);
        this.l = getTextSize();
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        this.l = getTextSize();
    }

    public void setMinTextSize(float f) {
        this.q = f;
    }

    private void n(int i, int i2) {
        CharSequence text = getText();
        if (text == null || text.length() == 0 || i2 <= 0 || i <= 0 || this.l == 0.0f) {
            return;
        }
        TextPaint paint = getPaint();
        float fMax = this.l;
        int iN = n(text, paint, i, fMax);
        while (iN > i2) {
            float f = this.q;
            if (fMax <= f) {
                break;
            }
            fMax = Math.max(fMax - 1.0f, f);
            iN = n(text, paint, i, fMax);
        }
        setTextSize(0, fMax);
        setLineSpacing(this.x, this.w);
    }

    private int n(CharSequence charSequence, TextPaint textPaint, int i, float f) {
        TextPaint textPaint2 = new TextPaint(textPaint);
        textPaint2.setTextSize(f);
        return new StaticLayout(charSequence, textPaint2, i, Layout.Alignment.ALIGN_NORMAL, this.w, this.x, true).getHeight();
    }

    @Override // android.widget.TextView
    public void setLineSpacing(float f, float f2) {
        super.setLineSpacing(f, f2);
        this.w = f2;
        this.x = f;
    }
}
