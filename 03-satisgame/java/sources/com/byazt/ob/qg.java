package com.byazt.ob;

import android.os.SystemClock;
import com.byazt.ws.tj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1645, 26})
public class qg implements n {
    @Override // com.byazt.ob.n
    public void n(n.InterfaceC0279n interfaceC0279n) {
        com.byazt.dd.qg qgVarN = interfaceC0279n.n();
        com.byazt.zb.qg qgVarQg = interfaceC0279n.qg();
        tj tjVarFs = qgVarN.fs();
        if (tjVarFs == null) {
            com.byazt.mj.n nVar = new com.byazt.mj.n(840040, com.byazt.mj.n.n(840040));
            nVar.n("is_dex_adapter", Integer.valueOf(qgVarN.fi() ? 1 : 0));
            com.byazt.gp.s.n(tjVarFs, qgVarQg.wm(), "", qgVarN.l(), 2, qgVarN.s(), qgVarN.x(), qgVarN.w(), nVar, -1L, qgVarQg.fi().l, false, SystemClock.elapsedRealtime() - qgVarQg.an());
            com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.n(tjVarFs), qgVarQg.an());
            com.byazt.gp.s.n(nVar, qgVarQg.wm(), tjVarFs, qgVarN.s(), qgVarN.x(), qgVarN.w(), "", 0L, (String) null, (String) null, (String) null, 0L);
            com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.s(tjVarFs), qgVarQg.an());
            qgVarN.n(nVar, tjVarFs);
            return;
        }
        interfaceC0279n.n(this);
    }
}
