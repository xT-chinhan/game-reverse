package com.byazt.dea;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 84, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static boolean pr() {
        if (Build.VERSION.SDK_INT < 24) {
            uc.hw("csj sdk only support android os >= android 7.0（API-24）");
            return true;
        }
        return false;
    }
}
