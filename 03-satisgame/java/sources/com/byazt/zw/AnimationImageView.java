package com.byazt.zw;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.lh.x;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 731, 733})
public class AnimationImageView extends ImageView implements qg {
    public float l;
    public n n;
    public float q;
    public float qg;
    public float s;
    public x w;

    public x getBrickNativeValue() {
        return this.w;
    }

    public void setBrickNativeValue(x xVar) {
        this.w = xVar;
    }

    @Override // com.byazt.zw.qg
    public float getShineValue() {
        return this.s;
    }

    public void setShineValue(float f) {
        this.s = f;
        postInvalidate();
    }

    @Override // com.byazt.zw.qg
    public float getRippleValue() {
        return this.qg;
    }

    public void setRippleValue(float f) {
        this.qg = f;
        postInvalidate();
    }

    @Override // com.byazt.zw.qg
    public float getMarqueeValue() {
        return this.q;
    }

    public void setMarqueeValue(float f) {
        this.q = f;
        postInvalidate();
    }

    public float getStretchValue() {
        return this.l;
    }

    public void setStretchValue(float f) {
        this.l = f;
        this.n.n(this, f);
    }

    public AnimationImageView(Context context) {
        super(context);
        this.n = new n();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        x xVar;
        super.onDraw(canvas);
        this.n.n(canvas, this, this);
        if (getRippleValue() == 0.0f || (xVar = this.w) == null || xVar.qg() <= 0) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent().getParent()).setClipChildren(false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.n.n(this, i, i2);
    }
}
