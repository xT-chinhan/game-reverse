package com.byazt.lpr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 19})
public class n {
    public static Boolean n;

    private static boolean n() {
        if (n == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$AdIsReadyStatus");
                n = Boolean.TRUE;
            } catch (Throwable unused) {
                n = Boolean.FALSE;
            }
        }
        return n.booleanValue();
    }

    public static Integer n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        try {
            if (n()) {
                if (obj == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
                    return 1;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_READY) {
                    return 2;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_EXPIRED) {
                    return 3;
                }
                if (obj == MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY) {
                    return 4;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
