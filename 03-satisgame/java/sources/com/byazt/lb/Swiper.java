package com.byazt.lb;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.byazt.gu.l;
import com.byazt.ih.s;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 766, 1612})
public class Swiper extends BaseSwiper<s> {
    public l q;

    public Swiper(Context context) {
        super(context);
    }

    @Override // com.byazt.lb.BaseSwiper
    public View cp(int i) {
        return ((s) this.n.get(i)).rv();
    }

    public void n(l lVar) {
        this.q = lVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.q;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            super.onMeasure(iArrN[0], iArrN[1]);
        } else {
            super.onMeasure(i, i2);
        }
        l lVar2 = this.q;
        if (lVar2 != null) {
            lVar2.s();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.q;
        if (lVar != null) {
            lVar.q();
        }
        super.onLayout(z, i, i2, i3, i4);
        l lVar2 = this.q;
        if (lVar2 != null) {
            lVar2.n(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.q;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.q;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        l lVar = this.q;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        l lVar = this.q;
        if (lVar != null) {
            lVar.n(z);
        }
    }
}
