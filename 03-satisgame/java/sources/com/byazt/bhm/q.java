package com.byazt.bhm;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 5})
public class q implements View.OnTouchListener {
    public boolean cp;
    public boolean fs;
    public boolean l = true;
    public float n;
    public float q;
    public float qg;
    public com.byazt.jmk.fs rv;
    public float s;
    public int tj;
    public float w;
    public float x;

    public q(com.byazt.jmk.fs fsVar, int i, boolean z) {
        this.rv = fsVar;
        this.tj = i;
        this.cp = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.jmk.fs fsVar;
        com.byazt.jmk.fs fsVar2;
        com.byazt.jmk.fs fsVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = motionEvent.getX();
            this.qg = motionEvent.getY();
            this.w = motionEvent.getY();
            this.l = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.x = y;
                if (Math.abs(y - this.w) > 10.0f) {
                    this.fs = true;
                }
                this.q = motionEvent.getX();
                this.s = motionEvent.getY();
                if (Math.abs(this.q - this.n) > 8.0f || Math.abs(this.s - this.qg) > 8.0f) {
                    this.l = false;
                }
            }
        } else {
            if (!this.fs && !this.l) {
                return false;
            }
            if (!this.cp && (fsVar3 = this.rv) != null) {
                fsVar3.n();
            } else {
                int iQg = com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), Math.abs(this.x - this.w));
                if (this.x - this.w < 0.0f && iQg > this.tj && (fsVar2 = this.rv) != null) {
                    fsVar2.n();
                } else if (this.l && (fsVar = this.rv) != null) {
                    fsVar.n();
                }
            }
        }
        return true;
    }
}
