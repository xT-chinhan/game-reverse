package com.bytedance.adsdk.ugeno.widget.frame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.ah;
import com.bytedance.adsdk.ugeno.ah.zb;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UGFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ah f406ms;
    private Map<Integer, zb> xr;

    public UGFrameLayout(Context context) {
        super(context);
    }

    public void setEventMap(Map<Integer, zb> map) {
        this.xr = map;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        ah ahVar = this.f406ms;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            super.onMeasure(iArrMs[0], iArrMs[1]);
        } else {
            super.onMeasure(i, i2);
        }
        ah ahVar2 = this.f406ms;
        if (ahVar2 != null) {
            ahVar2.ah();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ah ahVar = this.f406ms;
        if (ahVar != null) {
            ahVar.d();
        }
        super.onLayout(z, i, i2, i3, i4);
        ah ahVar2 = this.f406ms;
        if (ahVar2 != null) {
            ahVar2.ms(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Map<Integer, zb> map = this.xr;
        if (map == null || !map.containsKey(4)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return true;
    }

    public void ms(ah ahVar) {
        this.f406ms = ahVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ah ahVar = this.f406ms;
        if (ahVar != null) {
            ahVar.ka();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ah ahVar = this.f406ms;
        if (ahVar != null) {
            ahVar.c();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ah ahVar = this.f406ms;
        if (ahVar != null) {
            ahVar.ms(z);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ah ahVar = this.f406ms;
        if (ahVar != null) {
            ahVar.xr(i, i2, i3, i4);
        }
    }
}
