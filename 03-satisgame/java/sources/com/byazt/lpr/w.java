package com.byazt.lpr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdLoadType;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 13})
public class w {
    public static Boolean n;

    public static int n(int i) {
        if (i == 1 || i == 3) {
            return i;
        }
        return -1;
    }

    private static boolean n() {
        if (n == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdLoadType");
                n = Boolean.TRUE;
            } catch (Throwable unused) {
                n = Boolean.FALSE;
            }
        }
        return n.booleanValue();
    }

    public static int n(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (n()) {
            try {
                if (TTAdLoadType.LOAD == obj) {
                    return 3;
                }
                if (TTAdLoadType.PRELOAD == obj) {
                    return 1;
                }
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
