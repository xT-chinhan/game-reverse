package com.byazt.hj;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EditText;
import com.byazt.llk.c;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 598, 1986})
public class UGEditText extends EditText {
    public c pr;

    public UGEditText(Context context) {
        super(context);
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
}
