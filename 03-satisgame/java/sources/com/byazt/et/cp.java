package com.byazt.et;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION, 29})
public class cp extends qg implements com.byazt.hb.rv.n {
    public int cp;
    public Handler d;

    public cp(Context context) {
        super(context);
        this.cp = 500;
        this.d = new com.byazt.hb.rv(Looper.getMainLooper(), this);
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
            this.d.sendEmptyMessageDelayed(1101, this.cp);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.d.removeMessages(1101);
        return false;
    }

    @Override // com.byazt.hb.rv.n
    public void n(Message message) {
        if (message.what != 1101) {
            return;
        }
        if (this.n != null) {
            this.n.n(this.qg, this.w, this.s.qg(), this.s);
        }
        Handler handler = this.d;
        if (handler != null) {
            handler.removeMessages(1101);
        }
    }
}
