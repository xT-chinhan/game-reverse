package com.byazt.ca;

import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 91})
public class rc {
    public static volatile String pr;

    public static String pr() {
        if (!TextUtils.isEmpty(pr)) {
            return pr;
        }
        String str = Build.MODEL;
        pr = str;
        return str;
    }
}
