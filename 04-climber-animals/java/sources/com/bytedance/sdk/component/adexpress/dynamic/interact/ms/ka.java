package com.bytedance.sdk.component.adexpress.dynamic.interact.ms;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements View.OnTouchListener {
    private boolean ah;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.x d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f859ms;
    private float xr;

    public ka(com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar, int i) {
        this.d = xVar;
        this.ka = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f859ms = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.xr = y;
                if (Math.abs(y - this.f859ms) > 10.0f) {
                    this.ah = true;
                }
            }
        } else {
            if (!this.ah) {
                return false;
            }
            int iXr = com.bytedance.sdk.component.adexpress.d.x.xr(com.bytedance.sdk.component.adexpress.d.getContext(), Math.abs(this.xr - this.f859ms));
            if (this.xr - this.f859ms < 0.0f && iXr > this.ka && (xVar = this.d) != null) {
                xVar.ms();
                this.f859ms = 0.0f;
                this.xr = 0.0f;
                this.ah = false;
            }
        }
        return true;
    }
}
