package com.byazt.yw;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO, 101})
public class fs {
    public static File n(Context context) {
        return new File(s(context), "CrashLogJava");
    }

    public static File qg(Context context) {
        return new File(s(context), "crash_history");
    }

    public static String n() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String qg() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    private static String s(Context context) {
        String path;
        try {
            if (com.byazt.qyu.qg.n(context) != null) {
                path = com.byazt.qyu.qg.n(context).getPath();
            } else {
                File fileN = com.byazt.qyu.qg.n(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                path = fileN != null ? fileN.getPath() : null;
            }
            return path != null ? path : "/sdcard/";
        } catch (Exception unused) {
            return "/sdcard/";
        }
    }
}
