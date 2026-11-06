package com.byazt.gi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 587, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public final class c implements Handler.Callback {
    public volatile Handler pr = new Handler(pr.pr, this);

    public interface hw {
        long pr();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 587, 169})
    private static class pr {
        public static final Looper pr;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            pr = handlerThread.getLooper();
        }
    }

    public static Looper pr() {
        return pr.pr;
    }

    public void pr(hw hwVar, long j) {
        Handler handler = this.pr;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = hwVar;
        handler.sendMessageDelayed(messageObtain, j);
    }

    public void hw() {
        Handler handler = this.pr;
        if (handler == null) {
            return;
        }
        this.pr = null;
        handler.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                try {
                    hw hwVar = (hw) message.obj;
                    long jPr = hwVar.pr();
                    if (jPr > 0) {
                        pr(hwVar, jPr);
                    }
                } catch (Throwable th) {
                    return true;
                }
                break;
        }
        return true;
    }
}
