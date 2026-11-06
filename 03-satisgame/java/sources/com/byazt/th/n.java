package com.byazt.th;

import android.text.TextUtils;
import com.byazt.qa.q;
import com.byazt.ws.qg;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1839, 19})
public class n {
    public static qg n(qg qgVar, String str) {
        if (qgVar == null || TextUtils.isEmpty(str) || qgVar.y() == null || qgVar.y().size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (tj tjVar : qgVar.y()) {
            if (str.equals(tjVar.cd())) {
                arrayList.add(tjVar.l());
                break;
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        tj tjVar2 = arrayList.get(0);
        if (tjVar2 != null && tjVar2.v() && !MediationConstant.ADN_PANGLE.equals(tjVar2.k())) {
            for (tj tjVar3 : qgVar.y()) {
                if (tjVar3.v() && MediationConstant.ADN_PANGLE.equals(tjVar3.k())) {
                    arrayList.add(tjVar3.l());
                    break;
                }
            }
        }
        qg qgVarCd = qgVar.cd();
        if (qgVarCd.sz()) {
            qgVarCd.qg(arrayList);
        } else {
            qgVarCd.n(arrayList);
        }
        tj tjVar4 = arrayList.get(0);
        tjVar4.l(0);
        if (tjVar4.um() == 0) {
            qgVarCd.q(tjVar4.m());
        }
        if (tjVar4.um() == 2) {
            qgVarCd.n(true);
        }
        if (tjVar4.um() == 1 || tjVar4.um() == 3) {
            qgVarCd.qg(true);
        }
        qgVarCd.sz(0);
        q.n().n(qgVarCd.f(), 0);
        com.byazt.ra.n.n().s(qgVarCd.f(), str, 0);
        return qgVarCd;
    }

    public static String n(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith("gm_test_slot_")) {
                return str.substring(13);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
