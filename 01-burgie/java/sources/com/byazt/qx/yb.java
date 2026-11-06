package com.byazt.qx;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class yb {
    public float aj;
    public float hn;
    public float hw;
    public View pr;
    public float vk;
    public float w;
    public float zo;
    public float x = 0.0f;
    public float c = 0.0f;
    public float uc = 0.0f;
    public float fw = 0.0f;
    public boolean k = false;
    public boolean m = false;
    public boolean g = false;
    public boolean ho = false;

    public yb(View view) {
        this.pr = view;
    }

    public boolean pr(MotionEvent motionEvent) {
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.x = motionEvent.getX();
                this.c = motionEvent.getY();
                return false;
            case 1:
            default:
                return false;
            case 2:
                this.uc = motionEvent.getX();
                this.fw = motionEvent.getY();
                if (Math.abs(this.uc - this.x) < 5.0f || Math.abs(this.fw - this.c) < 5.0f) {
                    this.ho = false;
                    return false;
                }
                this.ho = true;
                return true;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean hw(MotionEvent motionEvent) {
        this.hw = ((ViewGroup) this.pr.getParent()).getWidth();
        this.hn = ((ViewGroup) this.pr.getParent()).getHeight();
        switch (motionEvent.getAction()) {
            case 0:
            case 3:
            case 4:
            case 5:
            case 6:
            default:
                return true;
            case 1:
                if (!this.ho) {
                    return false;
                }
                if (((int) motionEvent.getRawX()) > this.hw / 2.0f) {
                    this.k = false;
                    this.pr.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.hw - this.pr.getWidth()).start();
                    View view = this.pr;
                    view.offsetLeftAndRight((int) (this.hw - view.getRight()));
                } else {
                    this.k = true;
                    this.pr.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                    View view2 = this.pr;
                    view2.offsetLeftAndRight(-view2.getLeft());
                }
                this.pr.invalidate();
                return true;
            case 2:
                this.m = false;
                this.g = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.x;
                float f2 = y - this.c;
                this.zo = this.pr.getLeft() + f;
                this.aj = this.pr.getTop() + f2;
                this.vk = this.pr.getRight() + f;
                this.w = this.pr.getBottom() + f2;
                if (this.zo < 0.0f) {
                    this.g = true;
                    this.zo = 0.0f;
                    this.vk = this.pr.getWidth() + 0.0f;
                }
                float f3 = this.vk;
                float f4 = this.hw;
                if (f3 > f4) {
                    this.m = true;
                    this.vk = f4;
                    this.zo = f4 - this.pr.getWidth();
                }
                if (this.aj < 0.0f) {
                    this.aj = 0.0f;
                    this.w = 0.0f + this.pr.getHeight();
                }
                float f5 = this.w;
                float f6 = this.hn;
                if (f5 > f6) {
                    this.w = f6;
                    this.aj = f6 - this.pr.getHeight();
                }
                this.pr.offsetLeftAndRight((int) f);
                this.pr.offsetTopAndBottom((int) f2);
                if (this.g) {
                    View view3 = this.pr;
                    view3.offsetLeftAndRight(-view3.getLeft());
                }
                if (this.m) {
                    View view4 = this.pr;
                    view4.offsetLeftAndRight((int) (this.hw - view4.getRight()));
                }
                return true;
        }
    }
}
