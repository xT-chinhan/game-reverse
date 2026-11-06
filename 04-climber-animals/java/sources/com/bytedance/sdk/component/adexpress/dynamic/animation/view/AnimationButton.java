package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationButton extends TextView implements xr {
    private float ah;
    private float d;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ms f780ms;
    private float xr;

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xr
    public float getShineValue() {
        return this.ah;
    }

    public void setShineValue(float f) {
        this.ah = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xr
    public float getRippleValue() {
        return this.xr;
    }

    public void setRippleValue(float f) {
        this.xr = f;
        postInvalidate();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.view.xr
    public float getMarqueeValue() {
        return this.d;
    }

    public void setMarqueeValue(float f) {
        this.d = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.ka;
    }

    public void setStretchValue(float f) {
        this.ka = f;
        this.f780ms.ms(this, f);
    }

    public AnimationButton(Context context) {
        super(context);
        this.f780ms = new ms();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f780ms.ms(canvas, this, this);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f780ms.ms(this, i, i2);
    }
}
