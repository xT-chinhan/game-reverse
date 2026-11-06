package com.byazt.ze;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.wt.er;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 16, 20})
public class hn implements View.OnTouchListener {
    public int c;
    public boolean hn;
    public float hw;
    public float pr;
    public Context uc;
    public pr x;

    public interface pr {
        void hw();

        void pr();
    }

    public hn(Context context, pr prVar, int i) {
        this.uc = context;
        this.c = i;
        this.x = prVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.pr = motionEvent.getY();
                return true;
            case 1:
                if (!this.hn) {
                    pr prVar = this.x;
                    if (prVar != null) {
                        prVar.hw();
                    }
                    return true;
                }
                int iX = er.x(this.uc, Math.abs(this.hw - this.pr));
                if (this.hw - this.pr < 0.0f && iX > this.c) {
                    pr prVar2 = this.x;
                    if (prVar2 != null) {
                        prVar2.pr();
                    }
                } else {
                    pr prVar3 = this.x;
                    if (prVar3 != null) {
                        prVar3.hw();
                    }
                }
                return true;
            case 2:
                float y = motionEvent.getY();
                this.hw = y;
                if (Math.abs(y - this.pr) > 10.0f) {
                    this.hn = true;
                }
                return true;
            default:
                return true;
        }
    }
}
