package com.bytedance.sdk.component.adexpress.dynamic.interact.ms;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class c implements View.OnTouchListener {
    private static int ah = 10;
    private boolean d;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.x ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f857ms;
    private float xr;

    public c(com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar) {
        this.ka = xVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f857ms = motionEvent.getX();
            this.xr = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.f857ms) >= ah || Math.abs(y - this.xr) >= ah) {
                    this.d = true;
                }
            } else if (action == 3) {
                this.d = false;
            }
        } else {
            if (this.d) {
                this.d = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.f857ms) >= ah || Math.abs(y2 - this.xr) >= ah) {
                this.d = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar = this.ka;
                if (xVar != null) {
                    xVar.ms();
                }
            }
        }
        return true;
    }
}
