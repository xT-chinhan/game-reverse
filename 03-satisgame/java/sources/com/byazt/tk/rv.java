package com.byazt.tk;

import android.os.Handler;
import com.byazt.vf.wo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static volatile Handler n;
    public static volatile Handler qg;
    public static volatile Handler s;

    public static Handler n() {
        Handler handlerQ;
        if (qg == null && (handlerQ = ((wo) com.byazt.qp.q.n("thread_service")).q()) != null) {
            qg = handlerQ;
        }
        return qg;
    }

    public static Handler qg() {
        if (n == null) {
            n = ((wo) com.byazt.qp.q.n("thread_service")).w();
        }
        return n;
    }

    public static Handler s() {
        Handler handlerL;
        if (s == null && (handlerL = ((wo) com.byazt.qp.q.n("thread_service")).l()) != null) {
            s = handlerL;
        }
        return s;
    }
}
