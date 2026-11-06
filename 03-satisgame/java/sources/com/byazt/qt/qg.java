package com.byazt.qt;

import android.content.Context;
import com.byazt.ng.l;
import com.byazt.qp.q;
import com.byazt.vf.oj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW, 26})
public class qg {
    public static volatile l n;

    public static Context getContext() {
        return ((oj) q.n("system_context")).getContext();
    }

    public static synchronized void n(Context context) {
        ((oj) q.n("system_context")).n(context);
    }

    public static l n() {
        if (n == null) {
            synchronized (l.class) {
                if (n == null) {
                    n = new l();
                }
            }
        }
        return n;
    }
}
