package com.byazt.wt;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 62})
public class fw {
    public static boolean pr() {
        try {
            if (com.byazt.sd.zo.nt().ii()) {
                return true;
            }
            Context context = com.byazt.sd.a.getContext();
            return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void pr(com.byazt.qe.pr prVar) {
        try {
            if (prVar.zo() && !com.byazt.ca.ho.pr()) {
                System.currentTimeMillis();
                if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                    com.byazt.ca.ho.hw();
                    com.byazt.o.hw.pr();
                    com.byazt.hs.hn.hw();
                    com.byazt.it.hw.pr().pr(true);
                }
            }
        } catch (Exception e) {
        }
    }
}
