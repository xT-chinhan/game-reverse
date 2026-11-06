package com.byazt.mg;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 860, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public static StringBuffer pr = new StringBuffer();

    public static void pr(String str, String str2) {
        StringBuffer stringBuffer = pr;
        if (stringBuffer == null || str2 == null) {
            return;
        }
        try {
            if (stringBuffer.length() > 204800) {
                return;
            }
            pr.append(System.currentTimeMillis()).append(';').append(str).append(';').append(str2).append('\n');
        } catch (Exception e) {
        }
    }

    public static void pr() {
        pr = null;
    }

    public static String hw() {
        String string;
        StringBuffer stringBuffer = pr;
        if (stringBuffer == null) {
            string = "";
        } else {
            string = stringBuffer.toString();
        }
        pr = null;
        return string;
    }
}
