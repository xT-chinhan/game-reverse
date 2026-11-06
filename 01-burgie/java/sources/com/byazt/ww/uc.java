package com.byazt.ww;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 576, 5})
public class uc implements View.OnTouchListener {
    public static int hn = 10;
    public com.byazt.yhm.zo c;
    public float hw;
    public float pr;
    public boolean x;

    public uc(com.byazt.yhm.zo zoVar) {
        this.c = zoVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pr = motionEvent.getX();
                this.hw = motionEvent.getY();
                return true;
            case 1:
                if (this.x) {
                    this.x = false;
                    return false;
                }
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.pr) >= hn || Math.abs(y - this.hw) >= hn) {
                    this.x = false;
                } else {
                    com.byazt.yhm.zo zoVar = this.c;
                    if (zoVar != null) {
                        zoVar.pr();
                    }
                }
                return true;
            case 2:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                if (Math.abs(x2 - this.pr) >= hn || Math.abs(y2 - this.hw) >= hn) {
                    this.x = true;
                }
                return true;
            case 3:
                this.x = false;
                return true;
            default:
                return true;
        }
    }
}
