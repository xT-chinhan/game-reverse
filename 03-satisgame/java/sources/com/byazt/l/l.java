package com.byazt.l;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 18, 18})
public final class l implements Handler.Callback {
    public volatile Handler n = new Handler(n.n, this);

    public interface qg {
        long n();
    }

    @com.byazt.cp.n(n = {0, 1, 18, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n {
        public static final Looper n;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            n = handlerThread.getLooper();
        }
    }

    public static Looper n() {
        return n.n;
    }

    public void n(qg qgVar, long j) {
        Handler handler = this.n;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = qgVar;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public void qg() {
        Handler handler = this.n;
        if (handler == null) {
            return;
        }
        this.n = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            qg qgVar = (qg) message.obj;
            long jN = qgVar.n();
            if (jN <= 0) {
                return true;
            }
            n(qgVar, jN);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
