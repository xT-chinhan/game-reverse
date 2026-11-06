package com.byazt.tk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL})
public class t extends Handler {
    public WeakReference<wo.n> n;

    public t(wo.n nVar) {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (nVar != null) {
            this.n = new WeakReference<>(nVar);
        }
    }

    public t(Looper looper, wo.n nVar) {
        super(looper);
        if (nVar != null) {
            this.n = new WeakReference<>(nVar);
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        wo.n nVar;
        WeakReference<wo.n> weakReference = this.n;
        if (weakReference == null || (nVar = weakReference.get()) == null || message == null) {
            return;
        }
        nVar.n(message);
    }
}
