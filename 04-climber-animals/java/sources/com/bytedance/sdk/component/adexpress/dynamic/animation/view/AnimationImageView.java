package com.bytedance.sdk.component.adexpress.dynamic.animation.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.ab;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationImageView extends ImageView implements xr {
    private float ah;
    private ab c;
    private float d;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    ms f781ms;
    private float xr;

    public ab getBrickNativeValue() {
        return this.c;
    }

    public void setBrickNativeValue(ab abVar) {
        this.c = abVar;
    }

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
        this.f781ms.ms(this, f);
    }

    public AnimationImageView(Context context) {
        super(context);
        this.f781ms = new ms();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        ab abVar;
        super.onDraw(canvas);
        this.f781ms.ms(canvas, this, this);
        if (getRippleValue() == 0.0f || (abVar = this.c) == null || abVar.xr() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f781ms.ms(this, i, i2);
    }
}
