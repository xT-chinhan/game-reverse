package com.byazt.gn;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 1908})
public class UGTimerContainer extends FrameLayout {
    public com.byazt.ve.n n;
    public final com.byazt.cv.n qg;

    public UGTimerContainer(Context context, com.byazt.cv.n nVar) {
        super(context);
        this.qg = nVar;
    }

    public void setTimerHolder(com.byazt.ve.n nVar) {
        this.n = nVar;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        com.byazt.ve.n nVar = this.n;
        if (nVar != null) {
            if (i == 0) {
                nVar.qg();
            } else {
                nVar.s();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        com.byazt.cv.n nVar = this.qg;
        if (nVar != null) {
            nVar.n(this, motionEvent, zDispatchTouchEvent);
        }
        return zDispatchTouchEvent;
    }
}
