package com.byazt.we;

import android.os.SystemClock;
import com.byazt.bf.cp;
import com.byazt.bf.d;
import com.byazt.bf.s;
import com.byazt.bf.sz;
import com.byazt.qa.x;
import com.byazt.rb.q;
import com.byazt.ws.qg;
import com.byazt.ws.tj;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1655, 19})
public class n {
    public static boolean n(qg qgVar) {
        if (qgVar == null) {
            return false;
        }
        int iFi = qgVar.fi();
        Map<String, Integer> mapZ = com.byazt.qt.qg.n().z();
        if (mapZ == null) {
            return false;
        }
        Integer num = mapZ.get(String.valueOf(iFi));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapZ.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    public static boolean qg(qg qgVar) {
        if (qgVar == null) {
            return false;
        }
        int iFi = qgVar.fi();
        Map<String, Integer> mapDn = com.byazt.qt.qg.n().dn();
        if (mapDn == null) {
            return false;
        }
        Integer num = mapDn.get(String.valueOf(iFi));
        if (num != null) {
            return num.intValue() == 1;
        }
        Integer num2 = mapDn.get("-1");
        return num2 != null && num2.intValue() == 1;
    }

    /* JADX WARN: Code duplicated, block: B:64:0x0137 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:85:0x0054 A[SYNTHETIC] */
    public static boolean n(com.byazt.zb.qg qgVar, List<Integer> list, Map<Integer, List<tj>> map) {
        if (qgVar != null && qgVar.wm() != null) {
            String strA = qgVar.wm().a();
            if (list != null && list.size() != 0 && map != null && map.size() != 0) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    List<tj> list2 = map.get(Integer.valueOf(it.next().intValue()));
                    if (list2 != null && list2.size() != 0) {
                        for (tj tjVar : list2) {
                            if (tjVar != null) {
                                if (tjVar.q() && !cp.n().s(strA, tjVar.cd())) {
                                    com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "adn 请求触发次数拦截............");
                                } else if (tjVar.q() && !d.n().s(strA, tjVar.cd())) {
                                    com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "adn 请求触发时间间隔拦截............");
                                } else if (sz.n().n(strA, tjVar.hd())) {
                                    if (sz.n().n(strA, tjVar.k(), tjVar.cd()) != null) {
                                        com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "adn rit_level 请求触发了错误码拦截............");
                                    } else {
                                        n(qgVar, tjVar, list2.size());
                                        if (qgVar.um()) {
                                            com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "回溯到了满足数量的广告.......有广告回调成功");
                                            return true;
                                        }
                                    }
                                } else if (s.n().n(tjVar.k(), tjVar.cd()) != null) {
                                    com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "adn 请求触发了错误码拦截............");
                                } else {
                                    n(qgVar, tjVar, list2.size());
                                    if (qgVar.um()) {
                                        com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "回溯到了满足数量的广告.......有广告回调成功");
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
                if (qgVar.cp().size() <= 0 && qgVar.d().size() <= 0 && qgVar.sz().size() <= 0) {
                    return false;
                }
                com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "回溯到了广告.......有广告回调成功");
                return true;
            }
        }
        return false;
    }

    public static void n(com.byazt.zb.qg qgVar, tj tjVar, int i) {
        if (qgVar == null || qgVar.wm() == null || tjVar == null) {
            return;
        }
        com.byazt.qn.qg qgVarWm = qgVar.wm();
        String strA = qgVarWm.a();
        com.byazt.rb.qg.qg(MediationConstant.TAG, q.n(strA) + "----------总超时后尝试从复用池中查找广告：id:" + tjVar.cd() + "   loadSort:" + tjVar.h() + "  showSort:" + tjVar.t() + "   adnName:" + tjVar.k());
        String strCd = tjVar.cd();
        if (tjVar.a() && com.byazt.ra.n.n().q(strA, strCd, qgVarWm.l()) && com.byazt.ra.n.n().n(strCd, qgVarWm, true) == 3) {
            com.byazt.rb.qg.qg(MediationConstant.TAG, q.n(strA) + "----------可复用：id:" + tjVar.cd() + "   loadSort:" + tjVar.h() + "  showSort:" + tjVar.t() + "   adnName:" + tjVar.k());
            com.byazt.ra.n.n().n(strA, strCd, tjVar, i);
            List<x> listN = com.byazt.ra.n.n().n(strCd, qgVarWm, qgVarWm.l());
            if (listN == null || listN.size() <= 0) {
                return;
            }
            int iFs = listN.get(0).n.fs(qgVarWm != null ? qgVarWm.n() : null);
            com.byazt.gp.s.n(tjVar, qgVarWm, com.byazt.ra.n.n().n(strCd), !qgVar.h(), 4, i, 3, iFs, null, -1L, qgVar.l(), true, SystemClock.elapsedRealtime() - qgVar.an());
            com.byazt.zo.x.n(qgVar.s(), qgVar.n(tjVar), qgVar.an());
            ArrayList arrayList = new ArrayList();
            for (x xVar : listN) {
                xVar.n.rv(3);
                xVar.n.tj(iFs);
                xVar.n.s(qgVar.l());
                xVar.n.qg(true);
                n(strA, xVar.n, strCd);
                arrayList.add(xVar.n);
            }
            com.byazt.gp.s.n(listN.get(0).n, 0, "adn cache命中", 0L, qgVarWm, i, arrayList.size(), 4, (String) null, 0L, -1L);
            com.byazt.zo.x.n(qgVar.s(), qgVar.qg(tjVar), qgVar.an());
            com.byazt.yc.n.n(qgVar, arrayList, true);
            com.byazt.sg.s sVar = arrayList.get(0);
            if (sVar.qn()) {
                qgVar.qg(arrayList);
                for (com.byazt.sg.s sVar2 : arrayList) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "复用池回溯成功...........回溯到了P层广告_当前P层广告缓存池数量：" + qgVar.cp().size() + ",slotId：" + sVar2.el() + ",广告类型：" + sVar2.lq() + ",loadSort=" + sVar2.la() + ",showSort=" + sVar2.il() + ",CPM=" + sVar2.ta());
                }
                return;
            }
            if (sVar.ze()) {
                qgVar.qg(arrayList);
                for (com.byazt.sg.s sVar3 : arrayList) {
                    com.byazt.rb.qg.n(MediationConstant.TAG, q.n(strA) + "复用池回溯成功...........回溯到了普通层广告_当前普通广告缓存池数量：" + qgVar.d().size() + ",slotId：" + sVar3.el() + ",广告类型：" + sVar3.lq() + ",loadSort=" + sVar3.la() + ",showSort=" + sVar3.il() + ",CPM=" + sVar3.ta());
                }
            }
        }
    }

    private static void n(String str, com.byazt.sg.s sVar, String str2) {
        tj tjVarL = com.byazt.ra.n.n().l(str, str2);
        if (sVar == null || tjVarL == null) {
            return;
        }
        sVar.hd(tjVarL.h());
        sVar.cy(tjVarL.t());
        sVar.k(tjVarL.sz());
        sVar.t(tjVarL.wm());
        sVar.k(tjVarL.um());
        sVar.n(tjVarL.m());
        sVar.l(tjVarL.w());
    }
}
