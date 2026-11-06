package com.byazt.uq;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL, 101})
public final class fs {
    public static volatile String n;

    public static void n(String str) {
        com.byazt.gwu.s sVarN;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String strOu = com.byazt.vyf.s.cy().ou();
            if (TextUtils.isEmpty(strOu) || (sVarN = com.byazt.lk.l.n(strOu, "openadsdk_c_name")) == null) {
                return;
            }
            sVarN.n("c_c_t_n", str);
        } catch (Throwable unused) {
        }
    }

    public static String n() {
        com.byazt.gwu.s sVarN;
        if (!TextUtils.isEmpty(n)) {
            return n;
        }
        try {
            String strOu = com.byazt.vyf.s.cy().ou();
            if (TextUtils.isEmpty(strOu) || (sVarN = com.byazt.lk.l.n(strOu, "openadsdk_c_name")) == null) {
                return null;
            }
            String strQg = sVarN.qg("c_c_t_n", (String) null);
            if (!TextUtils.isEmpty(strQg)) {
                n = strQg;
            }
        } catch (Throwable unused) {
        }
        return n;
    }
}
