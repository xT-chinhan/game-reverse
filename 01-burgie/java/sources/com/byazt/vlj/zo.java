package com.byazt.vlj;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_PRESENTATION_ID, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo {
    public static com.byazt.sds.pr c;
    public static long hw;
    public static Context pr;
    public static volatile int vk;
    public static volatile String w;
    public static volatile ConcurrentHashMap<Integer, String> zo;
    public static String hn = "default";
    public static boolean x = false;
    public static com.byazt.sds.hw uc = new com.byazt.sds.hw();
    public static hw fw = new hw();
    public static com.byazt.sds.zo aj = null;

    public static com.byazt.sds.pr pr() {
        return c;
    }

    public static hw hw() {
        return fw;
    }

    public static com.byazt.sds.zo hn() {
        if (aj == null) {
            synchronized (zo.class) {
                aj = new com.byazt.sds.zo(pr);
            }
        }
        return aj;
    }

    public static void pr(Context context, c cVar) {
        hw = System.currentTimeMillis();
        pr = context;
        c = new com.byazt.sds.pr(context, cVar);
    }

    public static Context x() {
        return pr;
    }

    public static com.byazt.sds.hw c() {
        return uc;
    }

    public static long uc() {
        return hw;
    }

    public static String fw() {
        return hn;
    }

    public static boolean zo() {
        return x;
    }

    public static ConcurrentHashMap<Integer, String> aj() {
        return zo;
    }

    public static int vk() {
        return vk;
    }

    public static String w() {
        return w;
    }
}
