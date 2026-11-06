package com.byazt.xk;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 92, 526})
public class PlayableEndcardFrameLayout extends FrameLayout {
    public n n;
    public int qg;

    public interface n {
        void n();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    public void n(n nVar) {
        this.n = nVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(this.qg - y) > 100) {
                n();
                this.qg = y;
            }
        } else {
            this.qg = y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void n() {
        n nVar = this.n;
        if (nVar != null) {
            nVar.n();
        }
    }
}
