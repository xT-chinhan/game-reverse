package com.byazt.yc;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 965, 19})
public class n {
    public static void n(com.byazt.zb.qg qgVar, List<com.byazt.sg.s> list, boolean z) {
        if (qgVar == null) {
            return;
        }
        com.byazt.sg.s sVarN = n(list);
        if (qgVar.f()) {
            return;
        }
        qgVar.s(SystemClock.elapsedRealtime());
        com.byazt.gp.s.n(sVarN, qgVar.wm(), qgVar.cy(), qgVar.ae() - qgVar.an(), qgVar.fi().n, !qgVar.h(), list != null ? list.size() : 0, qgVar.fi().l, z);
        qgVar.l(true);
    }

    private static com.byazt.sg.s n(List<com.byazt.sg.s> list) {
        com.byazt.sg.s sVar = null;
        if (list != null && list.size() != 0) {
            for (com.byazt.sg.s sVar2 : list) {
                if (sVar == null || sVar2.e() < sVar.e()) {
                    sVar = sVar2;
                }
            }
        }
        return sVar;
    }
}
