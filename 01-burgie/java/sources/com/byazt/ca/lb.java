package com.byazt.ca;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 48})
public class lb {
    public static void pr(Object obj, String str) {
        if (obj == null) {
            hw(str);
        }
    }

    public static void pr(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            hw(str2);
        }
    }

    public static void pr(boolean z, String str) {
        if (!z) {
            hw(str);
        }
    }

    public static void pr(String str) {
        hw(str);
    }

    private static void hw(String str) {
        throw new IllegalArgumentException(str);
    }
}
