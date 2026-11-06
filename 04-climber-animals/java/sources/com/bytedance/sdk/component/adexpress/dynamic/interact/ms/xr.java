package com.bytedance.sdk.component.adexpress.dynamic.interact.ms;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements View.OnTouchListener {
    private long ah;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.x c;
    private boolean d;
    private InteractViewContainer ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f863ms;
    private float xr;

    public xr(InteractViewContainer interactViewContainer, com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar) {
        this.ka = interactViewContainer;
        this.c = xVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.ah = System.currentTimeMillis();
            this.f863ms = motionEvent.getX();
            this.xr = motionEvent.getY();
            this.ka.ka();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.f863ms) >= com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), 10.0f) || Math.abs(y - this.xr) >= com.bytedance.sdk.component.adexpress.d.x.ms(com.bytedance.sdk.component.adexpress.d.getContext(), 10.0f)) {
                    this.d = true;
                    this.ka.c();
                }
            }
        } else {
            if (this.d) {
                return false;
            }
            if (System.currentTimeMillis() - this.ah >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.interact.x xVar = this.c;
                if (xVar != null) {
                    xVar.ms();
                }
            } else {
                this.ka.c();
            }
        }
        return true;
    }
}
