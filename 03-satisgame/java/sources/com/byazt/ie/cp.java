package com.byazt.ie;

import android.os.SystemClock;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 29})
public class cp implements n {
    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        com.byazt.zb.qg qgVarN = interfaceC0201n.n();
        com.byazt.qn.qg qgVarWm = qgVarN.wm();
        qgVarWm.a();
        if (qgVarWm != null && qgVarWm.nf()) {
            String str = com.byazt.rb.q.n(qgVarWm.a()) + "V2 公共缓存池广告请求......";
            String str2 = MediationConstant.TAG;
            com.byazt.rb.qg.q(MediationConstant.TAG, str);
            String strRf = qgVarN.cy() != null ? qgVarN.cy().rf() : null;
            boolean z = !qgVarN.h();
            if (com.byazt.qt.qg.n().rv()) {
                List<com.byazt.qa.x> listN = com.byazt.em.n.n().n(qgVarWm);
                if (listN != null && !listN.isEmpty()) {
                    com.byazt.gp.s.n(listN.get(0).n, qgVarWm, qgVarN.cy(), 0L, qgVarN.fi().n, z, listN != null ? listN.size() : 0, qgVarN.fi().l, false);
                    int size = listN.size() - 1;
                    String strW = null;
                    while (size >= 0) {
                        com.byazt.qa.x xVar = listN.get(size);
                        com.byazt.sg.s sVar = xVar.n;
                        sVar.n(xVar.w());
                        sVar.qg(xVar.q() != null ? xVar.q().n() : null);
                        if (size == 0) {
                            strW = xVar.w();
                        }
                        String str3 = strW;
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(sVar);
                        com.byazt.em.n.n(qgVarWm, xVar.w());
                        com.byazt.qn.qg qgVar = qgVarWm;
                        com.byazt.gp.s.n(com.byazt.qt.qg.n().n(xVar.w(), qgVarWm.um(), 102).w(sVar.el()), qgVarWm, com.byazt.ra.n.n().n(sVar.el()), true, 1, 0, 3, 3, null, -1L, false, false, xVar.q() != null ? xVar.q().n() : null, SystemClock.elapsedRealtime() - qgVarN.an());
                        com.byazt.zo.x.n(qgVarN.s(), qgVarN.n(sVar), qgVarN.an());
                        qgVarN.qg(arrayList);
                        com.byazt.gp.s.n(sVar, 0, "adn cache命中", 0L, qgVar, 0, arrayList.size(), 2, (String) null, 0L, -1L);
                        com.byazt.zo.x.n(qgVarN.s(), qgVarN.qg(sVar), qgVarN.an());
                        size--;
                        strW = str3;
                        qgVarWm = qgVar;
                        listN = listN;
                        str2 = str2;
                    }
                    com.byazt.qn.qg qgVar2 = qgVarWm;
                    com.byazt.em.n.n(qgVar2, strW);
                    com.byazt.rb.qg.qg(str2, com.byazt.rb.q.n(qgVar2.a()) + "V2 resetAdLinkInfo......");
                    com.byazt.gp.s.n(qgVar2, strRf, z, qgVarN.fi().n, 0, (Map<String, Object>) null);
                    qgVarN.fs();
                    return;
                }
                com.byazt.rb.qg.qg(MediationConstant.TAG, com.byazt.rb.q.n(qgVarWm.a()) + "V2 has no share cache......");
                if (com.byazt.qt.qg.n().tj()) {
                    interfaceC0201n.n(interfaceC0201n.n());
                    return;
                }
                com.byazt.em.n.n(qgVarWm, "-1");
                com.byazt.pu.n nVar = new com.byazt.pu.n(41008, com.byazt.mj.n.n(41008));
                com.byazt.gp.s.n(qgVarWm, strRf, z, qgVarN.fi().n, nVar.n, (Map<String, Object>) null);
                qgVarN.n(nVar);
                return;
            }
            com.byazt.em.n.n(qgVarWm, "-2");
            com.byazt.pu.n nVar2 = new com.byazt.pu.n(41007, com.byazt.mj.n.n(41007));
            com.byazt.gp.s.n(qgVarWm, strRf, z, qgVarN.fi().n, nVar2.n, (Map<String, Object>) null);
            qgVarN.n(nVar2);
            return;
        }
        interfaceC0201n.n(interfaceC0201n.n());
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        interfaceC0201n.n((String) null);
    }
}
