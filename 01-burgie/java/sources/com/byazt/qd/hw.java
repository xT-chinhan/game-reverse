package com.byazt.qd;

import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.hg.of;
import com.byazt.is.vk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 224, 13})
public class hw {
    public static Map<String, SparseArray<Object>> pr = new ConcurrentHashMap();

    public static void pr(final of ofVar, final com.byazt.qe.hw hwVar, final int i, String str) {
        if (ofVar == null || hwVar == null) {
            return;
        }
        com.byazt.dc.hn hnVarPr = pr();
        hnVarPr.hw(str, hwVar.gz());
        hnVarPr.pr(str, new com.byazt.tb.c());
        hnVarPr.pr(str, new com.byazt.tb.uc());
        if (vk.zo()) {
            hnVarPr.pr(str, new com.byazt.tb.x());
        }
        if (com.byazt.cf.uc.pr().pr(i)) {
            hnVarPr.pr(str, new com.byazt.cf.x());
        }
        hnVarPr.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.hw.1
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar2) {
                if (hwVar2 instanceof com.byazt.pv.hn) {
                    com.byazt.pv.hn hnVar = (com.byazt.pv.hn) hwVar2;
                    hnVar.ho = ofVar;
                    if (hwVar != null) {
                        hnVar.k = i;
                        hnVar.g = hwVar.x();
                        hnVar.m = com.byazt.mn.x.pr(ofVar);
                    }
                }
            }
        });
        pr(str);
    }

    public static void pr(String str) {
        if (pr() != null) {
            pr().pr(str, com.byazt.tq.hn.CREATED);
        }
    }

    public static void hw(String str) {
        com.byazt.dc.hn hnVarPr = pr();
        if (hnVarPr != null) {
            hnVarPr.pr(str, com.byazt.tq.hn.STARTED);
        }
    }

    public static void pr(String str, final boolean z, final boolean z2) {
        com.byazt.dc.hn hnVarPr = pr();
        if (hnVarPr != null) {
            hnVarPr.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.hw.2
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        com.byazt.pv.hn hnVar = (com.byazt.pv.hn) hwVar;
                        hnVar.x = z;
                        hnVar.c = z2 ? 1 : 0;
                    }
                }
            });
            hnVarPr.pr(str, com.byazt.tq.hn.SHOWED);
        }
    }

    public static void pr(String str, final boolean z) {
        com.byazt.dc.hn hnVarPr = pr();
        if (hnVarPr != null) {
            hnVarPr.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.hw.3
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).x = z;
                    }
                }
            });
            hnVarPr.pr(str, com.byazt.tq.hn.SHOWED);
        }
    }

    public static void hn(String str) {
        com.byazt.dc.hn hnVarPr = pr();
        if (hnVarPr != null) {
            hnVarPr.pr(str, com.byazt.tq.hn.CLICKED);
        }
    }

    public static void pr(String str, final int i) {
        com.byazt.dc.hn hnVarPr = pr();
        if (hnVarPr != null) {
            hnVarPr.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.hw.4
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).hn = i;
                    }
                }
            });
            hnVarPr.pr(str, com.byazt.tq.hn.VISIBLED);
        }
    }

    public static void hw(String str, final int i) {
        com.byazt.dc.hn hnVarPr = pr();
        if (hnVarPr != null) {
            hnVarPr.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.hw.5
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).hn = i;
                    }
                }
            });
            hnVarPr.pr(str, com.byazt.tq.hn.INVISIBLED);
        }
    }

    public static void hn(String str, final int i) {
        com.byazt.dc.hn hnVarPr = pr();
        if (hnVarPr != null) {
            hnVarPr.pr(str, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.hw.6
                @Override // com.byazt.ewt.x.pr
                public void pr(com.byazt.ewt.hw hwVar) {
                    if (hwVar instanceof com.byazt.pv.hn) {
                        ((com.byazt.pv.hn) hwVar).hw = i;
                    }
                }
            });
            hnVarPr.pr(str, com.byazt.tq.hn.END);
        }
        if (i == 1 || i == 2) {
            x.hw(str, i);
        }
    }

    public static com.byazt.dc.hn pr() {
        return (com.byazt.dc.hn) com.byazt.ewt.c.pr(1);
    }

    public static Object x(String str, int i) {
        Object obj;
        synchronized (pr) {
            c(str);
            obj = pr.get(str).get(i);
        }
        return obj;
    }

    public static void pr(String str, int i, Object obj) {
        synchronized (pr) {
            c(str);
            pr.get(str).put(i, obj);
        }
    }

    private static void c(String str) {
        synchronized (pr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (pr.get(str) == null) {
                pr.put(str, new SparseArray<>());
            }
        }
    }

    public static void x(String str) {
        synchronized (pr) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            pr.remove(str);
        }
    }
}
