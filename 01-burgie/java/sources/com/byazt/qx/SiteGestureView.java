package com.byazt.qx;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.hg.mw;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 1432})
public class SiteGestureView extends View {
    public float c;
    public long fw;
    public float hn;
    public mw hw;
    public ny pr;
    public float uc;
    public float x;

    public SiteGestureView(Context context, mw mwVar, ny nyVar) {
        super(context);
        this.hw = mwVar;
        this.pr = nyVar;
        setTag(2097610717, "click");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:52:0x0108 A[RETURN] */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.hn = er.x(getContext(), motionEvent.getX());
                this.x = er.x(getContext(), motionEvent.getY());
                this.c = motionEvent.getRawX();
                this.uc = motionEvent.getRawY();
                this.fw = System.currentTimeMillis();
                this.pr.pr(motionEvent);
                if (this.hw.hw() != -1 && this.pr.hn()) {
                    return true;
                }
                return false;
            case 1:
                this.pr.hw();
                float fX = er.x(getContext(), motionEvent.getX());
                float fX2 = er.x(getContext(), motionEvent.getY());
                if (this.hw.hn() == 0.0d) {
                    hw(-1, motionEvent);
                    return true;
                }
                float f = fX - this.hn;
                float f2 = fX2 - this.x;
                float fAbs = Math.abs(f);
                float fAbs2 = Math.abs(f2);
                if (fAbs <= 3.0f && fAbs2 <= 3.0f) {
                    this.pr.pr(motionEvent);
                    return true;
                }
                double dHn = this.hw.hn();
                int iX = this.hw.x();
                if (fAbs > fAbs2) {
                    if (fAbs > dHn) {
                        long j = iX;
                        if (com.byazt.ns.hw.pr(j, 2L) && f < 0.0f) {
                            return pr(2, motionEvent);
                        }
                        if (com.byazt.ns.hw.pr(j, 4L) && f > 0.0f) {
                            return pr(4, motionEvent);
                        }
                    }
                } else if (fAbs2 > dHn) {
                    long j2 = iX;
                    if (com.byazt.ns.hw.pr(j2, 8L) && f2 < 0.0f) {
                        return pr(8, motionEvent);
                    }
                    if (com.byazt.ns.hw.pr(j2, 16L) && f2 > 0.0f) {
                        return pr(16, motionEvent);
                    }
                }
                return false;
            default:
                return true;
        }
    }

    private boolean pr(int i, MotionEvent motionEvent) {
        if (this.hw.pr() == 1 && this.pr.pr()) {
            this.pr.pr(motionEvent);
            return false;
        }
        hw(i, motionEvent);
        return true;
    }

    private void hw(int i, MotionEvent motionEvent) {
        int[] iArrPr = er.pr(this);
        com.byazt.hg.fo foVarPr = new com.byazt.hg.fo.pr().pr("express_gesture_view").x(this.c).hn(this.uc).hw(motionEvent.getRawX()).pr(motionEvent.getRawY()).hw(this.fw).hn(getWidth()).x(getHeight()).pr(iArrPr == null ? 0 : iArrPr[0]).hw(iArrPr != null ? iArrPr[1] : 0).pr(true).pr(System.currentTimeMillis()).pr();
        this.hw.pr(i);
        this.pr.pr(this, 1, foVarPr, this.hw);
    }
}
