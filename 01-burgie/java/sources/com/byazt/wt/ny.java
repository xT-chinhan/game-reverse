package com.byazt.wt;

import com.byazt.hg.l;
import com.byazt.hg.o;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 36})
public class ny {
    public static String pr(of ofVar) {
        if (ofVar == null) {
            return "";
        }
        switch (zo(ofVar)) {
            case 3:
                return com.byazt.hg.lb.zo(ofVar);
            case 4:
                return l.c(ofVar);
            default:
                return "";
        }
    }

    public static boolean hw(of ofVar) {
        return (ofVar == null || zo(ofVar) == 0) ? false : true;
    }

    private static int zo(of ofVar) {
        if (com.byazt.hg.lb.pr(ofVar)) {
            return 3;
        }
        if (l.pr(ofVar)) {
            return 4;
        }
        return 0;
    }

    public static boolean hn(of ofVar) {
        if (ofVar == null || o.pr(ofVar)) {
            return false;
        }
        switch (zo(ofVar)) {
            case 3:
                return com.byazt.hg.lb.pr(ofVar);
            default:
                return false;
        }
    }

    public static boolean x(of ofVar) {
        if (ofVar == null) {
            return false;
        }
        switch (zo(ofVar)) {
            case 4:
                return true;
            default:
                return false;
        }
    }

    public static int c(of ofVar) {
        if (ofVar == null) {
            return 0;
        }
        switch (zo(ofVar)) {
            case 3:
                return com.byazt.hg.lb.w(ofVar);
            default:
                return 0;
        }
    }

    public static int uc(of ofVar) {
        if (ofVar == null) {
            return -1;
        }
        switch (zo(ofVar)) {
            case 3:
                return com.byazt.hg.lb.k(ofVar);
            default:
                return 0;
        }
    }

    public static boolean fw(of ofVar) {
        return zo(ofVar) == 3;
    }
}
