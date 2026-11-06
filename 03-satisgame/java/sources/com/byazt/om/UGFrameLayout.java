package com.byazt.om;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.byazt.gu.l;
import com.byazt.vh.cy;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1390, 1459})
public class UGFrameLayout extends FrameLayout {
    public l n;
    public Map<Integer, cy> qg;

    public UGFrameLayout(Context context) {
        super(context);
    }

    public void setEventMap(Map<Integer, cy> map) {
        this.qg = map;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.n;
        if (lVar != null) {
            int[] iArrN = lVar.n(i, i2);
            super.onMeasure(iArrN[0], iArrN[1]);
        } else {
            super.onMeasure(i, i2);
        }
        l lVar2 = this.n;
        if (lVar2 != null) {
            lVar2.s();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.q();
        }
        super.onLayout(z, i, i2, i3, i4);
        l lVar2 = this.n;
        if (lVar2 != null) {
            lVar2.n(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, cy> map = this.qg;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void n(l lVar) {
        this.n = lVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.l();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l lVar = this.n;
        if (lVar != null) {
            lVar.w();
        }
    }

    @Override // android.view.View
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
}
