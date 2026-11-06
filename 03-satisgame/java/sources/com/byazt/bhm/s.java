package com.byazt.bhm;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 8})
public class s implements View.OnTouchListener {
    public boolean fs;
    public boolean l;
    public float n;
    public float q;
    public float qg;
    public boolean rv;
    public float s;
    public com.byazt.jmk.fs w;
    public int x;

    public s(com.byazt.jmk.fs fsVar) {
        this(fsVar, 5);
    }

    public s(com.byazt.jmk.fs fsVar, int i) {
        this.x = 5;
        this.fs = true;
        this.w = fsVar;
        if (i > 0) {
            this.x = i;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.jmk.fs fsVar;
        com.byazt.jmk.fs fsVar2;
        com.byazt.jmk.fs fsVar3;
        if (this.rv) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = motionEvent.getX();
            this.qg = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.q = motionEvent.getX();
                this.s = motionEvent.getY();
                if (Math.abs(this.q - this.n) > 10.0f) {
                    this.l = true;
                }
                if (Math.abs(this.q - this.n) > 8.0f || Math.abs(this.s - this.qg) > 8.0f) {
                    this.fs = false;
                }
                int iQg = com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), Math.abs(this.q - this.n));
                if (this.q > this.n && iQg > this.x && (fsVar3 = this.w) != null) {
                    fsVar3.n();
                    this.rv = true;
                }
            }
        } else {
            if (!this.l && !this.fs) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iQg2 = com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), Math.abs(this.q - this.n));
            if (this.q > this.n && iQg2 > this.x && (fsVar2 = this.w) != null) {
                fsVar2.n();
                this.rv = true;
            }
            float fAbs = Math.abs(x - this.n);
            float fAbs2 = Math.abs(y - this.qg);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (fsVar = this.w) != null) {
                fsVar.qg();
                this.rv = true;
            }
        }
        return true;
    }
}
