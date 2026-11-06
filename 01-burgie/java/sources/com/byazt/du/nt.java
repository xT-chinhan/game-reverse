package com.byazt.du;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW, 74})
public final class nt {
    public static long hw;
    public static ho pr;

    private nt() {
    }

    public static ho pr() {
        synchronized (nt.class) {
            ho hoVar = pr;
            if (hoVar != null) {
                pr = hoVar.uc;
                hoVar.uc = null;
                hw -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                return hoVar;
            }
            return new ho();
        }
    }

    public static void pr(ho hoVar) {
        if (hoVar.uc != null || hoVar.fw != null) {
            throw new IllegalArgumentException();
        }
        if (hoVar.x) {
            return;
        }
        synchronized (nt.class) {
            long j = hw;
            if (j + PlaybackStateCompat.ACTION_PLAY_FROM_URI > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                return;
            }
            hw = j + PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            hoVar.uc = pr;
            hoVar.hn = 0;
            hoVar.hw = 0;
            pr = hoVar;
        }
    }
}
