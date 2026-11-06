package com.byazt.id;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.byazt.iza.fw;
import com.byazt.iza.zo;
import com.byazt.llk.c;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 92, 1649})
public class RichTextView extends TextView implements fw {
    public zo hw;
    public c pr;

    public RichTextView(Context context) {
        super(context);
        this.hw = new zo(this);
    }

    public void setRichText(String str) {
        Spanned spannedFromHtml;
        if (Build.VERSION.SDK_INT >= 24) {
            spannedFromHtml = Html.fromHtml(str, 0);
        } else {
            spannedFromHtml = Html.fromHtml(str);
        }
        setText(spannedFromHtml);
    }

    public void pr(c cVar) {
        this.pr = cVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.pr;
        if (cVar != null) {
            int[] iArrPr = cVar.pr(i, i2);
            super.onMeasure(iArrPr[0], iArrPr[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }

    public void setBorderRadius(float f) {
        zo zoVar = this.hw;
        if (zoVar != null) {
            zoVar.pr(f);
        }
    }

    public float getBorderRadius() {
        return this.hw.pr();
    }

    public void setRipple(float f) {
        zo zoVar = this.hw;
        if (zoVar != null) {
            zoVar.hw(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getRipple() {
        return this.hw.getRipple();
    }

    public void setShine(float f) {
        zo zoVar = this.hw;
        if (zoVar != null) {
            zoVar.hn(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getShine() {
        return this.hw.getShine();
    }

    public void setStretch(float f) {
        zo zoVar = this.hw;
        if (zoVar != null) {
            zoVar.x(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getStretch() {
        return this.hw.getStretch();
    }

    public void setRubIn(float f) {
        zo zoVar = this.hw;
        if (zoVar != null) {
            zoVar.c(f);
        }
    }

    @Override // com.byazt.iza.fw
    public float getRubIn() {
        return this.hw.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.hw.pr(i);
    }
}
