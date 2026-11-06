package com.byazt.ca;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, 250})
public final class k {
    public static boolean pr(List<?> list) {
        return list == null || list.size() == 0;
    }

    public static boolean hw(List<?> list) {
        return !pr(list);
    }
}
