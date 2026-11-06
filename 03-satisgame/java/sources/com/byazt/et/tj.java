package com.byazt.et;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends qg implements com.byazt.hb.rv.n {
    public int cp;
    public boolean d;
    public Handler oa;

    public tj(Context context) {
        super(context);
        this.cp = 500;
        this.oa = new com.byazt.hb.rv(Looper.getMainLooper(), this);
    }

    @Override // com.byazt.et.qg
    public boolean n(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        Object obj = this.l.get("delay");
        if (obj == null) {
            this.cp = 500;
        } else {
            this.cp = com.byazt.hb.s.n(String.valueOf(obj), 500);
        }
        return n(this.qg, motionEvent);
    }

    private boolean n(com.byazt.ih.s sVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.oa.sendEmptyMessageDelayed(1102, this.cp);
        } else {
            if (action == 1) {
                if (this.d && this.n != null) {
                    this.n.n(this.qg, this.w, this.s.qg(), this.s);
                    this.d = false;
                    Handler handler = this.oa;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.oa;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.d = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.oa;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.d = false;
            }
        }
        return true;
    }

    @Override // com.byazt.hb.rv.n
    public void n(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.d = true;
        Handler handler = this.oa;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
