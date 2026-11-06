package com.byazt.ud;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Html;
import android.widget.TextView;
import com.byazt.gu.l;
import com.byazt.kg.fs;
import com.byazt.kg.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 106, 1808})
public class RichTextView extends TextView implements x {
    public l n;
    public fs qg;

    public RichTextView(Context context) {
        super(context);
        this.qg = new fs(this);
    }

    public void setRichText(String str) {
        setText(Html.fromHtml(str, 0));
    }

    public void n(l lVar) {
        this.n = lVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.n;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            super.onMeasure(iArrN[0], iArrN[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l lVar = this.n;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    public void setBorderRadius(float f) {
        fs fsVar = this.qg;
        if (fsVar != null) {
            fsVar.n(f);
        }
    }

    public float getBorderRadius() {
        return this.qg.n();
    }

    public void setRipple(float f) {
        fs fsVar = this.qg;
        if (fsVar != null) {
            fsVar.qg(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getRipple() {
        return this.qg.getRipple();
    }

    public void setShine(float f) {
        fs fsVar = this.qg;
        if (fsVar != null) {
            fsVar.s(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getShine() {
        return this.qg.getShine();
    }

    public void setStretch(float f) {
        fs fsVar = this.qg;
        if (fsVar != null) {
            fsVar.q(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getStretch() {
        return this.qg.getStretch();
    }

    public void setRubIn(float f) {
        fs fsVar = this.qg;
        if (fsVar != null) {
            fsVar.l(f);
        }
    }

    @Override // com.byazt.kg.x
    public float getRubIn() {
        return this.qg.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.qg.n(i);
    }
}
