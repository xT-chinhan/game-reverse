package com.byazt.ob;

import android.os.SystemClock;
import com.byazt.ws.tj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1645, 21})
public class x implements n {
    @Override // com.byazt.ob.n
    public void n(n.InterfaceC0279n interfaceC0279n) {
        com.byazt.yc.l.n nVarN;
        com.byazt.zb.qg qgVarQg = interfaceC0279n.qg();
        com.byazt.dd.qg qgVarN = interfaceC0279n.n();
        if (qgVarQg != null && qgVarN != null) {
            com.byazt.qn.qg qgVarWm = qgVarQg.wm();
            tj tjVarFs = qgVarN.fs();
            if (qgVarWm != null && tjVarFs != null && (nVarN = com.byazt.yc.l.n(qgVarWm, tjVarFs)) != null) {
                com.byazt.mj.n nVar = new com.byazt.mj.n(81018, nVarN.n);
                nVar.n("is_dex_adapter", Integer.valueOf(qgVarN.fi() ? 1 : 0));
                com.byazt.gp.s.n(tjVarFs, qgVarWm, com.byazt.ra.n.n().n(tjVarFs.cd()), qgVarN.l(), 2, qgVarN.s(), qgVarN.x(), qgVarN.w(), nVar, -1L, false, false, SystemClock.elapsedRealtime() - qgVarQg.an());
                com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.n(tjVarFs), qgVarQg.an());
                com.byazt.gp.s.n(nVar, qgVarWm, tjVarFs, qgVarN.s(), qgVarN.x(), qgVarN.w(), com.byazt.ra.n.n().n(tjVarFs.cd()), 0L, (String) null, (String) null, (String) null, 0L);
                com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.s(tjVarFs), qgVarQg.an());
                qgVarN.n(nVar, tjVarFs);
                return;
            }
        }
        interfaceC0279n.n(this);
    }
}
