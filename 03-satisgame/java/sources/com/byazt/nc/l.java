package com.byazt.nc;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 18})
public class l {
    public static void n(com.byazt.qu.n nVar) {
        if (nVar == null) {
            return;
        }
        Function<SparseArray<Object>, Object> functionHu = nVar.hu();
        if (functionHu != null) {
            Object objApply = functionHu.apply(com.byazt.of.qg.n().n(10001).n(Boolean.class).qg());
            if (objApply instanceof Boolean) {
                qg.n(((Boolean) objApply).booleanValue());
            }
        }
        s.n(nVar.h());
        q.n(nVar.t());
        n.n(nVar.ur());
    }
}
