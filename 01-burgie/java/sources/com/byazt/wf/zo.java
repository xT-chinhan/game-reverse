package com.byazt.wf;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 201, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo {
    public static File pr(Context context) {
        return new File(hn(context), "CrashLogJava");
    }

    public static File hw(Context context) {
        return new File(hn(context), "crash_history");
    }

    public static String pr() {
        return String.format("java_%s.npth", String.valueOf(System.nanoTime()));
    }

    public static String hw() {
        return String.format("anr_%s.npth", String.valueOf(System.nanoTime()));
    }

    private static String hn(Context context) {
        String path;
        try {
            if (com.byazt.mg.hw.pr(context) != null) {
                path = com.byazt.mg.hw.pr(context).getPath();
            } else {
                File filePr = com.byazt.mg.hw.pr(context, "/data/data/" + context.getPackageName() + "/files/", 0);
                if (filePr == null) {
                    path = null;
                } else {
                    path = filePr.getPath();
                }
            }
            if (path != null) {
                return path;
            }
            return "/sdcard/";
        } catch (Exception e) {
            return "/sdcard/";
        }
    }
}
