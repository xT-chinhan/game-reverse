package com.byazt.wx;

import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 106, 37})
public class pr {
    public static int pr = 6;
    public static hw hw = C0227pr.pr();

    public static int pr() {
        return pr;
    }

    public static boolean hw() {
        return pr <= 3;
    }

    public static void pr(String str) {
        pr("Logger", str);
    }

    public static void pr(String str, String str2) {
        if (str2 == null) {
            return;
        }
        hw.pr(3);
    }

    public static void hw(String str, String str2) {
        if (str2 == null) {
            return;
        }
        hw.pr(4);
    }

    public static void hn(String str, String str2) {
        if (str2 == null) {
            return;
        }
        hw.pr(5);
    }

    public static void hw(String str) {
        x("Logger", str);
    }

    public static void x(String str, String str2) {
        if (str2 != null && hw.pr(6)) {
            hw.pr(str, str2);
        }
    }

    public static void pr(String str, String str2, Throwable th) {
        if ((str2 != null || th != null) && hw.pr(6)) {
            hw.pr(str, str2, th);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 106, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    public static abstract class hw {
        public boolean pr(int i) {
            return pr.pr() <= i;
        }

        public void pr(String str, String str2, Throwable th) {
        }

        public void pr(String str, String str2) {
        }
    }

    /* JADX INFO: renamed from: com.byazt.wx.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 106, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0227pr extends hw {
        private C0227pr() {
        }

        public static C0227pr pr() {
            return C0228pr.pr;
        }

        @Override // com.byazt.wx.pr.hw
        public void pr(String str, String str2, Throwable th) {
            ho.pr(str, str2, th);
        }

        @Override // com.byazt.wx.pr.hw
        public void pr(String str, String str2) {
            ho.hw(str, str2);
        }

        /* JADX INFO: renamed from: com.byazt.wx.pr$pr$pr, reason: collision with other inner class name */
        @com.byazt.vzx.pr(pr = {0, 1, 106, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL})
        private static class C0228pr {
            public static final C0227pr pr = new C0227pr();
        }
    }
}
