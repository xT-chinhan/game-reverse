package com.byazt.ul;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 831, 8})
public class s implements View.OnTouchListener {
    public int l;
    public float n;
    public n q;
    public float qg;
    public boolean s;
    public Context w;

    public interface n {
        void n();

        void qg();
    }

    public s(Context context, n nVar, int i) {
        this.w = context;
        this.l = i;
        this.q = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.n = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.qg = y;
                if (Math.abs(y - this.n) > 10.0f) {
                    this.s = true;
                }
            }
        } else {
            if (!this.s) {
                n nVar = this.q;
                if (nVar != null) {
                    nVar.qg();
                }
                return true;
            }
            int iQ = com.byazt.okk.s.q(this.w, Math.abs(this.qg - this.n));
            if (this.qg - this.n < 0.0f && iQ > this.l) {
                n nVar2 = this.q;
                if (nVar2 != null) {
                    nVar2.n();
                }
            } else {
                n nVar3 = this.q;
                if (nVar3 != null) {
                    nVar3.qg();
                }
            }
        }
        return true;
    }
}
