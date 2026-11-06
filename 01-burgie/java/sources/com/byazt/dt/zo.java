package com.byazt.dt;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1167, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends hw {
    public static volatile zo pr;

    private zo() {
    }

    public static hw pr() {
        if (pr == null) {
            synchronized (hw.class) {
                if (pr == null) {
                    pr = new zo();
                }
            }
        }
        return pr;
    }

    @Override // com.byazt.dt.hw
    public int hw() {
        return com.byazt.mp.c.pr().hn();
    }

    @Override // com.byazt.dt.hw
    public long hn() {
        return com.byazt.mp.c.pr().hw();
    }
}
