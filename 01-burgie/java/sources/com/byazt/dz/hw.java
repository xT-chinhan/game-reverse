package com.byazt.dz;

import android.util.SparseArray;
import com.byazt.cr.c;
import com.byazt.sd.zo;
import com.byazt.wt.y;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 903, 13})
public class hw {
    public static c pr;

    private static void hw() {
        if (pr == null) {
            pr = y.pr("csj_live");
        }
    }

    public static void pr(String str) {
        hw();
        try {
            c cVar = pr;
            if (cVar != null) {
                pr.pr("live_init_".concat(String.valueOf(str)), cVar.hw("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable th) {
        }
    }

    public static void hw(String str) {
        hw();
        try {
            c cVar = pr;
            if (cVar != null) {
                cVar.pr("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable th) {
        }
    }

    public static boolean hn(String str) {
        hw();
        c cVar = pr;
        return (cVar != null ? cVar.hw("live_init_".concat(String.valueOf(str)), 0) : 0) < 5;
    }

    public static void x(String str) {
        pr();
        hw(str);
    }

    public static void pr() {
        try {
            Function<SparseArray<Object>, Object> functionUc = zo.nt().uc(4);
            if (functionUc != null) {
                functionUc.apply(com.byazt.xi.hw.pr().pr(100).pr(Void.class).pr(0, "com.byted.live.lite").hw());
            }
        } catch (Throwable th) {
        }
    }
}
