package com.byazt.ie;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_HIJACK_EXIT, 101})
public class fs implements n {
    public int n = 0;

    @Override // com.byazt.ie.n
    public void n(n.InterfaceC0201n interfaceC0201n) {
        String strF = interfaceC0201n.n().cy().f();
        com.byazt.qn.qg qgVarWm = interfaceC0201n.n().wm();
        boolean zH = interfaceC0201n.n().h();
        if (com.byazt.qa.q.n().s(strF, qgVarWm.l())) {
            boolean z = com.byazt.qa.q.n().n(strF) == null;
            if (!zH && !z && n(strF, qgVarWm, interfaceC0201n.n())) {
                interfaceC0201n.n().q(true);
                n(qgVarWm, strF, interfaceC0201n.n().cy(), interfaceC0201n.n());
                return;
            }
            com.byazt.qa.q.n().n(strF, qgVarWm);
        }
        interfaceC0201n.n(interfaceC0201n.n());
    }

    private boolean n(String str, com.byazt.qn.qg qgVar, com.byazt.zb.qg qgVar2) {
        List<com.byazt.qa.x> listQ;
        com.byazt.ws.qg qgVarCy = qgVar2.cy();
        if (com.byazt.qa.q.n().n(str, qgVar, qgVarCy != null ? qgVarCy.rf() : null) && (listQ = com.byazt.qa.q.n().q(str)) != null && listQ.size() > 0) {
            for (com.byazt.qa.x xVar : listQ) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(xVar.n);
                qgVar2.qg(arrayList);
            }
            if (qgVar2.cp().size() > 0 || qgVar2.sz().size() > 0 || qgVar2.d().size() > 0) {
                com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(str) + "--==-- hit cache!!! -----");
                return true;
            }
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, com.byazt.rb.q.n(str) + "--==-- not hit cache!!! -----");
        return false;
    }

    private void n(com.byazt.qn.qg qgVar, String str, com.byazt.ws.qg qgVar2, final com.byazt.zb.qg qgVar3) {
        com.byazt.qn.qg qgVarQg = com.byazt.qa.q.n().qg(str);
        if (qgVarQg != null) {
            qgVar.n(qgVarQg.n());
            qgVar.qg(qgVarQg.s());
        }
        com.byazt.qa.q.n().n(str, qgVar);
        com.byazt.gp.s.n(qgVar3.wm(), qgVar2.rf(), !qgVar3.h(), qgVar3.fi().n, 0, (Map<String, Object>) null);
        com.byazt.sg.s sVar = null;
        com.byazt.yc.n.n(qgVar3, null, false);
        com.byazt.qa.qg qgVarS = com.byazt.qa.q.n().s(str);
        if (qgVarS != null) {
            qgVar3.n(qgVarS.q() != null ? qgVarS.q().fi() : null);
            qgVar3.n(qgVarS.e_());
        }
        final int iQg = com.byazt.qa.q.n().qg(str, qgVar.l());
        if (iQg == 2) {
            this.n = 1;
            qgVar3.n(1);
            qgVar3.fs();
            return;
        }
        if (iQg == 3 || iQg == 4) {
            long jL = com.byazt.qa.q.l(str);
            long jCurrentTimeMillis = System.currentTimeMillis() - jL;
            if (jL != -1 && jCurrentTimeMillis < qgVar2.x()) {
                com.byazt.rb.qg.qg(MediationConstant.TAG, "--==-- 预缓存补充请求无需发起，时间间隔不够，interval：" + jCurrentTimeMillis + ", config interval: " + qgVar2.x());
                this.n = 3;
                qgVar3.n(3);
                qgVar3.fs();
                return;
            }
            List<com.byazt.sg.s> listN = qgVar3.n(false);
            if (listN != null && listN.size() > 0) {
                sVar = listN.get(0);
            }
            com.byazt.sg.s sVar2 = sVar;
            final double dN = n(str, qgVar.um());
            if (sVar2 != null && !sVar2.qn() && sVar2.ta() < dN) {
                com.byazt.qa.q.n().n(qgVar3.getContext(), str, iQg, qgVar, sVar2, new com.byazt.qa.q.s() { // from class: com.byazt.ie.fs.1
                    @Override // com.byazt.qa.q.s
                    public void n(String str2, boolean z, int i, List<com.byazt.sg.s> list) {
                        fs.this.n(str2, z, i, list, iQg, dN, qgVar3);
                    }
                });
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "--==-- 预缓存补充请求无需发起，已经命中最优");
            this.n = 4;
            qgVar3.n(4);
            qgVar3.fs();
            return;
        }
        com.byazt.rb.qg.q(MediationConstant.TAG, "--==-- 预缓存reqType错误：reqType = ".concat(String.valueOf(iQg)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, boolean z, int i, List<com.byazt.sg.s> list, int i2, double d, com.byazt.zb.qg qgVar) {
        if (z) {
            if (i2 == 4) {
                com.byazt.sg.s sVar = (list == null || list.size() <= 0) ? null : list.get(0);
                if (sVar != null && sVar.ta() >= d) {
                    this.n = 6;
                } else {
                    this.n = 7;
                }
            } else if (i2 == 3) {
                this.n = 5;
            }
        } else if (i == 10003) {
            this.n = 9;
        } else if (i == 10086) {
            this.n = 8;
        }
        qgVar.n(this.n);
        qgVar.qg(list);
        com.byazt.rb.qg.q(MediationConstant.TAG, "--==-- 预缓存补充请求结束，对外给出回调");
        qgVar.fs();
    }

    private double n(String str, int i) {
        com.byazt.ws.qg qgVarN = com.byazt.ir.q.n().n(str, i, 102);
        double dM = 0.0d;
        if (qgVarN == null) {
            return 0.0d;
        }
        for (com.byazt.ws.tj tjVar : qgVarN.y()) {
            if (tjVar.fi() && tjVar.m() > dM) {
                dM = tjVar.m();
            }
        }
        return dM;
    }

    @Override // com.byazt.ie.n
    public void qg(n.InterfaceC0201n interfaceC0201n) {
        interfaceC0201n.n((String) null);
    }
}
