package com.byazt.ne;

import android.os.Handler;
import android.os.Message;
import com.byazt.ca.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, 13})
public class hw implements Handler.Callback {
    public Handler pr;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        public static final hw pr = new hw();
    }

    public static hw pr() {
        return pr.pr;
    }

    private hw() {
        this.pr = new Handler(aj.pr().getLooper(), this);
    }

    public void pr(Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = runnable;
        this.pr.sendMessage(messageObtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    public void pr(Runnable runnable, long j) {
        this.pr.postDelayed(runnable, j);
    }
}
