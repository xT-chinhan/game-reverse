package com.byazt.vy;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1431, 849})
public class ou {
    public static void n(com.byazt.sg.s sVar, com.byazt.ws.tj tjVar, com.byazt.qn.qg qgVar, boolean z) {
        if (sVar == null || !sVar.nk()) {
            return;
        }
        if (tjVar == null) {
            sVar.n(0.0d);
        }
        String strRi = sVar.ri();
        Map<String, String> mapLh = tjVar.lh();
        if (TextUtils.isEmpty(strRi)) {
            if (z) {
                com.byazt.gp.s.n(tjVar, qgVar, sVar, 40061, com.byazt.mj.n.n(40061));
            }
            sVar.oa(com.byazt.mj.n.n(40061));
            sVar.n(0.0d);
            return;
        }
        if (mapLh == null) {
            if (z) {
                com.byazt.gp.s.n(tjVar, qgVar, sVar, 40062, com.byazt.mj.n.n(40062));
            }
            sVar.oa(com.byazt.mj.n.n(40062));
            sVar.n(0.0d);
            return;
        }
        String str = mapLh.get(strRi);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                com.byazt.gp.s.n(tjVar, qgVar, sVar, 40062, com.byazt.mj.n.n(40062));
            }
            sVar.n(0.0d);
        } else {
            try {
                sVar.n(Double.valueOf(str).doubleValue());
            } catch (Exception unused) {
                sVar.n(0.0d);
            }
        }
    }
}
