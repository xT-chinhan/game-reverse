package com.bytedance.sdk.component.adexpress.dynamic.interact.ms;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements View.OnTouchListener {
    private int ab;
    private float ah;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.x c;
    private float d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f856ms;
    private boolean ny;
    private boolean x;
    private float xr;

    public ah(com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar) {
        this(xVar, 5);
    }

    public ah(com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar, int i) {
        this.ab = 5;
        this.x = true;
        this.c = xVar;
        if (i > 0) {
            this.ab = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar3;
        if (this.ny) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f856ms = motionEvent.getX();
            this.xr = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.d = motionEvent.getX();
                this.ah = motionEvent.getY();
                if (Math.abs(this.d - this.f856ms) > 10.0f) {
                    this.ka = true;
                }
                if (Math.abs(this.d - this.f856ms) > 8.0f || Math.abs(this.ah - this.xr) > 8.0f) {
                    this.x = false;
                }
                int iXr = com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), Math.abs(this.d - this.f856ms));
                if (this.d > this.f856ms && iXr > this.ab && (xVar3 = this.c) != null) {
                    xVar3.ms();
                    this.ny = true;
                }
            }
        } else {
            if (!this.ka && !this.x) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iXr2 = com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), Math.abs(this.d - this.f856ms));
            if (this.d > this.f856ms && iXr2 > this.ab && (xVar2 = this.c) != null) {
                xVar2.ms();
                this.ny = true;
            }
            float fAbs = Math.abs(x - this.f856ms);
            float fAbs2 = Math.abs(y - this.xr);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (xVar = this.c) != null) {
                xVar.xr();
                this.ny = true;
            }
        }
        return true;
    }
}
