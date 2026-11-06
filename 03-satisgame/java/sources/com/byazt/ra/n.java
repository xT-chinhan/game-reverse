package com.byazt.ra;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.byazt.jp.cp;
import com.byazt.q.AdBaseConstants;
import com.byazt.qa.x;
import com.byazt.rb.l;
import com.byazt.rb.qg;
import com.byazt.sg.s;
import com.byazt.vy.a;
import com.byazt.vy.wm;
import com.byazt.ws.rv;
import com.byazt.ws.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1304, 19})
public class n extends com.byazt.tp.n {
    public static volatile n fs;
    public final String[] n = {MediationConstant.ADN_UNITY, MediationConstant.ADN_KS};
    public final Map<String, Integer> qg = new HashMap();
    public final Map<String, Integer> s = new HashMap();
    public final Map<String, CopyOnWriteArrayList<x>> q = new ConcurrentHashMap();
    public final Map<String, tj> l = new HashMap();
    public final Map<String, String> w = new HashMap();
    public final Map<String, Integer> x = new HashMap();
    public final Comparator<x> rv = new Comparator<x>() { // from class: com.byazt.ra.n.4
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public int compare(x xVar, x xVar2) {
            if (xVar == null || xVar2 == null || xVar.n == null || xVar2.n == null) {
                return 0;
            }
            return ((int) xVar.n.e()) - ((int) xVar2.n.e());
        }
    };

    private n() {
    }

    public static n n() {
        if (fs == null) {
            synchronized (n.class) {
                if (fs == null) {
                    fs = new n();
                }
            }
        }
        return fs;
    }

    public void s(String str, String str2, int i) {
        this.qg.put(str + "_" + str2, Integer.valueOf(i));
    }

    public boolean q(String str, String str2, int i) {
        Integer num;
        return (i == 2 || (num = this.qg.get(new StringBuilder().append(str).append("_").append(str2).toString())) == null || (num.intValue() != 1 && num.intValue() != 2)) ? false : true;
    }

    public int l(String str, String str2, int i) {
        Integer num;
        if (i == 2 || (num = this.qg.get(str + "_" + str2)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void w(String str, String str2, int i) {
        this.s.put(str + "_" + str2, Integer.valueOf(i));
    }

    public boolean s(String str, String str2) {
        Integer num = this.s.get(str + "_" + str2);
        return num != null && num.intValue() == 1;
    }

    public void n(String str, String str2, tj tjVar, int i) {
        if (tjVar != null) {
            this.l.put(str + "_" + str2, tjVar);
        }
        this.x.put(str2, Integer.valueOf(i));
    }

    public void q(String str, String str2) {
        this.w.put(str, str2);
    }

    public tj l(String str, String str2) {
        return this.l.get(str + "_" + str2);
    }

    public String n(String str) {
        return this.w.get(str);
    }

    public void qg() {
        l.n(new Runnable() { // from class: com.byazt.ra.n.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int iM;
                String strA;
                qg.n(MediationConstant.TAG, "--==-- 广告复用lowMemory，start clean");
                int i2 = 0;
                int i3 = 0;
                for (Map.Entry entry : n.this.q.entrySet()) {
                    List<x> list = (List) entry.getValue();
                    if (list != null && list.size() > 0) {
                        qg.n(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理前, 缓存总数: " + list.size());
                        int i4 = 1;
                        int i5 = 0;
                        for (x xVar : list) {
                            if (xVar != null && xVar.n != null) {
                                if (xVar.q() != null) {
                                    strA = xVar.q().a();
                                    iM = xVar.q().m();
                                } else {
                                    iM = i4;
                                    strA = "";
                                }
                                if (xVar.n.nf() || !xVar.n.ae(strA)) {
                                    list.remove(xVar);
                                    i5++;
                                }
                                i4 = iM;
                            }
                        }
                        if (list.size() > i4) {
                            qg.n(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理无效广告后仍需清理，缓存总数: " + list.size() + "，adCount: " + i4 + ", invalidCnt: " + i5);
                            i = 0;
                            for (x xVar2 : list) {
                                if (list.size() <= i4) {
                                    break;
                                }
                                list.remove(xVar2);
                                i++;
                            }
                        } else {
                            i = 0;
                        }
                        qg.n(MediationConstant.TAG, "--==-- 广告复用lowMemory，adnSlotId: " + ((String) entry.getKey()) + ", 清理后，缓存总数: " + list.size() + ", adCount: " + i4 + ", invalidCnt: " + i5 + ", foceCleanCnt：" + i);
                        i2 += i5;
                        i3 += i;
                    }
                    a.n(i2, i3);
                }
            }
        });
    }

    public void n(final String str, final com.byazt.qn.qg qgVar, final Map<String, Object> map, final boolean z, final cp cpVar, final rv rvVar, final Context context) {
        l.n(new Runnable() { // from class: com.byazt.ra.n.2
            @Override // java.lang.Runnable
            public void run() {
                String strLq;
                String strN;
                x xVar;
                List<x> list = (List) n.this.q.get(str);
                ArrayList arrayList = new ArrayList();
                if (list != null && list.size() > 0) {
                    for (x xVar2 : list) {
                        if (xVar2 != null && xVar2.n.nf()) {
                            list.remove(xVar2);
                            arrayList.add(xVar2);
                        }
                    }
                }
                boolean z2 = false;
                if (qg.qg()) {
                    if (arrayList.size() <= 0 || (xVar = (x) arrayList.get(0)) == null) {
                        strLq = "";
                        strN = strLq;
                    } else {
                        strN = com.byazt.sg.n.n(xVar.n.ct(), xVar.n.dg());
                        strLq = xVar.n.lq();
                    }
                    qg.n(MediationConstant.TAG, "--==-- 广告复用:show时缓存移除 -----：" + strLq + ", " + strN + ", " + str + (arrayList.size() > 0 ? ", size: " + arrayList.size() : "移除广告数为0"));
                }
                com.byazt.qn.qg qgVar2 = qgVar;
                String strA = qgVar2 != null ? qgVar2.a() : "";
                com.byazt.qn.qg qgVar3 = qgVar;
                int iUm = qgVar3 != null ? qgVar3.um() : 0;
                com.byazt.qn.qg qgVar4 = qgVar;
                boolean z3 = qgVar4 == null || qgVar4.um() == 1;
                if (!com.byazt.qt.qg.n().n(strA, str, iUm) && z) {
                    z2 = true;
                }
                if (!qgVar.nf() && z2 && !z3 && n.this.s(strA, str)) {
                    n.this.n(str, qgVar, (Map<String, Object>) map, context, cpVar, rvVar);
                } else {
                    qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，因为：已发起waterfall预加载，或feed多广告，或未开启adn预加载，或是banner轮播 --: " + str);
                }
            }
        });
    }

    public void n(final List<s> list, final String str, final com.byazt.qn.qg qgVar, final int i, final s sVar) {
        if (list == null || list.isEmpty() || qgVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        l.n(new Runnable() { // from class: com.byazt.ra.n.3
            @Override // java.lang.Runnable
            public void run() {
                for (Map.Entry entry : n.this.qg(list, str, qgVar, i, sVar).entrySet()) {
                    String str2 = (String) entry.getKey();
                    List<x> list2 = (List) entry.getValue();
                    if (!TextUtils.isEmpty(str2) && list2 != null && list2.size() > 0) {
                        n.this.n(str2, list2, true);
                        qg.q(MediationConstant.TAG, "--==-- 广告复用，show后放回复用池：adnSlotId:" + str2 + ", 个数：" + list2.size());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, List<x>> qg(List<s> list, String str, com.byazt.qn.qg qgVar, int i, s sVar) {
        HashMap map = new HashMap();
        for (s sVar2 : list) {
            if (sVar2 != null && sVar2 != sVar) {
                sVar2.n(false);
            }
            if (sVar2 != null && sVar2 != sVar && l(str, sVar2.el(), i) == 2 && sVar2.ae(str) && !sVar2.nf()) {
                List list2 = (List) map.get(sVar2.el());
                if (list2 == null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new x(sVar2, 0L, qgVar));
                    map.put(sVar2.el(), arrayList);
                } else {
                    list2.add(new x(sVar2, 0L, qgVar));
                }
            }
        }
        return map;
    }

    public void n(String str, List<x> list, boolean z) {
        if (list == null || list.size() <= 0) {
            return;
        }
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.q.get(str);
        if (copyOnWriteArrayList != null) {
            for (x xVar : list) {
                if (!n(copyOnWriteArrayList, xVar)) {
                    copyOnWriteArrayList.add(xVar);
                }
            }
        } else {
            this.q.put(str, new CopyOnWriteArrayList<>(list));
        }
        if (z) {
            wm.n(this.q.get(str), this.rv);
        }
    }

    private boolean n(List<x> list, x xVar) {
        for (x xVar2 : list) {
            if (xVar2 != null && xVar != null && xVar2.n == xVar.n) {
                return true;
            }
        }
        return false;
    }

    public synchronized List<x> n(String str, com.byazt.qn.qg qgVar, int i) {
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.q.get(str);
        if (copyOnWriteArrayList == null) {
            return null;
        }
        int iM = qgVar != null ? qgVar.m() : 1;
        ArrayList arrayList = new ArrayList();
        int iL = l(qgVar != null ? qgVar.a() : "", str, i);
        if (iL == 1) {
            for (int i2 = 0; arrayList.size() < iM && i2 < copyOnWriteArrayList.size(); i2++) {
                if (!copyOnWriteArrayList.get(i2).s() && n(copyOnWriteArrayList.get(i2).q(), qgVar, copyOnWriteArrayList.get(i2).n)) {
                    arrayList.add(copyOnWriteArrayList.get(i2));
                }
            }
            for (int i3 = 0; arrayList.size() < iM && i3 < copyOnWriteArrayList.size(); i3++) {
                if (copyOnWriteArrayList.get(i3).s() && n(copyOnWriteArrayList.get(i3).q(), qgVar, copyOnWriteArrayList.get(i3).n)) {
                    arrayList.add(copyOnWriteArrayList.get(i3));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((x) it.next()).n(true);
            }
            qg.q(MediationConstant.TAG, "--==-- 复用模式1，不从复用池移除，获取缓存: " + str + ", " + arrayList.size());
        } else if (iL == 2) {
            for (x xVar : copyOnWriteArrayList) {
                if (arrayList.size() >= iM) {
                    break;
                }
                if (xVar.x() && xVar.n != null) {
                    qg.q(MediationConstant.TAG, "--==-- 复用模式2，广告：" + xVar.qg() + "  adnName:" + xVar.n.ci() + " showSort:" + xVar.n.il() + " 暂不可用， 已经被使用中...");
                }
                if (xVar != null && n(xVar.q(), qgVar, xVar.n) && !xVar.x()) {
                    copyOnWriteArrayList.remove(xVar);
                    arrayList.add(xVar);
                }
            }
            qg.q(MediationConstant.TAG, "--==-- 复用模式2，从复用池移除，获取缓存: " + str + ", " + arrayList.size());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((x) it2.next()).qg(true);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int qg(String str, com.byazt.qn.qg qgVar, boolean z) {
        boolean zN;
        int i;
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.q.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            String strA = qgVar != null ? qgVar.a() : "";
            ArrayList arrayList = new ArrayList();
            x xVar = null;
            Object[] objArr = false;
            for (x xVar2 : copyOnWriteArrayList) {
                Integer numW = xVar2.n.w();
                int iIntValue = numW != null ? numW.intValue() : 0;
                if (iIntValue == 4) {
                    zN = n(strA, xVar2.n);
                } else {
                    zN = iIntValue != 2;
                }
                if (!zN) {
                    if (n(xVar2.q(), qgVar, xVar2.n)) {
                        qg.n(MediationConstant.TAG, "--==-- 广告复用:复用成功：--------" + xVar2.n.lq() + ", adSlotId: " + str);
                        objArr = true;
                    } else {
                        qg.n(MediationConstant.TAG, "--==-- 广告复用:AdSlot不符合 -------: " + xVar2.n.lq() + ", adSlotId: " + str);
                        i = 6;
                    }
                } else {
                    copyOnWriteArrayList.remove(xVar2);
                    qg.n(MediationConstant.TAG, "--==-- 广告复用:广告过期了 -------: " + xVar2.n.lq() + ", adSlotId: " + str);
                    i = 5;
                }
                if (xVar == null) {
                    xVar = xVar2;
                }
                com.byazt.qa.n nVar = new com.byazt.qa.n();
                nVar.q(xVar2.n.la());
                nVar.l(xVar2.n.il());
                nVar.qg(xVar2.n.el());
                nVar.qg(i);
                nVar.n(xVar2.n.nf() ? 1 : 0);
                arrayList.add(nVar);
            }
            if (objArr == true) {
                return 3;
            }
            if (z && xVar != null) {
                com.byazt.gp.s.n(qgVar, xVar.n, n(arrayList));
            }
            return 2;
        }
        qg.q(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    public synchronized int n(String str, com.byazt.qn.qg qgVar, boolean z) {
        if (qg(qgVar != null ? qgVar.a() : "", str) == 0) {
            return qg(str, qgVar, z);
        }
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.q.get(str);
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
            x xVar = null;
            ArrayList arrayList = z ? new ArrayList() : null;
            boolean z2 = false;
            for (x xVar2 : copyOnWriteArrayList) {
                int iN = n(xVar2, xVar2.q(), qgVar, "广告复用");
                if (iN == -1) {
                    z2 = true;
                } else {
                    if (iN != 6) {
                        copyOnWriteArrayList.remove(xVar2);
                    }
                    if (z) {
                        if (xVar == null) {
                            xVar = xVar2;
                        }
                        com.byazt.qa.n nVar = new com.byazt.qa.n();
                        nVar.q(xVar2.n.la());
                        nVar.l(xVar2.n.il());
                        nVar.qg(xVar2.n.el());
                        nVar.qg(iN);
                        nVar.n(xVar2.n.nf() ? 1 : 0);
                        arrayList.add(nVar);
                    }
                }
            }
            if (z2) {
                return 3;
            }
            if (z && xVar != null) {
                com.byazt.gp.s.n(qgVar, xVar.n, n(arrayList));
            }
            return 2;
        }
        qg.q(MediationConstant.TAG, "--==-- 广告复用:当前没有广告缓存 -------adnSlotId: " + str);
        return 1;
    }

    private String n(List<com.byazt.qa.n> list) {
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).n());
                if (i == list.size() - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            try {
                return new JSONArray(sb.toString()).toString();
            } catch (JSONException e) {
                qg.q(MediationConstant.TAG, "--==-- 广告复用：adCannotUseInfo json err: " + e.getMessage());
            }
        }
        return list.size() > 0 ? "json error" : "[]";
    }

    public void s() {
        this.q.clear();
    }

    public int qg(String str) {
        CopyOnWriteArrayList<x> copyOnWriteArrayList = this.q.get(str);
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return 0;
        }
        return copyOnWriteArrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, com.byazt.qn.qg qgVar, Map<String, Object> map, Context context, cp cpVar, rv rvVar) {
        String strN;
        if (qgVar == null) {
            qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，adSlot为空 -------: " + str);
            return;
        }
        if (context == null) {
            qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，context为null -------: " + str);
            return;
        }
        tj tjVarL = l(qgVar.a(), str);
        if (tjVarL != null) {
            try {
                strN = com.byazt.sq.s.n(tjVarL.x(), com.byazt.sq.s.n(tjVarL.k()), com.byazt.sg.n.n(tjVarL.oa(), tjVarL.w()));
            } catch (Throwable unused) {
                strN = null;
            }
        } else {
            strN = null;
        }
        if (TextUtils.isEmpty(strN) || !com.byazt.sq.s.qg(strN) || tjVarL == null) {
            qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，className或wfcBean为空, className: " + strN + ", wfcBean: " + tjVarL + ", adnSlotId: " + str);
            return;
        }
        for (String str2 : this.n) {
            if (TextUtils.equals(str2, tjVarL.k())) {
                qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求取消，" + str2 + "为单例模式 -------: " + str);
                return;
            }
        }
        int iIntValue = this.x.get(str) != null ? this.x.get(str).intValue() : -1;
        qg.q(MediationConstant.TAG, "--==-- 广告复用:show时预请求开始 -------: " + str);
        com.byazt.dd.qg qgVarN = com.byazt.dd.qg.n(tjVarL, (com.byazt.ow.n) null);
        qgVarN.s(4);
        qgVarN.qg(1);
        com.byazt.nw.n nVarN = com.byazt.yc.s.n(qgVarN, qgVar, new C0319n(qgVar, tjVarL, qgVarN, rvVar, iIntValue));
        if (nVarN != null) {
            if (!com.byazt.bf.cp.n().s(qgVar.a(), tjVarL.cd())) {
                qg.q("TMe", "adn 代码位预请求触发次数拦截............");
                Pair<String, String> pairN = com.byazt.bf.cp.n().n(qgVar.a(), tjVarL.cd());
                if (pairN != null) {
                    com.byazt.pu.qg qgVar2 = new com.byazt.pu.qg(41041, com.byazt.mj.n.n(41041), (String) pairN.second, (String) pairN.first);
                    com.byazt.gp.s.n(tjVarL, qgVar, n().n(tjVarL.cd()), true, 2, iIntValue, 4, 1, qgVar2, -1L, false, false, 0L);
                    com.byazt.gp.s.n(qgVar2, qgVar, tjVarL, iIntValue, 4, 1, n().n(tjVarL.cd()), 0L, (String) null, (String) null, (String) null, 0L);
                    return;
                }
                return;
            }
            com.byazt.gp.s.n(tjVarL, qgVar, n().n(tjVarL.cd()), qgVarN.l(), 3, qgVarN.s(), 4, 1, null, qgVarN.q(), false, false, 0L);
            nVarN.n(context, qgVarN, qgVar, com.byazt.yc.s.n(qgVarN, qgVar, map));
            qg.q(MediationConstant.TAG, "--==-- 广告复用:show时预请求已发完 -------: " + str);
            return;
        }
        com.byazt.gp.s.n(tjVarL, qgVar, 4, 1);
    }

    /* JADX INFO: renamed from: com.byazt.ra.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1304, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private class C0319n implements com.byazt.nw.qg {
        public com.byazt.dd.qg l;
        public int n;
        public tj q;
        public final com.byazt.qn.qg s;
        public rv w;
        public long x = System.currentTimeMillis();

        @Override // com.byazt.nw.qg
        public void n(s sVar, String str) {
        }

        public C0319n(com.byazt.qn.qg qgVar, tj tjVar, com.byazt.dd.qg qgVar2, rv rvVar, int i) {
            this.s = qgVar;
            this.q = tjVar;
            this.l = qgVar2;
            this.n = i;
            this.w = rvVar;
        }

        @Override // com.byazt.nw.qg
        public void n(List<s> list) {
            if (list == null || list.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (s sVar : list) {
                if (sVar != null) {
                    tj tjVar = this.q;
                    com.byazt.yc.s.n(sVar, this.s, this.l, this.w, tjVar != null ? n.this.n(tjVar.cd()) : "");
                    sVar.n(SystemClock.elapsedRealtime());
                    arrayList.add(new x(sVar, 0L, this.s));
                }
            }
            if (arrayList.size() > 0) {
                s sVar2 = ((x) arrayList.get(0)).n;
                qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告load成功 --- " + sVar2.lq() + ", adType: " + com.byazt.sg.n.n(sVar2.ct(), sVar2.dg()) + ", adnSlotId: " + sVar2.el() + ", ad个数: " + arrayList.size());
                n.this.n(sVar2.el(), (List<x>) arrayList, false);
            }
            com.byazt.gp.s.n(list.get(0), AdBaseConstants.DEFAULT_INSTALL_FINISH_TRY_INTERVAL_MS, "load success", System.currentTimeMillis() - this.x, this.s, this.n, list.size(), 0, (String) null, -1L, -1L);
        }

        @Override // com.byazt.nw.qg
        public void n(com.byazt.mj.n nVar) {
            if (nVar != null && this.q != null) {
                qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告load失败 --- " + this.q.hd() + ", " + this.q.cd() + ", " + com.byazt.sg.n.n(this.q.oa(), this.q.w()) + ", errCode: " + nVar.s + ",msg=" + nVar.q);
                nVar.n("is_dex_adapter", Integer.valueOf(this.l.fi() ? 1 : 0));
            }
            com.byazt.gp.s.n(nVar, this.s, this.q, this.n, 4, 1, n.n().n(this.q.cd()), System.currentTimeMillis() - this.x, (String) null, (String) null, (String) null, 0L);
        }

        @Override // com.byazt.nw.qg
        public void n(List<s> list, com.byazt.mj.n nVar) {
            if (list == null || list.size() <= 0) {
                return;
            }
            for (s sVar : list) {
                tj tjVar = this.q;
                com.byazt.yc.s.n(sVar, this.s, this.l, this.w, tjVar != null ? n.this.n(tjVar.cd()) : "");
                sVar.rv(true);
            }
            s sVar2 = list.get(0);
            if (sVar2 != null) {
                qg.n(MediationConstant.TAG, "--==-- 广告复用:show时预请求广告cache成功 --- " + sVar2.lq() + ", adType: " + com.byazt.sg.n.n(sVar2.ct(), sVar2.dg()) + ", adnSlotId: " + sVar2.el() + ", ad个数: " + list.size());
            }
            com.byazt.gp.s.n(this.s, sVar2, this.q);
        }
    }
}
