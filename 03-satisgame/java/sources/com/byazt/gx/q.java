package com.byazt.gx;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILE_FORMAT, 5})
public class q {
    public static <T> boolean n(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean n(T[] tArr, T t) {
        return qg(tArr, t) != -1;
    }

    public static <T> int qg(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == t || (t2 != null && t2.equals(t))) {
                return i;
            }
        }
        return -1;
    }

    public static <T> boolean n(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!n(tArr, t)) {
                return false;
            }
        }
        return true;
    }
}
