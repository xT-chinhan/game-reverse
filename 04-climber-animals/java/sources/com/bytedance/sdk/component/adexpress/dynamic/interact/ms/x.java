package com.bytedance.sdk.component.adexpress.dynamic.interact.ms;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class x implements View.OnTouchListener {
    private float ab;
    private final int ah = 10;
    private float c;
    private float d;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final com.bytedance.sdk.component.adexpress.dynamic.interact.x f862ms;
    private final boolean xr;

    public x(com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar, boolean z) {
        this.f862ms = xVar;
        this.xr = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
            this.ka = motionEvent.getY();
            Object[] objArr = new Object[3];
            Float.valueOf(this.d);
            String str = ", mStartY: " + this.ka;
        } else if (action == 1) {
            this.c = motionEvent.getX();
            this.ab = motionEvent.getY();
            Object[] objArr2 = new Object[3];
            Float.valueOf(this.c);
            String str2 = ", mEndY: " + this.ab;
            if (!this.xr && (xVar2 = this.f862ms) != null) {
                xVar2.ms();
            } else {
                float f = this.c - this.d;
                float f2 = this.ab - this.ka;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                Object[] objArr3 = new Object[2];
                Float.valueOf(fSqrt);
                float fXr = com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), Math.abs(fSqrt));
                Object[] objArr4 = new Object[5];
                Float.valueOf(fXr);
                Integer.valueOf(10);
                if (fXr > 10.0f && (xVar = this.f862ms) != null) {
                    xVar.ms();
                }
            }
        }
        return true;
    }
}
