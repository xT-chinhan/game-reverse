package com.byazt.nt;

import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 19})
public class n {
    public static int n = 6;
    public static qg qg = C0275n.n();

    public static int n() {
        return n;
    }

    public static boolean qg() {
        return n <= 3;
    }

    public static void n(String str) {
        n("Logger", str);
    }

    public static void n(String str, String str2) {
        if (str2 == null) {
            return;
        }
        qg.n(3);
    }

    public static void qg(String str, String str2) {
        if (str2 == null) {
            return;
        }
        qg.n(4);
    }

    public static void s(String str, String str2) {
        if (str2 == null) {
            return;
        }
        qg.n(5);
    }

    public static void qg(String str) {
        q("Logger", str);
    }

    public static void q(String str, String str2) {
        if (str2 != null && qg.n(6)) {
            qg.n(str, str2);
        }
    }

    public static void n(String str, String str2, Throwable th) {
        if (!(str2 == null && th == null) && qg.n(6)) {
            qg.n(str, str2, th);
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 226})
    public static abstract class qg {
        public void n(String str, String str2) {
        }

        public void n(String str, String str2, Throwable th) {
        }

        public boolean n(int i) {
            return n.n() <= i;
        }
    }

    /* JADX INFO: renamed from: com.byazt.nt.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0275n extends qg {
        private C0275n() {
        }

        public static C0275n n() {
            return C0276n.n;
        }

        @Override // com.byazt.nt.n.qg
        public void n(String str, String str2, Throwable th) {
            k.n(str, str2, th);
        }

        @Override // com.byazt.nt.n.qg
        public void n(String str, String str2) {
            k.qg(str, str2);
        }

        /* JADX INFO: renamed from: com.byazt.nt.n$n$n, reason: collision with other inner class name */
        @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME, 512})
        private static class C0276n {
            public static final C0275n n = new C0275n();
        }
    }
}
