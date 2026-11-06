package com.byazt.ew;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE, 21})
public class x {
    public static n n;

    public interface n {
        void n(String str, String str2, Throwable th);
    }

    public static void n(n nVar) {
        n = nVar;
    }

    public static boolean n() {
        return n != null;
    }

    public static void n(String str, String str2, Throwable th) {
        if (n == null) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        n.n(str, str2, th);
    }
}
