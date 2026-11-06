package com.bytedance.adsdk.ugeno.ah.xr;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.c.x;
import com.umeng.analytics.pro.g;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private Context ab;
    private String c;
    private ms ch;
    private zb d;
    private zb ka;
    private boolean ny;
    private boolean x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private float f342ms = Float.MIN_VALUE;
    private float xr = Float.MIN_VALUE;
    private int ah = 0;

    public ka(Context context, zb zbVar, boolean z, boolean z2) {
        this.ab = context;
        this.d = zbVar;
        this.x = z;
        this.ny = z2;
        xr();
    }

    public ka(Context context, zb zbVar, zb zbVar2, boolean z, boolean z2) {
        this.ab = context;
        this.d = zbVar;
        this.ka = zbVar2;
        this.x = z;
        this.ny = z2;
        xr();
    }

    private void xr() {
        if (this.ny) {
            this.ch = new ms();
        }
        zb zbVar = this.d;
        if (zbVar == null) {
            return;
        }
        this.ah = zbVar.ah().optInt("slideThreshold");
        this.c = this.d.ah().optString("slideDirection");
    }

    public void ms() {
        this.f342ms = Float.MIN_VALUE;
        this.xr = Float.MIN_VALUE;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0089  */
    /* JADX WARN: Code duplicated, block: B:36:0x008b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0095  */
    /* JADX WARN: Code duplicated, block: B:40:0x009f  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:54:0x00de  */
    public boolean ms(ub ubVar, com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent, boolean z) {
        float x;
        float y;
        int iXr;
        int iXr2;
        ms msVar;
        ms msVar2 = this.ch;
        if (msVar2 != null) {
            if (msVar2.ms(motionEvent)) {
                return false;
            }
            this.ch.ms(ahVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f342ms = motionEvent.getX();
            this.xr = motionEvent.getY();
        } else if (action == 1) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.x && Math.abs(x - this.f342ms) <= 10.0f && Math.abs(y - this.xr) <= 10.0f && ubVar != null) {
                ms();
                ubVar.ms(this.ka, ahVar, ahVar);
                return true;
            }
            if (this.ah != 0 && ubVar != null) {
                ms();
                ubVar.ms(this.d, ahVar, ahVar);
                return true;
            }
            iXr = x.xr(this.ab, x - this.f342ms);
            iXr2 = x.xr(this.ab, y - this.xr);
            if (TextUtils.equals(this.c, g.R)) {
                iXr = -iXr2;
            } else if (!TextUtils.equals(this.c, "down")) {
                iXr = iXr2;
            } else if (TextUtils.equals(this.c, "left")) {
                iXr = -iXr;
            } else if (!TextUtils.equals(this.c, "right")) {
                iXr = (int) Math.abs(Math.sqrt(Math.pow(iXr, 2.0d) + Math.pow(iXr2, 2.0d)));
            }
            if (iXr >= this.ah) {
                ms();
                msVar = this.ch;
                if (msVar != null) {
                    msVar.ms(ahVar);
                }
                return false;
            }
            if (ubVar != null) {
                ms();
                ubVar.ms(this.d, ahVar, ahVar);
                return true;
            }
            ms();
        } else if (action == 3) {
            if (this.f342ms == Float.MIN_VALUE || this.xr == Float.MIN_VALUE) {
                return false;
            }
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.x) {
            }
            if (this.ah != 0) {
            }
            iXr = x.xr(this.ab, x - this.f342ms);
            iXr2 = x.xr(this.ab, y - this.xr);
            if (TextUtils.equals(this.c, g.R)) {
                iXr = -iXr2;
            } else if (!TextUtils.equals(this.c, "down")) {
                iXr = iXr2;
            } else if (TextUtils.equals(this.c, "left")) {
                iXr = -iXr;
            } else if (!TextUtils.equals(this.c, "right")) {
                iXr = (int) Math.abs(Math.sqrt(Math.pow(iXr, 2.0d) + Math.pow(iXr2, 2.0d)));
            }
            if (iXr >= this.ah) {
                ms();
                msVar = this.ch;
                if (msVar != null) {
                    msVar.ms(ahVar);
                }
                return false;
            }
            if (ubVar != null) {
                ms();
                ubVar.ms(this.d, ahVar, ahVar);
                return true;
            }
            ms();
        }
        return true;
    }
}
