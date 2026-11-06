package com.bytedance.adsdk.ugeno.ah.xr;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    private zb ah;
    private final int c;
    private Context d;
    private boolean ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f340ms;
    private float xr;

    public ah(Context context, zb zbVar) {
        this.d = context;
        this.ah = zbVar;
        this.c = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean ms(ub ubVar, com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f340ms = motionEvent.getX();
            this.xr = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.f340ms) >= this.c || Math.abs(y - this.xr) >= this.c) {
                    this.ka = true;
                }
            } else if (action == 3) {
                this.ka = false;
            }
        } else {
            if (this.ka) {
                this.ka = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.f340ms) >= this.c || Math.abs(y2 - this.xr) >= this.c) {
                this.ka = false;
            } else if (ubVar != null) {
                ubVar.ms(this.ah, ahVar, ahVar);
                return true;
            }
        }
        return true;
    }
}
