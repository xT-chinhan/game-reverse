package com.byazt.de;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.gct.pk;
import com.byazt.wea.fs;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 842, 26})
public class qg {
    public static Map<String, SparseArray<Object>> n = new ConcurrentHashMap();

    public static void n(final pk pkVar, final com.byazt.zq.qg qgVar, final int i, String str) {
        if (pkVar == null || qgVar == null) {
            return;
        }
        com.byazt.id.s sVarN = n();
        sVarN.qg(str, qgVar.an());
        sVarN.n(str, new com.byazt.oi.l());
        sVarN.n(str, new com.byazt.oi.w());
        if (com.byazt.ph.q.fs()) {
            sVarN.n(str, new com.byazt.oi.q());
        }
        if (com.byazt.bh.w.n().n(i)) {
            sVarN.n(str, new com.byazt.bh.q());
        }
        sVarN.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.de.qg.1
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.q) {
                    com.byazt.wea.q qVar = (com.byazt.wea.q) fsVar;
                    qVar.q = pkVar;
                    if (qgVar != null) {
                        qVar.n = i;
                        qVar.s = qgVar.q();
                        qVar.qg = com.byazt.yvo.q.n(pkVar);
                    }
                }
            }
        });
        n(str);
    }

    public static void n(String str) {
        if (n() != null) {
            n().n(str, com.byazt.hes.s.CREATED);
        }
    }

    public static void qg(String str) {
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            sVarN.n(str, com.byazt.hes.s.STARTED);
        }
    }

    public static void n(String str, final boolean z, final boolean z2) {
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            sVarN.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.de.qg.2
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        com.byazt.wea.q qVar = (com.byazt.wea.q) fsVar;
                        qVar.tj = z;
                        qVar.cp = z2 ? 1 : 0;
                    }
                }
            });
            sVarN.n(str, com.byazt.hes.s.SHOWED);
        }
    }

    public static void n(String str, final boolean z) {
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            sVarN.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.de.qg.3
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).tj = z;
                    }
                }
            });
            sVarN.n(str, com.byazt.hes.s.SHOWED);
        }
    }

    public static void s(String str) {
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            sVarN.n(str, com.byazt.hes.s.CLICKED);
        }
    }

    public static void n(String str, final int i) {
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            sVarN.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.de.qg.4
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).rv = i;
                    }
                }
            });
            sVarN.n(str, com.byazt.hes.s.VISIBLED);
        }
    }

    public static void qg(String str, final int i) {
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            sVarN.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.de.qg.5
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).rv = i;
                    }
                }
            });
            sVarN.n(str, com.byazt.hes.s.INVISIBLED);
        }
    }

    public static void s(String str, final int i) {
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            sVarN.n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.de.qg.6
                @Override // com.byazt.bok.qg.n
                public void n(fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.q) {
                        ((com.byazt.wea.q) fsVar).fs = i;
                    }
                }
            });
            sVarN.n(str, com.byazt.hes.s.END);
        }
        if (i == 1 || i == 2) {
            q.qg(str, i);
        }
    }

    public static com.byazt.id.s n() {
        return (com.byazt.id.s) com.byazt.bok.s.n(1);
    }

    public static Object q(String str, int i) {
        Object obj;
        synchronized (n) {
            w(str);
            obj = n.get(str).get(i);
        }
        return obj;
    }

    public static void n(String str, int i, Object obj) {
        synchronized (n) {
            w(str);
            n.get(str).put(i, obj);
        }
    }

    private static void w(String str) {
        synchronized (n) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (n.get(str) == null) {
                n.put(str, new SparseArray<>());
            }
        }
    }

    public static void q(String str) {
        synchronized (n) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            n.remove(str);
        }
    }

    public static void l(String str) {
        com.byazt.kld.qg qgVar;
        com.byazt.id.s sVarN = n();
        if (sVarN != null) {
            fs context = sVarN.getContext(str);
            if (!(context instanceof com.byazt.wea.q) || (qgVar = ((com.byazt.wea.q) context).cd) == null) {
                return;
            }
            qgVar.n();
        }
    }
}
