package com.byazt.ts;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 250})
public class k {
    public static volatile com.byazt.lj.m hw;
    public static volatile com.byazt.lj.m pr;

    public static com.byazt.lj.m pr(boolean z) {
        if (z && com.byazt.lj.hn.nw()) {
            if (hw == null) {
                synchronized (k.class) {
                    if (hw == null) {
                        hw = com.byazt.lj.hn.ie().hw();
                    }
                }
            }
            return hw;
        }
        if (pr == null) {
            synchronized (k.class) {
                if (pr == null) {
                    pr = new nt();
                }
            }
        }
        return pr;
    }
}
