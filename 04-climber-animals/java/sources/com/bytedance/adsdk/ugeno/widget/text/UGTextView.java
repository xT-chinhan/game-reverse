package com.bytedance.adsdk.ugeno.widget.text;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.ah;
import com.bytedance.adsdk.ugeno.ah.ka;
import com.bytedance.adsdk.ugeno.ms.c;

/* JADX INFO: loaded from: classes2.dex */
public class UGTextView extends TextView implements ka, com.bytedance.adsdk.ugeno.ms.ka {
    private c ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f428ms;
    private float xr;

    public UGTextView(Context context) {
        super(context);
        this.ah = new c(this);
    }

    public void ms(ah ahVar) {
        this.f428ms = ahVar;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar = this.f428ms;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            super.onMeasure(iArrMs[0], iArrMs[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.f428ms;
        if (ahVar != null) {
            ahVar.ms(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ka, com.bytedance.adsdk.ugeno.ms.ka
    public float getRipple() {
        return this.xr;
    }

    public void setShine(float f) {
        c cVar = this.ah;
        if (cVar != null) {
            cVar.ah(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getShine() {
        return this.ah.getShine();
    }

    public void setStretch(float f) {
        c cVar = this.ah;
        if (cVar != null) {
            cVar.d(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getStretch() {
        return this.ah.getStretch();
    }

    public void setRubIn(float f) {
        c cVar = this.ah;
        if (cVar != null) {
            cVar.ka(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ms.ka
    public float getRubIn() {
        return this.ah.getRubIn();
    }

    public void setRipple(float f) {
        this.xr = f;
        c cVar = this.ah;
        if (cVar != null) {
            cVar.xr(f);
        }
        postInvalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ah ahVar = this.f428ms;
        if (ahVar != null) {
            ahVar.ms(canvas, this);
            this.f428ms.ms(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ah ahVar = this.f428ms;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i3);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.f428ms;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.f428ms;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.f428ms;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }

    public void setBorderRadius(float f) {
        c cVar = this.ah;
        if (cVar != null) {
            cVar.ms(f);
        }
    }

    public float getBorderRadius() {
        return this.ah.ms();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.ah.ms(i);
    }
}
