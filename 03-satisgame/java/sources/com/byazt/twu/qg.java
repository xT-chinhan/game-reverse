package com.byazt.twu;

import android.util.SparseArray;
import com.byazt.q.AdBaseConstants;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1641, 26})
public class qg {
    public static Function<SparseArray<Object>, Object> n;

    public static void n(Function<SparseArray<Object>, Object> function) {
        n = function;
    }

    public static void n(boolean z) {
        if (n != null) {
            com.byazt.of.qg qgVarN = com.byazt.of.qg.n();
            qgVarN.n(10000).n(Void.class);
            qgVarN.n(AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, Boolean.valueOf(z));
            n.apply(qgVarN.qg());
        }
    }
}
