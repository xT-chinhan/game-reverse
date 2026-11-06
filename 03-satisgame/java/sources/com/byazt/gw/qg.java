package com.byazt.gw;

import android.os.Handler;
import android.os.Message;
import com.byazt.tk.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 26})
public class qg implements Handler.Callback {
    public Handler n;

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS, 48})
    private static class n {
        public static final qg n = new qg();
    }

    public static qg n() {
        return n.n;
    }

    private qg() {
        this.n = new Handler(rv.n().getLooper(), this);
    }

    public void n(Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = runnable;
        this.n.sendMessage(messageObtain);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ((Runnable) message.obj).run();
        return false;
    }

    public void n(Runnable runnable, long j) {
        this.n.postDelayed(runnable, j);
    }
}
