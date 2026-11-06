package com.byazt.ob;

import android.os.SystemClock;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1645, 13})
public class w implements n {
    @Override // com.byazt.ob.n
    public void n(n.InterfaceC0279n interfaceC0279n) {
        List<com.byazt.qa.x> listN;
        tj tjVarFs = interfaceC0279n.n().fs();
        com.byazt.qn.qg qgVarWm = interfaceC0279n.qg().wm();
        if (tjVarFs != null) {
            String strCd = tjVarFs.cd();
            if (tjVarFs.a() && com.byazt.ra.n.n().q(qgVarWm.a(), strCd, qgVarWm.l())) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "--==-- 广告复用，模式：" + com.byazt.ra.n.n().l(qgVarWm.a(), strCd, qgVarWm.l()));
                int iN = com.byazt.ra.n.n().n(strCd, qgVarWm, true);
                interfaceC0279n.n().s(iN);
                if (iN == 3) {
                    interfaceC0279n.n().n(2);
                    if (n(interfaceC0279n.qg(), interfaceC0279n.n(), qgVarWm, strCd, tjVarFs, 2)) {
                        return;
                    }
                } else if (iN == 2 && (listN = com.byazt.ra.n.n().n(strCd, qgVarWm, qgVarWm.l())) != null && listN.size() > 0) {
                    interfaceC0279n.n().qg(listN.get(0).n.fs(qgVarWm.n()));
                }
            }
        }
        interfaceC0279n.n(this);
    }

    private boolean n(com.byazt.zb.qg qgVar, com.byazt.dd.qg qgVar2, com.byazt.qn.qg qgVar3, String str, tj tjVar, int i) {
        com.byazt.ra.n.n().n(qgVar3.a(), str, tjVar, i);
        List<com.byazt.qa.x> listN = com.byazt.ra.n.n().n(str, qgVar3, qgVar3.l());
        if (listN == null || listN.size() <= 0) {
            return false;
        }
        int iFs = listN.get(0).n.fs(qgVar3.n());
        tj tjVar2 = tjVar;
        com.byazt.gp.s.n(tjVar, qgVar3, com.byazt.ra.n.n().n(str), !qgVar.h(), 1, i, 3, iFs, null, -1L, false, false, SystemClock.elapsedRealtime() - qgVar.an());
        com.byazt.zo.x.n(qgVar.s(), qgVar.n(tjVar2), qgVar.an());
        ArrayList arrayList = new ArrayList();
        for (com.byazt.qa.x xVar : listN) {
            xVar.n.rv(3);
            xVar.n.tj(iFs);
            xVar.n.s(false);
            xVar.n.qg(false);
            com.byazt.yc.w.n(xVar.n, qgVar3.a(), str);
            arrayList.add(xVar.n);
            tjVar2 = tjVar2;
        }
        tj tjVar3 = tjVar2;
        com.byazt.gp.s.n(listN.get(0).n, 0, "adn cache命中", 0L, qgVar3, i, arrayList.size(), 2, (String) null, 0L, -1L);
        com.byazt.zo.x.n(qgVar.s(), qgVar.qg(tjVar3), qgVar.an());
        qgVar2.n(arrayList, tjVar3);
        return true;
    }
}
