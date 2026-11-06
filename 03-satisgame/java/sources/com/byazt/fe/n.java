package com.byazt.fe;

import android.text.TextUtils;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1128, 19})
public class n {
    public static int n = 4;
    public static AbstractC0173n qg;

    /* JADX INFO: renamed from: com.byazt.fe.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1128, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    public static abstract class AbstractC0173n {
    }

    public static void n(int i) {
        n = i;
    }

    public static boolean n() {
        return n <= 3;
    }

    public static void n(String str, String str2) {
        if (str2 == null || qg == null) {
            return;
        }
        qg(str);
    }

    public static void n(String str) {
        qg("DownloaderLogger", str);
    }

    public static String qg(String str) {
        return !TextUtils.isEmpty(str) ? "Downloader-" + str : "DownloaderLogger";
    }

    public static void qg(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (n <= 3) {
            qg(str);
        }
        if (qg != null) {
            qg(str);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (n <= 3) {
            qg(str);
        }
        if (qg != null) {
            qg(str);
        }
    }

    public static void s(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (n <= 4) {
            qg(str);
        }
        if (qg != null) {
            qg(str);
        }
    }

    public static void s(String str) {
        q("DownloaderLogger", str);
    }

    public static void q(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (n <= 5) {
            qg(str);
        }
        if (qg != null) {
            qg(str);
        }
    }

    public static void l(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (n <= 6) {
            k.qg(qg(str), str2);
        }
        if (qg != null) {
            qg(str);
        }
    }

    public static void qg(String str, String str2, Throwable th) {
        if (str2 == null && th == null) {
            return;
        }
        if (n <= 6) {
            k.n(qg(str), str2, th);
        }
        if (qg != null) {
            qg(str);
        }
    }
}
