package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes2.dex */
public class d extends ms {
    private float hi;
    private float sl;
    private com.bytedance.adsdk.ugeno.ah.xr.ms u;
    private boolean zb;

    public d(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ah.ms
    public boolean ms(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.xr != null && this.xr.l() && this.u == null) {
            this.u = new com.bytedance.adsdk.ugeno.ah.xr.ms();
        }
        return ms(this.xr, (MotionEvent) objArr[0]);
    }

    public boolean ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        com.bytedance.adsdk.ugeno.ah.xr.ms msVar = this.u;
        if (msVar != null) {
            if (msVar.ms(motionEvent)) {
                return false;
            }
            this.u.ms(ahVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.hi = motionEvent.getRawX();
            this.sl = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.hi) >= 15.0f || Math.abs(rawY - this.sl) >= 15.0f) {
                    this.zb = true;
                }
            } else if (action == 3) {
                this.zb = false;
            }
        } else {
            if (this.zb) {
                this.zb = false;
                this.hi = 0.0f;
                this.sl = 0.0f;
                com.bytedance.adsdk.ugeno.ah.xr.ms msVar2 = this.u;
                if (msVar2 != null) {
                    msVar2.ms(ahVar);
                }
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.hi) >= 15.0f || Math.abs(rawY2 - this.sl) >= 15.0f) {
                this.zb = false;
                com.bytedance.adsdk.ugeno.ah.xr.ms msVar3 = this.u;
                if (msVar3 != null) {
                    msVar3.ms(ahVar);
                }
            } else if (this.f360ms != null) {
                this.f360ms.ms(ahVar, this.c, this.ah.xr());
                this.hi = 0.0f;
                this.sl = 0.0f;
                return true;
            }
        }
        return true;
    }
}
