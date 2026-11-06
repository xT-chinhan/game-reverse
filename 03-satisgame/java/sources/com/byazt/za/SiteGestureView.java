package com.byazt.za;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.gct.kc;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 1960})
public class SiteGestureView extends View {
    public float l;
    public wm n;
    public float q;
    public kc qg;
    public float s;
    public float w;
    public long x;

    public SiteGestureView(Context context, kc kcVar, wm wmVar) {
        super(context);
        this.qg = kcVar;
        this.n = wmVar;
        setTag(2097610717, "click");
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.s = com.byazt.okk.s.q(getContext(), motionEvent.getX());
            this.q = com.byazt.okk.s.q(getContext(), motionEvent.getY());
            this.l = motionEvent.getRawX();
            this.w = motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            this.n.n(motionEvent);
            if (this.qg.qg() == -1 || !this.n.s()) {
                return false;
            }
        } else if (action == 1) {
            this.n.qg();
            float fQ = com.byazt.okk.s.q(getContext(), motionEvent.getX());
            float fQ2 = com.byazt.okk.s.q(getContext(), motionEvent.getY());
            if (this.qg.s() == 0.0d) {
                qg(-1, motionEvent);
                return true;
            }
            float f = fQ - this.s;
            float f2 = fQ2 - this.q;
            float fAbs = Math.abs(f);
            float fAbs2 = Math.abs(f2);
            if (fAbs <= 3.0f && fAbs2 <= 3.0f) {
                this.n.n(motionEvent);
                return true;
            }
            double dS = this.qg.s();
            int iQ = this.qg.q();
            if (fAbs > fAbs2) {
                if (fAbs > dS) {
                    long j = iQ;
                    if (com.byazt.vzq.qg.n(j, 2L) && f < 0.0f) {
                        return n(2, motionEvent);
                    }
                    if (com.byazt.vzq.qg.n(j, 4L) && f > 0.0f) {
                        return n(4, motionEvent);
                    }
                }
            } else if (fAbs2 > dS) {
                long j2 = iQ;
                if (com.byazt.vzq.qg.n(j2, 8L) && f2 < 0.0f) {
                    return n(8, motionEvent);
                }
                if (com.byazt.vzq.qg.n(j2, 16L) && f2 > 0.0f) {
                    return n(16, motionEvent);
                }
            }
            return false;
        }
        return true;
    }

    private boolean n(int i, MotionEvent motionEvent) {
        if (this.qg.n() == 1 && this.n.n()) {
            this.n.n(motionEvent);
            return false;
        }
        qg(i, motionEvent);
        return true;
    }

    private void qg(int i, MotionEvent motionEvent) {
        int[] iArrN = com.byazt.okk.s.n(this);
        com.byazt.gct.wm wmVarN = new com.byazt.gct.wm.n().n("express_gesture_view").q(this.l).s(this.w).qg(motionEvent.getRawX()).n(motionEvent.getRawY()).qg(this.x).s(getWidth()).q(getHeight()).n(iArrN == null ? 0 : iArrN[0]).qg(iArrN != null ? iArrN[1] : 0).n(true).n(System.currentTimeMillis()).n();
        this.qg.n(i);
        this.n.n(this, 1, wmVarN, this.qg);
    }
}
