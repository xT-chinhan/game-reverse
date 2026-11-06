package com.byazt.bk;

import android.text.TextUtils;
import android.util.Base64;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 8})
public class s {
    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        byte[] bArrDecode = Base64.decode(com.byazt.ta.w.n(str), 0);
        int length = str2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (byte b : bArrDecode) {
            if (i >= length) {
                i %= length;
            }
            sb.append((char) (b ^ str2.charAt(i)));
            i++;
        }
        return sb.toString();
    }

    public static String n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new String(Base64.decode(com.byazt.ta.w.n(str), 0));
    }
}
