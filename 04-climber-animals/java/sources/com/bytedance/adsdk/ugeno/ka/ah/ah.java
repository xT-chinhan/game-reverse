package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tapsdk.tapad.constants.Constants;
import com.umeng.analytics.pro.g;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends ms {
    private float hi;
    private float sl;
    private String u;
    private com.bytedance.adsdk.ugeno.ah.xr.ms ub;
    private int zb;

    public ah(Context context) {
        super(context);
        this.zb = 0;
        this.u = g.R;
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ah.ms
    public boolean ms(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.ka != null) {
            this.u = TextUtils.isEmpty(this.ka.get("direction")) ? Constants.e.c : this.ka.get("direction");
            this.zb = com.bytedance.adsdk.ugeno.c.ah.ms(this.ka.get("distance"), 0);
        }
        if (this.xr != null && this.xr.l() && this.ub == null) {
            this.ub = new com.bytedance.adsdk.ugeno.ah.xr.ms();
        }
        return ms(this.xr, (MotionEvent) objArr[0]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x008c  */
    private boolean ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        byte b;
        com.bytedance.adsdk.ugeno.ah.xr.ms msVar = this.ub;
        if (msVar != null) {
            if (msVar.ms(motionEvent)) {
                return false;
            }
            this.ub.ms(ahVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.hi = motionEvent.getX();
            this.sl = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (this.zb == 0 && this.f360ms != null) {
                this.f360ms.ms(ahVar, this.c, this.ah.xr());
                return true;
            }
            int iXr = com.bytedance.adsdk.ugeno.c.x.xr(this.ch, x - this.hi);
            int iXr2 = com.bytedance.adsdk.ugeno.c.x.xr(this.ch, y - this.sl);
            switch (this.u) {
                case "up":
                    b = 0;
                    break;
                case "all":
                    b = 4;
                    break;
                case "down":
                    b = 1;
                    break;
                case "left":
                    b = 2;
                    break;
                case "right":
                    b = 3;
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                iXr = -iXr2;
            } else if (b == 1) {
                iXr = iXr2;
            } else if (b == 2) {
                iXr = -iXr;
            } else if (b != 3) {
                iXr = (int) Math.abs(Math.sqrt(Math.pow(iXr, 2.0d) + Math.pow(iXr2, 2.0d)));
            }
            if (iXr >= this.zb) {
                if (this.f360ms != null) {
                    this.hi = 0.0f;
                    this.sl = 0.0f;
                    this.f360ms.ms(ahVar, this.c, this.ah.xr());
                    return true;
                }
            } else {
                com.bytedance.adsdk.ugeno.ah.xr.ms msVar2 = this.ub;
                if (msVar2 != null) {
                    msVar2.ms(ahVar);
                }
                return false;
            }
        }
        return true;
    }
}
