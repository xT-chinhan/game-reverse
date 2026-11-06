package com.byazt.ww;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 576, 20})
public class hn implements View.OnTouchListener {
    public boolean aj;
    public boolean c;
    public int fw;
    public float hn;
    public float hw;
    public float pr;
    public com.byazt.yhm.zo uc;
    public float x;
    public boolean zo;

    public hn(com.byazt.yhm.zo zoVar) {
        this(zoVar, 5);
    }

    public hn(com.byazt.yhm.zo zoVar, int i) {
        this.fw = 5;
        this.zo = true;
        this.uc = zoVar;
        if (i > 0) {
            this.fw = i;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.yhm.zo zoVar;
        com.byazt.yhm.zo zoVar2;
        com.byazt.yhm.zo zoVar3;
        if (this.aj) {
            return true;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.pr = motionEvent.getX();
                this.hw = motionEvent.getY();
                return true;
            case 1:
                if (!this.c && !this.zo) {
                    return false;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int iHw = com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), Math.abs(this.x - this.pr));
                if (this.x > this.pr && iHw > this.fw && (zoVar2 = this.uc) != null) {
                    zoVar2.pr();
                    this.aj = true;
                }
                float fAbs = Math.abs(x - this.pr);
                float fAbs2 = Math.abs(y - this.hw);
                if ((fAbs < 8.0f || fAbs2 < 8.0f) && (zoVar = this.uc) != null) {
                    zoVar.hw();
                    this.aj = true;
                }
                return true;
            case 2:
                this.x = motionEvent.getX();
                this.hn = motionEvent.getY();
                if (Math.abs(this.x - this.pr) > 10.0f) {
                    this.c = true;
                }
                if (Math.abs(this.x - this.pr) > 8.0f || Math.abs(this.hn - this.hw) > 8.0f) {
                    this.zo = false;
                }
                int iHw2 = com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), Math.abs(this.x - this.pr));
                if (this.x > this.pr && iHw2 > this.fw && (zoVar3 = this.uc) != null) {
                    zoVar3.pr();
                    this.aj = true;
                }
                return true;
            default:
                return true;
        }
    }
}
