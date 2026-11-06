package com.byazt.bhm;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH, 101})
public class fs implements View.OnTouchListener {
    public float l;
    public final com.byazt.jmk.fs n;
    public float q;
    public final boolean qg;
    public final int s = 10;
    public float w;
    public float x;

    public fs(com.byazt.jmk.fs fsVar, boolean z) {
        this.n = fsVar;
        this.qg = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.jmk.fs fsVar;
        com.byazt.jmk.fs fsVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.q = motionEvent.getX();
            this.l = motionEvent.getY();
            Object[] objArr = new Object[3];
            Float.valueOf(this.q);
            String str = ", mStartY: " + this.l;
        } else if (action == 1) {
            this.w = motionEvent.getX();
            this.x = motionEvent.getY();
            Object[] objArr2 = new Object[3];
            Float.valueOf(this.w);
            String str2 = ", mEndY: " + this.x;
            if (!this.qg && (fsVar2 = this.n) != null) {
                fsVar2.n();
            } else {
                float f = this.w - this.q;
                float f2 = this.x - this.l;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                Object[] objArr3 = new Object[2];
                Float.valueOf(fSqrt);
                float fQg = com.byazt.cq.fs.qg(com.byazt.twc.q.getContext(), Math.abs(fSqrt));
                Object[] objArr4 = new Object[5];
                Float.valueOf(fQg);
                Integer.valueOf(10);
                if (fQg > 10.0f && (fsVar = this.n) != null) {
                    fsVar.n();
                }
            }
        }
        return true;
    }
}
