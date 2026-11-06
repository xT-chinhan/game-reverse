package com.byazt.lpr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 26})
public class qg {
    public static Boolean n;

    private static boolean n() {
        if (n == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.mediation.MediationConstant$BiddingLossReason");
                n = Boolean.TRUE;
            } catch (Throwable unused) {
                n = Boolean.FALSE;
            }
        }
        return n.booleanValue();
    }

    public static Object n(int i) {
        if (!n()) {
            return Integer.valueOf(i);
        }
        try {
            if (i == 1) {
                return MediationConstant.BiddingLossReason.LOW_PRICE;
            }
            if (i == 2) {
                return MediationConstant.BiddingLossReason.TIME_OUT;
            }
            if (i == 3) {
                return MediationConstant.BiddingLossReason.NO_AD;
            }
            if (i == 4) {
                return MediationConstant.BiddingLossReason.AD_DATA_ERROR;
            }
            if (i != 10001) {
                return null;
            }
            return MediationConstant.BiddingLossReason.OTHER;
        } catch (Throwable unused) {
            return null;
        }
    }
}
