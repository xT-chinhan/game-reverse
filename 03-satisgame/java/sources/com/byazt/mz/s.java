package com.byazt.mz;

import android.text.TextUtils;
import com.byazt.ci.x;
import com.byazt.gct.fs;
import com.byazt.gct.pk;
import com.byazt.gct.z;
import com.byazt.se.rv;
import com.byazt.vf.k;
import com.byazt.vgx.w;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 895, 8})
public class s extends n {
    public volatile x cp;
    public static ConcurrentHashMap<String, qg> x = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, List<String>> fs = new ConcurrentHashMap<>();
    public static ReferenceQueue<Object> rv = new ReferenceQueue<>();
    public static Map<Object, qg> tj = new ConcurrentHashMap();

    private void q() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.cp = new x(3);
        com.byazt.eo.n.n("lqmt", "NewCache 初始化耗时: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    @Override // com.byazt.mz.n
    public void qg() {
        if (this.cp == null) {
            synchronized (this) {
                if (this.cp == null) {
                    q();
                }
            }
        }
    }

    @Override // com.byazt.mz.n
    public void n(final z zVar, com.byazt.zq.qg qgVar, boolean z) {
        if (qgVar == null || zVar == null || zVar.n() == null) {
            return;
        }
        if (this.cp == null) {
            qg();
        }
        try {
            final String strQ = qgVar.q();
            com.byazt.eo.n.n("lqmt", "saveCache start >>  rit: " + strQ + "  isUsing: " + z);
            final pk pkVarN = zVar.n();
            String strOu = pkVarN.ou();
            String strQg = qg(strQ, strOu);
            if (x.contains(strQg)) {
                return;
            }
            com.byazt.eo.n.n("lqmt", "save-updateMemoryRecord start >>  rit: " + strQ + "  reqId: " + strOu);
            n(strQg, strQ, strOu, z ? 2 : 1);
            n(new Runnable() { // from class: com.byazt.mz.s.1
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    s.this.cp.n(strQ, new x.qg(((k) com.byazt.qp.q.n("encrypt_service")).s(zVar.qg().s().toString()), pkVarN.vx(), 1000 * pkVarN.aj(), pkVarN.ou()), false, w.ou(pkVarN), pkVarN.uc());
                    com.byazt.eo.n.n("lqmt", "saveMeta >>  rit: " + strQ + " saveDb cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                }
            });
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.mz.n
    public void n(com.byazt.se.x xVar, final String str, n.InterfaceC0253n interfaceC0253n, l lVar) {
        if (str == null || interfaceC0253n == null) {
            return;
        }
        if (this.cp == null) {
            qg();
        }
        this.w = lVar;
        x.qg qgVar = null;
        com.byazt.se.w wVar = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            l();
            List<String> listN = n(str);
            com.byazt.eo.n.n("lqmt", "readcache start >>  rit: " + str + "  usedReqIdList: " + (listN == null ? 0 : listN.size()));
            final x.qg qgVarN = this.cp.n(str, this.w == null ? 0L : this.w.n, listN);
            try {
                com.byazt.eo.n.n("lqmt", "readcache-getCacheMeta cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                if (qgVarN == null) {
                    com.byazt.eo.n.n("lqmt", "readcache-cacheMeta: null ");
                    if (xVar != null) {
                        xVar.q(0);
                        xVar.qg(1);
                        xVar.n("no cache");
                    }
                    interfaceC0253n.n();
                    return;
                }
                String str2 = qgVarN.l;
                String strQg = qg(str, str2);
                com.byazt.eo.n.n("lqmt", "readcache-mapkey: " + strQg);
                qg qgVar2 = x.get(strQg);
                if (qgVar2 != null && qgVar2.qg > 1) {
                    com.byazt.eo.n.n("lqmt", "readcache-cacheRecord != null && cacheRecord.status > CACHE_STATUS_NOUSE");
                    if (xVar != null) {
                        xVar.q(0);
                        xVar.qg(1);
                        xVar.n("no cache");
                    }
                    interfaceC0253n.n();
                    return;
                }
                n(strQg, str, str2, 2);
                com.byazt.gct.n nVar = com.byazt.mw.qg.n.n(new JSONObject(((k) com.byazt.qp.q.n("encrypt_service")).q(qgVarN.s))).fs;
                com.byazt.se.w wVar2 = new com.byazt.se.w(nVar, true);
                pk pkVar = (nVar == null || nVar.qg() == null || nVar.qg().isEmpty()) ? null : nVar.qg().get(0);
                if (pkVar != null) {
                    wVar2.n(pkVar);
                }
                com.byazt.eo.n.n("lqmt", "readcache-updateMemoryRecord start >>  rit: " + str + "  reqId: " + str2);
                if (com.byazt.wq.qg.n().s(pkVar) != 3) {
                    wVar = wVar2;
                } else {
                    wVar2.n((pk) null);
                }
                interfaceC0253n.n(wVar);
                boolean zTj = com.byazt.ed.q.n().tj();
                com.byazt.eo.n.n("lqmt", "isSplashCacheRemoveChange: " + zTj);
                if (zTj) {
                    return;
                }
                n(new Runnable() { // from class: com.byazt.mz.s.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            long jCurrentTimeMillis2 = System.currentTimeMillis();
                            s.this.cp.n(str, qgVarN.l);
                            com.byazt.eo.n.n("lqmt", "readcache-deleteCacheMeta start >>  rit: " + str + "  reqId: " + qgVarN.l + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis2));
                        } catch (Exception unused) {
                        }
                    }
                });
            } catch (Throwable unused) {
                qgVar = qgVarN;
                qgVarN = qgVar;
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // com.byazt.mz.n
    public void n(com.byazt.jr.q<rv, com.byazt.se.x> qVar, final pk pkVar, com.byazt.zq.qg qgVar, boolean z) {
        if (pkVar == null || qgVar == null) {
            return;
        }
        if (this.cp == null) {
            qg();
        }
        try {
            com.byazt.eo.n.n("lqmt", "removeCache>> start ");
            final String strQ = qgVar.q();
            String strOu = pkVar.ou();
            String strQg = qg(strQ, strOu);
            if (this.l.get()) {
                com.byazt.eo.n.n("lqmt", "removeCache-mIsRemoveCacheAd: true");
                return;
            }
            this.l.set(true);
            n(strQg, strQ, strOu, 3);
            com.byazt.eo.n.n("lqmt", "removeCache-updateMemoryRecord: 完成");
            n(new Runnable() { // from class: com.byazt.mz.s.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        s.this.cp.n(strQ, pkVar.ou());
                        com.byazt.eo.n.n("lqmt", "removeCache-deleteCacheMeta  rit: " + strQ + "  cost: " + (System.currentTimeMillis() - jCurrentTimeMillis));
                    } catch (Throwable unused) {
                    }
                }
            });
            if (qVar != null) {
                qVar.n();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.mz.n
    public void n(String str, pk pkVar) {
        if (this.cp == null) {
            qg();
        }
        if (this.cp != null) {
            this.cp.n(str, pkVar.ou());
        }
    }

    @Override // com.byazt.mz.n
    public void s() {
        if (this.cp == null) {
            qg();
        }
        if (this.cp != null) {
            this.cp.n();
        }
    }

    @Override // com.byazt.mz.n
    public void n(String str, String str2, boolean z, boolean z2, Object obj) {
        if (w() != 3 || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            return;
        }
        if (z2 || !z) {
            n(str, str2);
        } else {
            n(obj, str, str2);
        }
    }

    private void n(final Runnable runnable) {
        if (com.byazt.ag.qg.n()) {
            com.byazt.qit.l.qg(new com.byazt.qit.x("") { // from class: com.byazt.mz.s.4
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        } else {
            runnable.run();
        }
    }

    private List<String> n(String str) {
        List<String> list = fs.get(str);
        com.byazt.eo.n.n("lqmt", "getUsedReqIdList: list : " + (list == null ? 0 : list.size()));
        return list;
    }

    private void n(String str, String str2, String str3, int i) {
        int iW = w();
        com.byazt.eo.n.n("lqmt", "updateMemoryRecord>> start rit: " + str2 + ", status: " + i + ", cacheStrategyType: " + iW);
        if (iW != 3) {
            return;
        }
        x.put(str, new qg(str3, i, str2));
        if (i <= 1) {
            com.byazt.eo.n.n("lqmt", "updateMemoryRecord>> :status <= CACHE_STATUS_NOUSE");
            return;
        }
        List<String> copyOnWriteArrayList = fs.get(str2);
        com.byazt.eo.n.n("lqmt", "updateMemoryRecord>>: list1 : " + (copyOnWriteArrayList == null ? 0 : copyOnWriteArrayList.size()));
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(str3);
        } else if (copyOnWriteArrayList.contains(str3)) {
            return;
        } else {
            copyOnWriteArrayList.add(str3);
        }
        com.byazt.eo.n.n("lqmt", "updateMemoryRecord>>: list2 : " + copyOnWriteArrayList.size());
        fs.put(str2, copyOnWriteArrayList);
    }

    private void n(Object obj, String str, String str2) {
        try {
            qg qgVar = x.get(qg(str, str2));
            if (qgVar != null && obj != null) {
                PhantomReference phantomReference = new PhantomReference(obj, rv);
                com.byazt.eo.n.n("lqmt", qgVar.s + "，uuid：" + qgVar.n + " watching");
                tj.put(phantomReference, qgVar);
            }
        } catch (Exception unused) {
        }
    }

    private void l() {
        if (w() != 3) {
            return;
        }
        try {
            for (Reference<? extends Object> referencePoll = rv.poll(); referencePoll != null; referencePoll = rv.poll()) {
                qg qgVar = tj.get(referencePoll);
                if (qgVar != null) {
                    n(qgVar.s, qgVar.n);
                }
                tj.remove(referencePoll);
            }
        } catch (Exception unused) {
        }
    }

    private void n(String str, String str2) {
        x.remove(qg(str, str2));
        List<String> list = fs.get(str);
        com.byazt.eo.n.n("lqmt", "checkCaches>>: list1 : " + (list == null ? 0 : list.size()));
        if (list == null) {
            return;
        }
        com.byazt.eo.n.n("lqmt", "checkCaches>>: rmCache : " + str2);
        list.remove(str2);
        fs.put(str, list);
    }

    private static int w() {
        if (fs.n() == null) {
            return 1;
        }
        return fs.n().q();
    }

    private String qg(String str, String str2) {
        return str + str2;
    }
}
