package com.byazt.nc;

import android.util.SparseArray;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 19})
public class n {
    public static Function<SparseArray<Object>, Object> n;

    public static void n(Function<SparseArray<Object>, Object> function) {
        n = function;
    }

    public static void n(boolean z) {
        if (n != null) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
            qgVarN.n(10000).n(Boolean.class);
            qgVarN.n(AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, Boolean.valueOf(z));
            n.apply(qgVarN.qg());
        }
    }
}
