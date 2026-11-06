package com.byazt.xv;

import android.content.Context;
import android.view.MotionEvent;
import com.byazt.dd.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends hw {
    public ho g;
    public float k;
    public boolean m;
    public float w;

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        ho hoVar = this.g;
        if (hoVar != null) {
            return hoVar.pr(this.hw, motionEvent, this.pr, this);
        }
        return pr(this.hw, motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:15:0x0042  */
    /* JADX WARN: Code duplicated, block: B:17:0x0046  */
    /* JADX WARN: Code duplicated, block: B:19:0x004d  */
    public boolean pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        float rawX;
        switch (motionEvent.getAction()) {
            case 0:
                this.w = motionEvent.getRawX();
                this.k = motionEvent.getRawY();
                return true;
            case 1:
                if (this.m) {
                    this.m = false;
                    this.w = 0.0f;
                    this.k = 0.0f;
                    return false;
                }
                rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.w) < 15.0f || Math.abs(rawY - this.k) >= 15.0f) {
                    this.m = false;
                    return false;
                }
                if (this.pr != null) {
                    this.pr.pr(hnVar, this.uc, this.hn.hw(), this.hn);
                    this.w = 0.0f;
                    this.k = 0.0f;
                    return true;
                }
                return true;
            case 2:
                float rawX2 = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                if (Math.abs(rawX2 - this.w) >= 15.0f || Math.abs(rawY2 - this.k) >= 15.0f) {
                    this.m = true;
                }
                return true;
            case 3:
                this.m = false;
                float rawX3 = motionEvent.getRawX();
                if (motionEvent.getRawY() != 0.0f || rawX3 != 0.0f) {
                    if (this.m) {
                        this.m = false;
                        this.w = 0.0f;
                        this.k = 0.0f;
                        return false;
                    }
                    rawX = motionEvent.getRawX();
                    float rawY3 = motionEvent.getRawY();
                    if (Math.abs(rawX - this.w) < 15.0f) {
                        break;
                    }
                    this.m = false;
                    return false;
                }
                return true;
            default:
                return true;
        }
    }

    public void pr(ho hoVar) {
        this.g = hoVar;
    }
}
