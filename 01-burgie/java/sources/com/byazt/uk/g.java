package com.byazt.uk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_REUSE_SOCKET, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g extends Handler {
    public WeakReference<pr> pr;

    public interface pr {
        void pr(Message message);
    }

    public g(Looper looper, pr prVar) {
        super(looper);
        this.pr = new WeakReference<>(prVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        pr prVar = this.pr.get();
        if (prVar != null && message != null) {
            prVar.pr(message);
        }
    }
}
