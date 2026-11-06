package com.bytedance.sdk.component.adexpress.dynamic.interact.ms;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class d implements View.OnTouchListener {
    private float ab;
    private float ah;
    private float c;
    private int ch;
    private float d;
    private boolean hi;
    private boolean ka = true;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f858ms;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.x ny;
    private boolean x;
    private float xr;

    public d(com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar, int i, boolean z) {
        this.ny = xVar;
        this.ch = i;
        this.hi = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f858ms = motionEvent.getX();
            this.xr = motionEvent.getY();
            this.c = motionEvent.getY();
            this.ka = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.ab = y;
                if (Math.abs(y - this.c) > 10.0f) {
                    this.x = true;
                }
                this.d = motionEvent.getX();
                this.ah = motionEvent.getY();
                if (Math.abs(this.d - this.f858ms) > 8.0f || Math.abs(this.ah - this.xr) > 8.0f) {
                    this.ka = false;
                }
            }
        } else {
            if (!this.x && !this.ka) {
                return false;
            }
            if (!this.hi && (xVar3 = this.ny) != null) {
                xVar3.ms();
            } else {
                int iXr = com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), Math.abs(this.ab - this.c));
                if (this.ab - this.c < 0.0f && iXr > this.ch && (xVar2 = this.ny) != null) {
                    xVar2.ms();
                } else if (this.ka && (xVar = this.ny) != null) {
                    xVar.ms();
                }
            }
        }
        return true;
    }
}
