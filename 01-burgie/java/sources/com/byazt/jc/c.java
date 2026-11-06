package com.byazt.jc;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 120, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static String pr = "com.bytedance.openadsdk";
    public static String hw = "content://" + pr + ".TTMultiProvider";

    static {
        pr();
    }

    public static void pr() {
        Context context = hw.getContext();
        if (context != null) {
            pr = context.getPackageName();
            hw = "content://" + pr + ".TTMultiProvider";
        }
    }
}
