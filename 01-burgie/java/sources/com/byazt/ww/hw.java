package com.byazt.ww;

import android.view.MotionEvent;
import android.view.View;
import com.byazt.yhm.InteractViewContainer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 576, 13})
public class hw implements View.OnTouchListener {
    public InteractViewContainer c;
    public long hn;
    public float hw;
    public float pr;
    public com.byazt.yhm.zo uc;
    public boolean x;

    public hw(InteractViewContainer interactViewContainer, com.byazt.yhm.zo zoVar) {
        this.c = interactViewContainer;
        this.uc = zoVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.hn = System.currentTimeMillis();
                this.pr = motionEvent.getX();
                this.hw = motionEvent.getY();
                this.c.c();
                return true;
            case 1:
                if (this.x) {
                    return false;
                }
                if (System.currentTimeMillis() - this.hn >= 1500) {
                    com.byazt.yhm.zo zoVar = this.uc;
                    if (zoVar != null) {
                        zoVar.pr();
                    }
                }
                return true;
            case 2:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.pr) >= com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), 10.0f) || Math.abs(y - this.hw) >= com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), 10.0f)) {
                    this.x = true;
                    break;
                }
                return true;
            default:
                return true;
        }
        this.c.uc();
        return true;
    }
}
