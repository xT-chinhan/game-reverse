package com.byazt.qi;

import android.os.Handler;
import android.os.HandlerThread;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 21})
public class x {
    public static volatile HandlerThread n;
    public static volatile Handler qg;
    public static volatile Handler s;

    public static HandlerThread n() {
        if (n == null) {
            synchronized (x.class) {
                if (n == null) {
                    HandlerThread handlerThread = new HandlerThread("default_npth_thread");
                    n = handlerThread;
                    handlerThread.start();
                    qg = new Handler(n.getLooper());
                }
            }
        }
        return n;
    }

    public static Handler qg() {
        if (qg == null) {
            n();
        }
        return qg;
    }
}
