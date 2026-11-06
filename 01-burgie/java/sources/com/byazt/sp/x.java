package com.byazt.sp;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS, 121})
public class x {
    public static boolean pr() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean hw() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
