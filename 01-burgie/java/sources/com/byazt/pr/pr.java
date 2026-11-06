package com.byazt.pr;

import android.util.SparseArray;
import com.byazt.eyv.AdBaseConstants;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 37, 37})
public class pr {
    public static Function<SparseArray<Object>, Object> pr;

    public static void pr(Function<SparseArray<Object>, Object> function) {
        pr = function;
    }

    public static void pr(boolean z) {
        if (pr != null) {
            com.byazt.xi.hw hwVarPr = com.byazt.xi.hw.pr();
            hwVarPr.pr(10000).pr(Void.class);
            hwVarPr.pr(AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, Boolean.valueOf(z));
            pr.apply(hwVarPr.hw());
        }
    }
}
