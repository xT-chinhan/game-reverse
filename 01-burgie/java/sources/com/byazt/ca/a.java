package com.byazt.ca;

import android.content.Context;
import android.content.res.Resources;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD})
public final class a {
    public static Resources hw;
    public static Context pr = null;
    public static boolean hn = false;
    public static boolean x = false;

    public static Resources pr(Context context) {
        Resources resources = hw;
        if (resources == null) {
            resources = null;
        }
        Context context2 = pr;
        if (context2 != null) {
            resources = context2.getResources();
        }
        if (resources == null) {
            return context.getResources();
        }
        return resources;
    }
}
