package com.byazt.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME, 113})
public class d {
    public static volatile com.byazt.xv.oa n;
    public static volatile com.byazt.xv.oa qg;

    public static com.byazt.xv.oa n(boolean z) {
        if (z && com.byazt.xv.s.rf()) {
            if (qg == null) {
                synchronized (d.class) {
                    if (qg == null) {
                        qg = com.byazt.xv.s.dh().qg();
                    }
                }
            }
            return qg;
        }
        if (n == null) {
            synchronized (d.class) {
                if (n == null) {
                    n = new cy();
                }
            }
        }
        return n;
    }
}
