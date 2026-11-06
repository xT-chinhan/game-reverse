package com.byazt.gu;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 665, 1479})
public class UGTimerContainer extends FrameLayout {
    public final com.byazt.nk.pr hw;
    public com.byazt.bk.pr pr;

    public UGTimerContainer(Context context, com.byazt.nk.pr prVar) {
        super(context);
        this.hw = prVar;
    }

    public void setTimerHolder(com.byazt.bk.pr prVar) {
        this.pr = prVar;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.byazt.bk.pr prVar = this.pr;
        if (prVar != null) {
            if (i == 0) {
                prVar.pr();
            } else {
                prVar.hw();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.byazt.nk.pr prVar = this.hw;
        if (prVar != null) {
            prVar.pr(this, motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }
}
