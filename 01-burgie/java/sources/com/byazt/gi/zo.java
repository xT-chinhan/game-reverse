package com.byazt.gi;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 587, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends Handler {
    public final WeakReference<pr> pr;

    public interface pr {
        void pr(Message message);
    }

    public zo(Looper looper, pr prVar) {
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
