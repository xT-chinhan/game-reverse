package com.bytedance.adsdk.ugeno.swiper;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class Swiper extends BaseSwiper<ah> {
    private com.bytedance.adsdk.ugeno.ah d;

    public Swiper(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.swiper.BaseSwiper
    public View ab(int i) {
        return ((ah) this.f389ms.get(i)).ny();
    }

    public void ms(com.bytedance.adsdk.ugeno.ah ahVar) {
        this.d = ahVar;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.ah ahVar = this.d;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            super.onMeasure(iArrMs[0], iArrMs[1]);
        } else {
            super.onMeasure(i, i2);
        }
        com.bytedance.adsdk.ugeno.ah ahVar2 = this.d;
        if (ahVar2 != null) {
            ahVar2.ah();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        com.bytedance.adsdk.ugeno.ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.d();
        }
        super.onLayout(z, i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.ah ahVar2 = this.d;
        if (ahVar2 != null) {
            ahVar2.ms(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        com.bytedance.adsdk.ugeno.ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.bytedance.adsdk.ugeno.ah ahVar = this.d;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }
}
