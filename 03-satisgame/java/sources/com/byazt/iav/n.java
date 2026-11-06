package com.byazt.iav;

import android.util.SparseArray;
import com.byazt.q.AdBaseConstants;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI, 19})
public class n implements Function<SparseArray<Object>, Object> {
    public static volatile n n;
    public static Function<SparseArray<Object>, Object> qg;

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        return null;
    }

    public static void n(Function<SparseArray<Object>, Object> function) {
        qg = function;
    }

    public static n n() {
        if (n == null) {
            synchronized (n.class) {
                if (n == null) {
                    n = new n();
                }
            }
        }
        return n;
    }

    private n() {
    }

    public void n(String str, String str2) {
        if (qg != null) {
            com.byazt.qvu.n nVarN = com.byazt.qvu.n.n();
            nVarN.n(AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, str);
            nVarN.n(20001, str2);
            nVarN.n(-99999987, 10000);
            nVarN.n(-99999985, Void.class);
            qg.apply(nVarN.qg().sparseArray());
        }
    }
}
