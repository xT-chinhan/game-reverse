package com.byazt.wt;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 74})
public class nt {
    public static volatile String hn;
    public static volatile String hw;
    public static volatile String pr;
    public static String x = null;

    public static void pr(String str) {
        if (com.byazt.qv.pr.pr() != null) {
            com.byazt.qv.pr.pr().pr(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(pr)) {
            return;
        }
        com.byazt.sd.hw.pr().pr("did", str);
        pr = str;
    }

    public static String pr() {
        if (!TextUtils.isEmpty(pr)) {
            return pr;
        }
        String strHw = com.byazt.sd.hw.pr().hw("did", x);
        pr = strHw;
        return strHw;
    }

    public static void hw(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, hw)) {
            return;
        }
        com.byazt.sd.hw.hw().pr("dev6101", str);
        hw = str;
    }

    public static String hw() {
        if (!TextUtils.isEmpty(hw)) {
            return hw;
        }
        String strHw = com.byazt.sd.hw.hw().hw("dev6101", x);
        hw = strHw;
        return strHw;
    }

    public static void hn(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, hn)) {
            return;
        }
        com.byazt.sd.hw.hw().pr("dev6102", str);
        hn = str;
    }

    public static String hn() {
        if (!TextUtils.isEmpty(hn)) {
            return hn;
        }
        String strHw = com.byazt.sd.hw.hw().hw("dev6102", x);
        hn = strHw;
        return strHw;
    }
}
