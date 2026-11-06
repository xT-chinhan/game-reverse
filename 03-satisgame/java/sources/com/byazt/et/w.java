package com.byazt.et;

import android.content.Context;
import android.view.MotionEvent;
import com.byazt.xz.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 13})
public class w extends qg {
    public float cp;
    public float d;
    public boolean oa;
    public k sz;

    public w(Context context) {
        super(context);
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        k kVar = this.sz;
        if (kVar != null) {
            return kVar.n(this.qg, motionEvent, this.n, this);
        }
        return n(this.qg, motionEvent);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    public boolean n(com.byazt.ih.s sVar, MotionEvent motionEvent) {
        float rawX;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.cp = motionEvent.getRawX();
            this.d = motionEvent.getRawY();
        } else if (action == 1) {
            if (this.oa) {
                this.oa = false;
                this.cp = 0.0f;
                this.d = 0.0f;
                return false;
            }
            rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (Math.abs(rawX - this.cp) < 15.0f || Math.abs(rawY - this.d) >= 15.0f) {
                this.oa = false;
                return false;
            }
            if (this.n != null) {
                this.n.n(sVar, this.w, this.s.qg(), this.s);
                this.cp = 0.0f;
                this.d = 0.0f;
                return true;
            }
        } else if (action == 2) {
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.cp) >= 15.0f || Math.abs(rawY2 - this.d) >= 15.0f) {
                this.oa = true;
            }
        } else if (action == 3) {
            this.oa = false;
            float rawX3 = motionEvent.getRawX();
            if (motionEvent.getRawY() != 0.0f || rawX3 != 0.0f) {
                if (this.oa) {
                    this.oa = false;
                    this.cp = 0.0f;
                    this.d = 0.0f;
                    return false;
                }
                rawX = motionEvent.getRawX();
                float rawY3 = motionEvent.getRawY();
                if (Math.abs(rawX - this.cp) < 15.0f) {
                }
                this.oa = false;
                return false;
            }
        }
        return true;
    }

    public void n(k kVar) {
        this.sz = kVar;
    }
}
