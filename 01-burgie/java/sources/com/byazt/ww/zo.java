package com.byazt.ww;

import android.view.MotionEvent;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 576, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo implements View.OnTouchListener {
    public float c;
    public float fw;
    public final int hn = 10;
    public final boolean hw;
    public final com.byazt.yhm.zo pr;
    public float uc;
    public float x;

    public zo(com.byazt.yhm.zo zoVar, boolean z) {
        this.pr = zoVar;
        this.hw = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.yhm.zo zoVar;
        com.byazt.yhm.zo zoVar2;
        switch (motionEvent.getAction()) {
            case 0:
                this.x = motionEvent.getX();
                this.c = motionEvent.getY();
                Object[] objArr = {"mStartX: ", Float.valueOf(this.x), ", mStartY: " + this.c};
                return true;
            case 1:
                this.uc = motionEvent.getX();
                this.fw = motionEvent.getY();
                Object[] objArr2 = {"mEndX: ", Float.valueOf(this.uc), ", mEndY: " + this.fw};
                if (!this.hw && (zoVar2 = this.pr) != null) {
                    zoVar2.pr();
                } else {
                    float f = this.uc - this.x;
                    float f2 = this.fw - this.c;
                    float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                    Object[] objArr3 = {"slideDistancePx: ", Float.valueOf(fSqrt)};
                    float fHw = com.byazt.js.zo.hw(com.byazt.dj.x.getContext(), Math.abs(fSqrt));
                    Object[] objArr4 = {"slideDistanceDp:", Float.valueOf(fHw), " and ", "mSlideThreshold:", 10};
                    if (fHw > 10.0f && (zoVar = this.pr) != null) {
                        zoVar.pr();
                    }
                }
                return true;
            default:
                return true;
        }
    }
}
