package com.byazt.bhm;

import android.view.MotionEvent;
import android.view.View;
import com.byazt.jmk.InteractViewContainer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 26})
public class qg implements View.OnTouchListener {
    public InteractViewContainer l;
    public float n;
    public boolean q;
    public float qg;
    public long s;
    public com.byazt.jmk.fs w;

    public qg(InteractViewContainer interactViewContainer, com.byazt.jmk.fs fsVar) {
        this.l = interactViewContainer;
        this.w = fsVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.s = System.currentTimeMillis();
            this.n = motionEvent.getX();
            this.qg = motionEvent.getY();
            this.l.l();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.n) >= com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), 10.0f) || Math.abs(y - this.qg) >= com.byazt.cq.fs.n(com.byazt.twc.q.getContext(), 10.0f)) {
                    this.q = true;
                    this.l.w();
                }
            }
        } else {
            if (this.q) {
                return false;
            }
            if (System.currentTimeMillis() - this.s >= 1500) {
                com.byazt.jmk.fs fsVar = this.w;
                if (fsVar != null) {
                    fsVar.n();
                }
            } else {
                this.l.w();
            }
        }
        return true;
    }
}
