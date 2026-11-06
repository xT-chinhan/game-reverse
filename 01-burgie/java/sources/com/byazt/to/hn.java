package com.byazt.to;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT, 20})
public class hn {
    public static volatile Context pr;

    public static void pr(Context context) {
        if (pr != null || context == null) {
            return;
        }
        pr = context.getApplicationContext();
    }

    public static Context getContext() {
        return pr;
    }
}
