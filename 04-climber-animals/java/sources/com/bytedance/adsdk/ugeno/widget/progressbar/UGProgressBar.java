package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.ah;

/* JADX INFO: loaded from: classes2.dex */
public class UGProgressBar extends FrameLayout {
    private View ah;
    private TextView d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f422ms;
    private View xr;

    public UGProgressBar(Context context) {
        super(context);
        ms(context);
    }

    private void ms(Context context) {
        this.xr = new View(context);
        this.ah = new View(context);
        addView(this.xr);
        addView(this.ah);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.xr.getLayoutParams();
        layoutParams.width = 0;
        layoutParams.height = -1;
        layoutParams.gravity = 3;
        this.xr.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ah.getLayoutParams();
        layoutParams2.width = this.ka;
        layoutParams2.gravity = 5;
        this.ah.setLayoutParams(layoutParams2);
        TextView textView = new TextView(context);
        this.d = textView;
        textView.setTextColor(-1);
        this.d.setTextSize(16.0f);
        this.d.setGravity(17);
        addView(this.d);
    }

    public void setProgress(float f) {
        int width = getWidth();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.xr.getLayoutParams();
        float f2 = width;
        float f3 = (f / 100.0f) * f2;
        layoutParams.width = (int) f3;
        this.xr.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ah.getLayoutParams();
        layoutParams2.width = (int) (f2 - f3);
        this.ah.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.d.getLayoutParams();
        layoutParams3.width = width;
        layoutParams3.gravity = 17;
        requestLayout();
    }

    public void setText(String str) {
        this.d.setText(str);
    }

    public void setTextColor(int i) {
        this.d.setTextColor(i);
    }

    public void setProgressColor(int i) {
        this.xr.setBackgroundColor(i);
    }

    public void setProgressBgColor(int i) {
        this.ah.setBackgroundColor(i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.ka = i;
        ah ahVar = this.f422ms;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar = this.f422ms;
        if (ahVar != null) {
            ahVar.ms(i, i2);
        }
        super.onMeasure(i, i2);
        this.ka = ms(0, i);
    }

    private int ms(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            return size;
        }
        return mode == Integer.MIN_VALUE ? Math.min(i, size) : i;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.f422ms;
        if (ahVar != null) {
            ahVar.ms(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void ms(ah ahVar) {
        this.f422ms = ahVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.f422ms;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.f422ms;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.f422ms;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }
}
