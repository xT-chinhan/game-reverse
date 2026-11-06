package com.bytedance.adsdk.ugeno.widget.input;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EditText;
import com.bytedance.adsdk.ugeno.ah;

/* JADX INFO: loaded from: classes2.dex */
public class UGEditText extends EditText {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f418ms;

    public UGEditText(Context context) {
        super(context);
    }

    public void ms(ah ahVar) {
        this.f418ms = ahVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar = this.f418ms;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            super.onMeasure(iArrMs[0], iArrMs[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.f418ms;
        if (ahVar != null) {
            ahVar.ms(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.f418ms;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.f418ms;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.f418ms;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ah ahVar = this.f418ms;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }
}
