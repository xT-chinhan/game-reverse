package com.byazt.km;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 832, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv {
    public static volatile Object n;

    private Object n() {
        if (n == null) {
            synchronized (rv.class) {
                if (n == null) {
                    try {
                        n = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return n;
    }

    public String n(String str) throws IllegalArgumentException {
        try {
            Object objN = n();
            return (String) objN.getClass().getMethod("get", String.class).invoke(objN, str);
        } catch (Throwable th) {
            cp.n(th);
            return "";
        }
    }
}
