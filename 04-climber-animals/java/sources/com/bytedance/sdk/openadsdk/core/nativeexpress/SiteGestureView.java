package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.sa;

/* JADX INFO: loaded from: classes2.dex */
public class SiteGestureView extends View {
    private long ab;
    private float ah;
    private float c;
    private float d;
    private float ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private b f2953ms;
    private sa xr;

    public SiteGestureView(Context context, sa saVar, b bVar) {
        super(context);
        this.xr = saVar;
        this.f2953ms = bVar;
        setTag(2097610717, "click");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.ah = ul.d(getContext(), motionEvent.getX());
            this.d = ul.d(getContext(), motionEvent.getY());
            this.ka = motionEvent.getRawX();
            this.c = motionEvent.getRawY();
            this.ab = System.currentTimeMillis();
            this.f2953ms.ms(motionEvent);
            if (this.xr.xr() == -1) {
                com.bytedance.sdk.component.utils.sl.ms("xdy", "nt ad");
                return false;
            }
            if (!this.f2953ms.ah()) {
                com.bytedance.sdk.component.utils.sl.ms("xdy", "un ad");
                return false;
            }
        } else {
            if (action == 1) {
                this.f2953ms.xr();
                float fD = ul.d(getContext(), motionEvent.getX());
                float fD2 = ul.d(getContext(), motionEvent.getY());
                if (this.xr.ah() == 0.0d) {
                    com.bytedance.sdk.component.utils.sl.ms("xdy", "nh g");
                    xr(-1, motionEvent);
                    return true;
                }
                float f = fD - this.ah;
                float f2 = fD2 - this.d;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (fAbs <= 3.0f && fAbs2 <= 3.0f) {
                    com.bytedance.sdk.component.utils.sl.ms("xdy", "c ad");
                    this.f2953ms.ms(motionEvent);
                    return true;
                }
                double dAh = this.xr.ah();
                int iD = this.xr.d();
                if (fAbs > fAbs2) {
                    if (fAbs > dAh) {
                        long j = iD;
                        if (com.bytedance.sdk.openadsdk.core.y.xr.ms(j, 2L) && f < 0.0f) {
                            return ms(2, motionEvent);
                        }
                        if (com.bytedance.sdk.openadsdk.core.y.xr.ms(j, 4L) && f > 0.0f) {
                            return ms(4, motionEvent);
                        }
                    }
                } else if (fAbs2 > dAh) {
                    long j2 = iD;
                    if (com.bytedance.sdk.openadsdk.core.y.xr.ms(j2, 8L) && f2 < 0.0f) {
                        return ms(8, motionEvent);
                    }
                    if (com.bytedance.sdk.openadsdk.core.y.xr.ms(j2, 16L) && f2 > 0.0f) {
                        return ms(16, motionEvent);
                    }
                }
                return false;
            }
            if (action == 3) {
                com.bytedance.sdk.component.utils.sl.ms("xdy", "gesture cancel");
            }
        }
        return true;
    }

    private boolean ms(int i, MotionEvent motionEvent) {
        if (this.xr.ms() == 1 && this.f2953ms.ms()) {
            com.bytedance.sdk.component.utils.sl.ms("xdy", i + " ad");
            this.f2953ms.ms(motionEvent);
            return false;
        }
        com.bytedance.sdk.component.utils.sl.ms("xdy", i + " site");
        xr(i, motionEvent);
        return true;
    }

    private void xr(int i, MotionEvent motionEvent) {
        int[] iArrMs = ul.ms(this);
        com.bytedance.sdk.openadsdk.core.nw.i iVarMs = new com.bytedance.sdk.openadsdk.core.nw.i.ms().ms("express_gesture_view").d(this.ka).ah(this.c).xr(motionEvent.getRawX()).ms(motionEvent.getRawY()).xr(this.ab).ah(getWidth()).d(getHeight()).ms(iArrMs == null ? 0 : iArrMs[0]).xr(iArrMs != null ? iArrMs[1] : 0).ms(true).ms(System.currentTimeMillis()).ms();
        this.xr.ms(i);
        this.f2953ms.ms(this, 1, iVarMs, this.xr);
    }
}
