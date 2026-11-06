package com.byazt.gs;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 121})
public class x {
    public static <T> boolean pr(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean pr(T[] tArr, T t) {
        return hw(tArr, t) != -1;
    }

    public static <T> int hw(T[] tArr, T t) {
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

    public static <T> boolean pr(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!pr(tArr, t)) {
                return false;
            }
        }
        return true;
    }
}
