package com.byazt.ec;

import android.telephony.TelephonyManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, 62})
public class fw {
    public static String pr(TelephonyManager telephonyManager) throws SecurityException {
        if (w.hw) {
            w.pr("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }
}
