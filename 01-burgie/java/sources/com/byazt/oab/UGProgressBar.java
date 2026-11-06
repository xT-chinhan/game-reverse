package com.byazt.oab;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.llk.c;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1251, 1998})
public class UGProgressBar extends FrameLayout {
    public int c;
    public View hn;
    public View hw;
    public c pr;
    public TextView x;

    public UGProgressBar(Context context) {
        super(context);
        pr(context);
    }

    private void pr(Context context) {
        this.hw = new View(context);
        this.hn = new View(context);
        addView(this.hw);
        addView(this.hn);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hw.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.hw.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hn.getLayoutParams();
        layoutParams2.width = this.c;
        layoutParams2.gravity = 5;
        this.hn.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.x = textView;
        textView.setTextColor(-1);
        this.x.setTextSize(16.0f);
        this.x.setGravity(17);
        addView(this.x);
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hw.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.hw.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.hn.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.hn.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.x.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setText(String str) {
        this.x.setText(str);
    }

    public void setTextColor(int i) {
        this.x.setTextColor(i);
    }

    public void setProgressColor(int i) {
        this.hw.setBackgroundColor(i);
    }

    public void setProgressBgColor(int i) {
        this.hn.setBackgroundColor(i);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i;
        c cVar = this.pr;
        if (cVar != null) {
            cVar.hw(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(i, i2);
        }
        super.onMeasure(i, i2);
        this.c = pr(0, i);
    }

    private int pr(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        return i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void pr(c cVar) {
        this.pr = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = this.pr;
        if (cVar != null) {
            cVar.uc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        c cVar = this.pr;
        if (cVar != null) {
            cVar.pr(z);
        }
    }
}
