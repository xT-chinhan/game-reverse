package com.byazt.ww;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 576, 121})
public class x implements View.OnTouchListener {
    public com.byazt.yhm.zo aj;
    public boolean c = true;
    public float fw;
    public float hn;
    public float hw;
    public float pr;
    public float uc;
    public int vk;
    public boolean w;
    public float x;
    public boolean zo;

    public x(com.byazt.yhm.zo zoVar, int i, boolean z) {
        this.aj = zoVar;
        this.vk = i;
        this.w = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.yhm.zo zoVar;
        com.byazt.yhm.zo zoVar2;
        com.byazt.yhm.zo zoVar3;
        switch (motionEvent.getAction()) {
            case 0:
                this.pr = motionEvent.getX();
                this.hw = motionEvent.getY();
                this.uc = motionEvent.getY();
                this.c = true;
                return true;
            case 1:
                if (!this.zo && !this.c) {
                    return false;
                }
                if (!this.w && (zoVar3 = this.aj) != null) {
                    zoVar3.pr();
                } else {
                    int iHw = com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), Math.abs(this.fw - this.uc));
                    if (this.fw - this.uc < 0.0f && iHw > this.vk && (zoVar2 = this.aj) != null) {
                        zoVar2.pr();
                    } else if (this.c && (zoVar = this.aj) != null) {
                        zoVar.pr();
                    }
                }
                return true;
            case 2:
                float y = motionEvent.getY();
                this.fw = y;
                if (Math.abs(y - this.uc) > 10.0f) {
                    this.zo = true;
                }
                this.x = motionEvent.getX();
                this.hn = motionEvent.getY();
                if (Math.abs(this.x - this.pr) > 8.0f || Math.abs(this.hn - this.hw) > 8.0f) {
                    this.c = false;
                }
                return true;
            default:
                return true;
        }
    }
}
