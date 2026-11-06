package com.byazt.em;

import android.text.TextUtils;
import com.byazt.qa.x;
import com.byazt.qn.qg;
import com.byazt.sg.s;
import com.byazt.vy.wm;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1323, 19})
public class n {
    public static volatile n qg;
    public final Map<Integer, CopyOnWriteArrayList<x>> n = new ConcurrentHashMap();
    public final Comparator<x> s = new Comparator<x>() { // from class: com.byazt.em.n.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(x xVar, x xVar2) {
            if (xVar != null && xVar2 != null && xVar.n != null && xVar2.n != null) {
                if (xVar.n.xi() > xVar2.n.xi()) {
                    return -1;
                }
                if (xVar.n.xi() < xVar2.n.xi()) {
                    return 1;
                }
                if (xVar.n.xi() == xVar2.n.xi() && xVar.n.he() == 1) {
                    return -1;
                }
            }
            return 0;
        }
    };

    private n() {
    }

    public static n n() {
        if (qg == null) {
            synchronized (n.class) {
                if (qg == null) {
                    qg = new n();
                }
            }
        }
        return qg;
    }

    public synchronized void n(qg qgVar, List<s> list) {
        if (com.byazt.qt.qg.n().rv()) {
            if (qgVar == null) {
                return;
            }
            if (qgVar.nf()) {
                return;
            }
            com.byazt.rb.qg.q(MediationConstant.TAG, "广告位：" + qgVar.a() + "  type:" + qgVar.um() + " show后把二价广告放入公共缓存池 数量：" + (list == null ? "没有二价" : Integer.valueOf(list.size())));
            if (qgVar != null && list != null && !list.isEmpty()) {
                CopyOnWriteArrayList<x> copyOnWriteArrayList = this.n.get(Integer.valueOf(qgVar.um()));
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                }
                for (s sVar : list) {
                    com.byazt.rb.qg.q(MediationConstant.TAG, "广告位：" + qgVar.a() + "  代码位：" + sVar.el() + "   adnName:" + sVar.ci() + "  loadSort:" + sVar.la() + "  showSort:" + sVar.il() + "  ecpm:" + sVar.ta());
                    if (!n(copyOnWriteArrayList, sVar)) {
                        copyOnWriteArrayList.add(new x(sVar, 0L, qgVar));
                    }
                }
                for (x xVar : copyOnWriteArrayList) {
                    if (!xVar.l()) {
                        copyOnWriteArrayList.remove(xVar);
                    }
                }
                wm.n(copyOnWriteArrayList, this.s);
                while (3 < copyOnWriteArrayList.size()) {
                    copyOnWriteArrayList.remove(3);
                }
                com.byazt.rb.qg.q(MediationConstant.TAG, "广告位：" + qgVar.a() + "  type:" + qgVar.um() + "  公共缓存池二价广告的数量：" + copyOnWriteArrayList.size());
                this.n.put(Integer.valueOf(qgVar.um()), copyOnWriteArrayList);
            }
        }
    }

    public synchronized List<x> n(qg qgVar) {
        if (qgVar == null) {
            return null;
        }
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.n.get(Integer.valueOf(qgVar.um()));
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
            int iM = qgVar.um() == 5 ? qgVar.m() : 1;
            ArrayList arrayList = new ArrayList();
            for (x xVar : copyOnWriteArrayList) {
                if (arrayList.size() >= iM) {
                    break;
                }
                if (xVar.x() && xVar.n != null) {
                    com.byazt.rb.qg.qg(MediationConstant.TAG, "--==-- 公共缓存池，广告：" + xVar.qg() + "  adnName:" + xVar.n.ci() + " showSort:" + xVar.n.il() + " 暂不可用， 已经被使用中...");
                }
                if (n(qgVar, xVar.q(), xVar.n) && xVar.l() && !xVar.x()) {
                    arrayList.add(xVar);
                    copyOnWriteArrayList.remove(xVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((x) it.next()).qg(true);
            }
            return arrayList;
        }
        return null;
    }

    public static List<s> n(qg qgVar, List<s> list, List<s> list2) {
        if (!com.byazt.qt.qg.n().rv() || qgVar == null || list == null || list.isEmpty() || list2 == null || list2.isEmpty()) {
            return null;
        }
        int iM = qgVar.um() == 5 ? qgVar.m() : 1;
        ArrayList arrayList = new ArrayList();
        for (s sVar : list2) {
            if (!qg(list, sVar)) {
                if (arrayList.size() >= iM) {
                    break;
                }
                if (!sVar.rg() && !sVar.dm() && (!sVar.ze() || sVar.xi() > 0.0d)) {
                    arrayList.add(sVar);
                }
            }
        }
        return arrayList;
    }

    private boolean n(List<x> list, s sVar) {
        for (x xVar : list) {
            if (xVar != null && sVar != null && xVar.n == sVar) {
                return true;
            }
        }
        return false;
    }

    private static boolean qg(List<s> list, s sVar) {
        for (s sVar2 : list) {
            if (sVar != null && sVar2 == sVar) {
                return true;
            }
        }
        return false;
    }

    private boolean n(qg qgVar, qg qgVar2, s sVar) {
        if (qgVar == null || qgVar2 == null || sVar == null || qgVar.um() != qgVar2.um()) {
            return false;
        }
        if ((qgVar.um() == 7 || qgVar.um() == 10) && qgVar.ln() == qgVar2.ln()) {
            return true;
        }
        if (qgVar.um() != 3) {
            return (qgVar.um() == 1 || qgVar.um() == 5) && qgVar.ou() == qgVar2.ou() && qgVar.wm() == qgVar2.wm();
        }
        if (TextUtils.equals(MediationConstant.ADN_GDT, sVar.ci())) {
            return (qg(qgVar) && sVar.u() == 2) || !(qg(qgVar) || sVar.u() == 2);
        }
        return true;
    }

    public boolean qg(qg qgVar) {
        Map<String, Object> mapAn;
        if (qgVar == null || (mapAn = qgVar.an()) == null) {
            return false;
        }
        Object obj = mapAn.get("request_half_screen");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void n(qg qgVar, String str) {
        if (TextUtils.isEmpty(str) || qgVar == null) {
            return;
        }
        if (TextUtils.isEmpty(qgVar.tj())) {
            qgVar.s(qgVar.a());
        }
        if (str.equals(qgVar.a())) {
            return;
        }
        com.byazt.zq.qg.n nVar = new com.byazt.zq.qg.n(new com.byazt.zq.qg(qgVar.ae(), com.byazt.vgx.s.qg()));
        nVar.q(str);
        qgVar.n(com.byazt.pch.n.n(nVar.n()));
    }
}
