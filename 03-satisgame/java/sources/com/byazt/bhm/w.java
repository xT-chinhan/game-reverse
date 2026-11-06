package com.byazt.bhm;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 13})
public class w implements View.OnTouchListener {
    public static int s = 10;
    public com.byazt.jmk.fs l;
    public float n;
    public boolean q;
    public float qg;

    public w(com.byazt.jmk.fs fsVar) {
        this.l = fsVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = motionEvent.getX();
            this.qg = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.n) >= s || Math.abs(y - this.qg) >= s) {
                    this.q = true;
                }
            } else if (action == 3) {
                this.q = false;
            }
        } else {
            if (this.q) {
                this.q = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.n) >= s || Math.abs(y2 - this.qg) >= s) {
                this.q = false;
            } else {
                com.byazt.jmk.fs fsVar = this.l;
                if (fsVar != null) {
                    fsVar.n();
                }
            }
        }
        return true;
    }
}
