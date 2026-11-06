package com.byazt.hoz;

import android.util.SparseArray;
import com.byazt.lk.l;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 424, 26})
public class qg {
    public static com.byazt.gwu.s n;

    private static void qg() {
        if (n == null) {
            n = l.qg(com.byazt.vgx.s.q(), "csj_live", 0, com.byazt.p001if.n.n());
        }
    }

    public static void n(String str) {
        qg();
        try {
            com.byazt.gwu.s sVar = n;
            if (sVar != null) {
                n.n("live_init_".concat(String.valueOf(str)), sVar.qg("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void qg(String str) {
        qg();
        try {
            com.byazt.gwu.s sVar = n;
            if (sVar != null) {
                sVar.n("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean s(String str) {
        qg();
        com.byazt.gwu.s sVar = n;
        return (sVar != null ? sVar.qg("live_init_".concat(String.valueOf(str)), 0) : 0) < 5;
    }

    public static void q(String str) {
        n();
        qg(str);
    }

    public static void n() {
        try {
            Function<SparseArray<Object>, Object> functionW = com.byazt.vyf.s.cy().w(4);
            if (functionW != null) {
                functionW.apply(com.byazt.of.qg.n().n(100).n(Void.class).n(0, "com.byted.live.lite").qg());
            }
        } catch (Throwable unused) {
        }
    }
}
