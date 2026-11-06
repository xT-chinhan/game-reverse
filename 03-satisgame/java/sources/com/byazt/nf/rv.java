package com.byazt.nf;

import android.content.Context;
import com.byazt.vf.oj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static volatile com.byazt.mw.n n;
    public static volatile com.byazt.ivn.w qg;

    public static Context getContext() {
        return ((oj) com.byazt.qp.q.n("system_context")).getContext();
    }

    public static synchronized void n(Context context) {
        ((oj) com.byazt.qp.q.n("system_context")).n(context);
    }

    public static com.byazt.mw.n n() {
        if (n == null) {
            synchronized (rv.class) {
                if (n == null) {
                    n = new com.byazt.mw.qg(getContext());
                }
            }
        }
        return n;
    }

    public static com.byazt.ivn.w qg() {
        if (qg == null) {
            synchronized (com.byazt.ivn.w.class) {
                if (qg == null) {
                    qg = new com.byazt.ivn.w();
                }
            }
        }
        return qg;
    }
}
