package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private float ah;
    private float ch;
    private float hi;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private View f2970ms;
    private float ny;
    private float x;
    private float xr;
    private float d = 0.0f;
    private float ka = 0.0f;
    private float c = 0.0f;
    private float ab = 0.0f;
    private boolean sl = false;
    private boolean zb = false;
    private boolean u = false;
    private boolean ub = false;

    public h(View view) {
        this.f2970ms = view;
    }

    public boolean ms(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.d = motionEvent.getX();
            this.ka = motionEvent.getY();
            return false;
        }
        if (action != 2) {
            return false;
        }
        this.c = motionEvent.getX();
        this.ab = motionEvent.getY();
        if (Math.abs(this.c - this.d) < 5.0f || Math.abs(this.ab - this.ka) < 5.0f) {
            this.ub = false;
            return false;
        }
        this.ub = true;
        return true;
    }

    public boolean xr(MotionEvent motionEvent) {
        this.xr = ((ViewGroup) this.f2970ms.getParent()).getWidth();
        this.ah = ((ViewGroup) this.f2970ms.getParent()).getHeight();
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                this.zb = false;
                this.u = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                float f = x - this.d;
                float f2 = y - this.ka;
                this.x = this.f2970ms.getLeft() + f;
                this.ny = this.f2970ms.getTop() + f2;
                this.ch = this.f2970ms.getRight() + f;
                this.hi = this.f2970ms.getBottom() + f2;
                if (this.x < 0.0f) {
                    this.u = true;
                    this.x = 0.0f;
                    this.ch = this.f2970ms.getWidth() + 0.0f;
                }
                float f3 = this.ch;
                float f4 = this.xr;
                if (f3 > f4) {
                    this.zb = true;
                    this.ch = f4;
                    this.x = f4 - this.f2970ms.getWidth();
                }
                if (this.ny < 0.0f) {
                    this.ny = 0.0f;
                    this.hi = 0.0f + this.f2970ms.getHeight();
                }
                float f5 = this.hi;
                float f6 = this.ah;
                if (f5 > f6) {
                    this.hi = f6;
                    this.ny = f6 - this.f2970ms.getHeight();
                }
                this.f2970ms.offsetLeftAndRight((int) f);
                this.f2970ms.offsetTopAndBottom((int) f2);
                if (this.u) {
                    View view = this.f2970ms;
                    view.offsetLeftAndRight(-view.getLeft());
                }
                if (this.zb) {
                    View view2 = this.f2970ms;
                    view2.offsetLeftAndRight((int) (this.xr - view2.getRight()));
                }
            }
        } else {
            if (!this.ub) {
                return false;
            }
            if (((int) motionEvent.getRawX()) > this.xr / 2.0f) {
                this.sl = false;
                this.f2970ms.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(this.xr - this.f2970ms.getWidth()).start();
                View view3 = this.f2970ms;
                view3.offsetLeftAndRight((int) (this.xr - view3.getRight()));
            } else {
                this.sl = true;
                this.f2970ms.animate().setInterpolator(new DecelerateInterpolator()).setDuration(300L).x(0.0f).start();
                View view4 = this.f2970ms;
                view4.offsetLeftAndRight(-view4.getLeft());
            }
            this.f2970ms.invalidate();
        }
        return true;
    }
}
