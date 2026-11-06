package com.byazt.tk;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 350, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY})
public class m {
    public static volatile String n;

    public static String n() {
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        String str = Build.MODEL;
        n = str;
        return str;
    }
}
