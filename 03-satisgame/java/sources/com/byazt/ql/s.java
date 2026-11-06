package com.byazt.ql;

import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.gct.ta;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 8})
public class s {
    public static boolean n(pk pkVar) {
        if (ta.d(pkVar)) {
            if (cd.n(pkVar)) {
                return cd.qg(pkVar);
            }
            if (!pk.s(pkVar)) {
                return true;
            }
        }
        return false;
    }
}
