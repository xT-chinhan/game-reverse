package com.byazt.ca;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.vkw.qi;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 166})
public class iu extends Handler {
    public WeakReference<qi.pr> pr;

    public iu(qi.pr prVar) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (prVar != null) {
            this.pr = new WeakReference<>(prVar);
        }
    }

    public iu(Looper looper, qi.pr prVar) {
        super(looper);
        if (prVar != null) {
            this.pr = new WeakReference<>(prVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        qi.pr prVar;
        WeakReference<qi.pr> weakReference = this.pr;
        if (weakReference != null && (prVar = weakReference.get()) != null && message != null) {
            prVar.pr(message);
        }
    }
}
