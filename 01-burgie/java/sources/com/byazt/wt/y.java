package com.byazt.wt;

import android.os.Build;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, MediaPlayer.MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC})
public final class y {
    public static volatile boolean pr = false;

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 131})
    static class pr {
        public static final com.byazt.to.x.pr pr = y.x();
    }

    private static String hw(String str) {
        if (pr) {
            return str;
        }
        com.byazt.vkw.c cVar = (com.byazt.vkw.c) com.byazt.zs.uc.pr("app_process");
        if (cVar.pr()) {
            return str;
        }
        return str + cVar.hw();
    }

    public static com.byazt.cr.c pr(String str) {
        return pr.pr.pr(hw(str)).pr();
    }

    public static void pr() {
        pr = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.to.x.pr x() {
        com.byazt.is.w wVarHw = com.byazt.sd.a.hw();
        switch (wVarHw.lp()) {
            case 2:
                int i = Build.VERSION.SDK_INT;
                break;
        }
        return new com.byazt.to.x.pr().pr(com.byazt.sd.a.getContext()).pr(1).hw(wVarHw.ig()).pr(pr);
    }

    public static int hw() {
        return 3;
    }
}
