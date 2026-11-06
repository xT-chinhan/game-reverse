package com.byazt.de;

import com.byazt.gct.pk;
import com.byazt.oi.fs;
import com.byazt.oi.rv;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 842, 5})
public class q {
    public static void n(final pk pkVar, final String str, final int i, String str2) {
        if (pkVar == null) {
            return;
        }
        com.byazt.id.l lVarN = n();
        lVarN.qg(str2, pkVar.mk());
        lVarN.n(str2, new rv());
        if (com.byazt.ph.q.fs()) {
            lVarN.n(str2, new fs());
        }
        lVarN.n(str2, new com.byazt.bok.qg.n() { // from class: com.byazt.de.q.1
            @Override // com.byazt.bok.qg.n
            public void n(com.byazt.wea.fs fsVar) {
                if (fsVar instanceof com.byazt.wea.w) {
                    com.byazt.wea.w wVar = (com.byazt.wea.w) fsVar;
                    wVar.q = pkVar;
                    wVar.n = i;
                    wVar.s = str;
                    wVar.tj = pkVar.ge();
                    wVar.qg = com.byazt.yvo.q.n(pkVar);
                }
            }
        });
        n(str2);
    }

    public static void n(String str) {
        com.byazt.id.l lVarN = n();
        if (lVarN != null) {
            lVarN.n(str, com.byazt.hes.l.CREATED);
        }
    }

    public static void qg(String str) {
        com.byazt.id.l lVarN = n();
        if (lVarN != null) {
            lVarN.n(str, com.byazt.hes.l.ATTACHED);
        }
    }

    public static void n(String str, int i) {
        com.byazt.id.l lVarN = n();
        if (lVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            lVarN.n(str, com.byazt.hes.l.FOCUSED, wVar);
        }
    }

    public static void s(String str) {
        com.byazt.id.l lVarN = n();
        if (lVarN != null) {
            lVarN.n(str, com.byazt.hes.l.VISIBLED);
        }
    }

    public static void q(String str) {
        com.byazt.id.l lVarN = n();
        if (lVarN != null) {
            lVarN.n(str, com.byazt.hes.l.INVISIBLED);
        }
    }

    public static void l(String str) {
        com.byazt.id.l lVarN = n();
        if (lVarN != null) {
            lVarN.n(str, com.byazt.hes.l.DETACHED);
        }
    }

    public static void qg(String str, int i) {
        com.byazt.id.l lVarN = n();
        if (lVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            lVarN.n(str, com.byazt.hes.l.END, wVar);
        }
    }

    public static com.byazt.id.l n() {
        return (com.byazt.id.l) com.byazt.bok.s.n(5);
    }

    public static boolean w(String str) {
        com.byazt.wea.fs context = n().getContext(str);
        return (context instanceof com.byazt.wea.w) && ((com.byazt.wea.w) context).x != null;
    }
}
