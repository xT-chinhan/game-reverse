package com.byazt.ob;

import android.os.SystemClock;
import android.util.Pair;
import com.byazt.bf.cp;
import com.byazt.bf.d;
import com.byazt.bf.rv;
import com.byazt.bf.sz;
import com.byazt.ws.tj;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1645, 5})
public class q implements n {
    @Override // com.byazt.ob.n
    public void n(n.InterfaceC0279n interfaceC0279n) {
        com.byazt.mj.n nVar;
        com.byazt.mj.n nVar2;
        com.byazt.dd.qg qgVarN = interfaceC0279n.n();
        com.byazt.zb.qg qgVarQg = interfaceC0279n.qg();
        tj tjVarFs = qgVarN.fs();
        String strA = qgVarQg.wm().a();
        if (tjVarFs != null) {
            if (tjVarFs.q() && !cp.n().s(strA, tjVarFs.cd())) {
                com.byazt.rb.qg.q("TMe", "adn 请求触发次数拦截............");
                Pair<String, String> pairN = cp.n().n(strA, tjVarFs.cd());
                if (pairN != null) {
                    nVar2 = new com.byazt.pu.qg(41041, com.byazt.mj.n.n(41041), (String) pairN.second, (String) pairN.first);
                } else {
                    nVar2 = new com.byazt.mj.n(41041, com.byazt.mj.n.n(41041));
                }
                com.byazt.mj.n nVar3 = nVar2;
                com.byazt.gp.s.n(tjVarFs, qgVarQg.wm(), com.byazt.ra.n.n().n(tjVarFs.cd()), qgVarN.l(), 2, qgVarN.s(), qgVarN.x(), qgVarN.w(), nVar3, -1L, qgVarQg.fi().l, false, SystemClock.elapsedRealtime() - qgVarQg.an());
                com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.n(tjVarFs), qgVarQg.an());
                com.byazt.gp.s.n(nVar3, qgVarQg.wm(), tjVarFs, qgVarN.s(), qgVarN.x(), qgVarN.w(), com.byazt.ra.n.n().n(tjVarFs.cd()), 0L, (String) null, (String) null, (String) null, 0L);
                com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.s(tjVarFs), qgVarQg.an());
                qgVarN.n(nVar3, tjVarFs);
                return;
            }
            if (tjVarFs.q() && !d.n().s(strA, tjVarFs.cd())) {
                com.byazt.rb.qg.q("TMe", "adn 请求触发时间间隔拦截............");
                rv rvVarQ = d.n().q(strA, tjVarFs.cd());
                if (rvVarQ != null) {
                    nVar = new com.byazt.pu.s(41042, com.byazt.mj.n.n(41042), new StringBuilder().append(d.n().n(strA, tjVarFs.cd())).toString(), rvVarQ.tj());
                } else {
                    nVar = new com.byazt.mj.n(41042, com.byazt.mj.n.n(41042));
                }
                com.byazt.mj.n nVar4 = nVar;
                com.byazt.gp.s.n(tjVarFs, qgVarQg.wm(), com.byazt.ra.n.n().n(tjVarFs.cd()), qgVarN.l(), 2, qgVarN.s(), qgVarN.x(), qgVarN.w(), nVar4, -1L, qgVarQg.fi().l, false, SystemClock.elapsedRealtime() - qgVarQg.an());
                com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.n(tjVarFs), qgVarQg.an());
                com.byazt.gp.s.n(nVar4, qgVarQg.wm(), tjVarFs, qgVarN.s(), qgVarN.x(), qgVarN.w(), com.byazt.ra.n.n().n(tjVarFs.cd()), 0L, (String) null, (String) null, (String) null, 0L);
                com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.s(tjVarFs), qgVarQg.an());
                qgVarN.n(nVar4, tjVarFs);
                return;
            }
            if (sz.n().n(strA, tjVarFs.hd())) {
                com.byazt.mj.n nVarN = sz.n().n(strA, tjVarFs.k(), tjVarFs.cd());
                if (nVarN != null) {
                    com.byazt.rb.qg.q("TMe", "adn 请求触发了rit级别的错误码拦截............");
                    com.byazt.gp.s.n(tjVarFs, qgVarQg.wm(), com.byazt.ra.n.n().n(tjVarFs.cd()), qgVarN.l(), 2, qgVarN.s(), qgVarN.x(), qgVarN.w(), nVarN, -1L, qgVarQg.fi().l, false, SystemClock.elapsedRealtime() - qgVarQg.an());
                    com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.n(tjVarFs), qgVarQg.an());
                    com.byazt.gp.s.n(nVarN, qgVarQg.wm(), tjVarFs, qgVarN.s(), qgVarN.x(), qgVarN.w(), com.byazt.ra.n.n().n(tjVarFs.cd()), 0L, (String) null, (String) null, (String) null, 0L);
                    com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.s(tjVarFs), qgVarQg.an());
                    qgVarN.n(nVarN, tjVarFs);
                    return;
                }
            } else {
                com.byazt.mj.n nVarN2 = com.byazt.bf.s.n().n(tjVarFs.k(), tjVarFs.cd());
                if (nVarN2 != null) {
                    com.byazt.rb.qg.q("TMe", "adn 请求触发了错误码拦截............");
                    com.byazt.gp.s.n(tjVarFs, qgVarQg.wm(), com.byazt.ra.n.n().n(tjVarFs.cd()), qgVarN.l(), 2, qgVarN.s(), qgVarN.x(), qgVarN.w(), nVarN2, -1L, qgVarQg.fi().l, false, SystemClock.elapsedRealtime() - qgVarQg.an());
                    com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.n(tjVarFs), qgVarQg.an());
                    com.byazt.gp.s.n(nVarN2, qgVarQg.wm(), tjVarFs, qgVarN.s(), qgVarN.x(), qgVarN.w(), com.byazt.ra.n.n().n(tjVarFs.cd()), 0L, (String) null, (String) null, (String) null, 0L);
                    com.byazt.zo.x.n(qgVarQg.s(), qgVarQg.s(tjVarFs), qgVarQg.an());
                    qgVarN.n(nVarN2, tjVarFs);
                    return;
                }
            }
        }
        interfaceC0279n.n(this);
    }
}
