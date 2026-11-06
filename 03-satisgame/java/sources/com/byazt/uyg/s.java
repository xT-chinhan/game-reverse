package com.byazt.uyg;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 8})
public class s {
    public static volatile Context n;

    public static void n(Context context) {
        if (n == null && context != null) {
            n = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        return n;
    }
}
