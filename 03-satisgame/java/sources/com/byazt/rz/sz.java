package com.byazt.rz;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 110})
public class sz extends Handler {
    public WeakReference<n> n;

    public interface n {
        void n(Message message);
    }

    public sz(Looper looper, n nVar) {
        super(looper);
        this.n = new WeakReference<>(nVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        n nVar = this.n.get();
        if (nVar == null || message == null) {
            return;
        }
        nVar.n(message);
    }
}
