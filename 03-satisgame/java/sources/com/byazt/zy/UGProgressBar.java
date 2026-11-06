package com.byazt.zy;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.gu.l;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1601, 2219})
public class UGProgressBar extends FrameLayout {
    public int l;
    public l n;
    public TextView q;
    public View qg;
    public View s;

    public UGProgressBar(Context context) {
        super(context);
        n(context);
    }

    private void n(Context context) {
        this.qg = new View(context);
        this.s = new View(context);
        addView(this.qg);
        addView(this.s);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qg.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.qg.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams2.width = this.l;
        layoutParams2.gravity = 5;
        this.s.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.q = textView;
        textView.setTextColor(-1);
        this.q.setTextSize(16.0f);
        this.q.setGravity(17);
        addView(this.q);
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qg.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.qg.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.s.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.s.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.q.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setText(String str) {
        this.q.setText(str);
    }

    public void setTextColor(int i) {
        this.q.setTextColor(i);
    }

    public void setProgressColor(int i) {
        this.qg.setBackgroundColor(i);
    }

    public void setProgressBgColor(int i) {
        this.s.setBackgroundColor(i);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = i;
        l lVar = this.n;
        if (lVar != null) {
            lVar.qg(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2);
        }
        super.onMeasure(i, i2);
        this.l = n(0, i);
    }

    private int n(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        return mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        l lVar = this.n;
        if (lVar != null) {
            lVar.n(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
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
}
