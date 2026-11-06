package com.byazt.uy;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.byazt.vh.cd;
import com.byazt.vh.cy;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 819, 8})
public class s {
    public boolean l;
    public float n;
    public Context q;
    public float qg;
    public cy s;
    public final int w;

    public s(Context context, cy cyVar) {
        this.q = context;
        this.s = cyVar;
        this.w = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean n(cd cdVar, com.byazt.ih.s sVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = motionEvent.getX();
            this.qg = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.n) >= this.w || Math.abs(y - this.qg) >= this.w) {
                    this.l = true;
                }
            } else if (action == 3) {
                this.l = false;
            }
        } else {
            if (this.l) {
                this.l = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.n) >= this.w || Math.abs(y2 - this.qg) >= this.w) {
                this.l = false;
            } else if (cdVar != null) {
                cdVar.n(this.s, sVar, sVar);
                return true;
            }
        }
        return true;
    }
}
