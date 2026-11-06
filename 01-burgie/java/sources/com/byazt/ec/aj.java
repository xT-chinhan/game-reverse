package com.byazt.ec;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 61})
public class aj {
    public static volatile Object pr;

    private Object pr() {
        if (pr == null) {
            synchronized (aj.class) {
                if (pr == null) {
                    try {
                        pr = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable th) {
                    }
                }
            }
        }
        return pr;
    }

    public String pr(String str) throws IllegalArgumentException {
        try {
            Object objPr = pr();
            return (String) objPr.getClass().getMethod("get", String.class).invoke(objPr, str);
        } catch (Throwable th) {
            w.pr(th);
            return "";
        }
    }
}
