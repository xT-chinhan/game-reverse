package com.byazt.za;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, 86})
public class cd {
    public float cp;
    public float fs;
    public View n;
    public float qg;
    public float rv;
    public float s;
    public float tj;
    public float q = 0.0f;
    public float l = 0.0f;
    public float w = 0.0f;
    public float x = 0.0f;
    public boolean d = false;
    public boolean oa = false;
    public boolean sz = false;
    public boolean k = false;

    public cd(View view) {
        this.n = view;
    }

    public boolean n(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.q = motionEvent.getX();
            this.l = motionEvent.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        this.w = motionEvent.getX();
        this.x = motionEvent.getY();
        if (Math.abs(this.w - this.q) < 5.0f || Math.abs(this.x - this.l) < 5.0f) {
            this.k = false;
            return false;
        }
        this.k = true;
        return true;
    }

    public boolean qg(MotionEvent motionEvent) {
        this.qg = ((ViewGroup) this.n.getParent()).getWidth();
        this.s = ((ViewGroup) this.n.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.oa = false;
                this.sz = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.q;
                float f2 = y - this.l;
                this.fs = this.n.getLeft() + f;
                this.rv = this.n.getTop() + f2;
                this.tj = this.n.getRight() + f;
                this.cp = this.n.getBottom() + f2;
                if (this.fs < 0.0f) {
                    this.sz = true;
                    this.fs = 0.0f;
                    this.tj = this.n.getWidth() + 0.0f;
                }
                float f3 = this.tj;
                float f4 = this.qg;
                if (f3 > f4) {
                    this.oa = true;
                    this.tj = f4;
                    this.fs = f4 - this.n.getWidth();
                }
                if (this.rv < 0.0f) {
                    this.rv = 0.0f;
                    this.cp = 0.0f + this.n.getHeight();
                }
                float f5 = this.cp;
                float f6 = this.s;
                if (f5 > f6) {
                    this.cp = f6;
                    this.rv = f6 - this.n.getHeight();
                }
                this.n.offsetLeftAndRight((int) f);
                this.n.offsetTopAndBottom((int) f2);
                if (this.sz) {
                    View view = this.n;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.oa) {
                    View view2 = this.n;
                    view2.offsetLeftAndRight((int) (this.qg - view2.getRight()));
                }
            }
        } else {
            if (!this.k) {
                return false;
            }
            if (((int) motionEvent.getRawX()) > this.qg / 2.0f) {
                this.d = false;
                this.n.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.qg - this.n.getWidth()).start();
                View view3 = this.n;
                view3.offsetLeftAndRight((int) (this.qg - view3.getRight()));
            } else {
                this.d = true;
                this.n.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view4 = this.n;
                view4.offsetLeftAndRight(-view4.getLeft());
            }
            this.n.invalidate();
        }
        return true;
    }
}
