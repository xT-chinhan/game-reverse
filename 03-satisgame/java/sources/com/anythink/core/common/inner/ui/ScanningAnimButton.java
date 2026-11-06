package com.anythink.core.common.inner.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/* JADX INFO: loaded from: classes.dex */
public class ScanningAnimButton extends Button {
    private volatile boolean a;
    private int b;

    private static void b() {
    }

    private static void c() {
    }

    public ScanningAnimButton(Context context) {
        this(context, null);
    }

    public ScanningAnimButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScanningAnimButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0;
        setGravity(17);
    }

    private void a() {
        setGravity(17);
    }

    public void startAnimation(int i) {
        this.b = i;
        if (this.a) {
            return;
        }
        this.a = true;
    }

    public void stopAnimation() {
        this.a = false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = this.b;
        if (i != 0) {
            startAnimation(i);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAnimation();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
