package com.byazt.de;

import com.byazt.gct.pk;
import com.byazt.wea.fs;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 842, 8})
public class s {
    public static void n(final pk pkVar, final String str, final int i, final int i2, String str2) {
        if (pkVar == null) {
            return;
        }
        com.byazt.id.q qVarN = n();
        qVarN.qg(str2, pkVar.mk());
        qVarN.n(str2, new com.byazt.oi.x());
        qVarN.n(str2, new com.byazt.bok.qg.n() { // from class: com.byazt.de.s.1
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.l) {
                    com.byazt.wea.l lVar = (com.byazt.wea.l) fsVar;
                    lVar.q = pkVar;
                    lVar.n = i;
                    lVar.s = str;
                    lVar.x = i2;
                    lVar.qg = com.byazt.yvo.q.n(pkVar);
                }
            }
        });
        n(str2);
    }

    public static void n(String str) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            qVarN.n(str, com.byazt.hes.q.CREATED);
        }
    }

    public static void qg(String str) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            qVarN.n(str, com.byazt.hes.q.INITIALIZED);
        }
    }

    public static void n(String str, int i) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            qVarN.n(str, com.byazt.hes.q.STARTED, wVar);
        }
    }

    public static void s(String str) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            qVarN.n(str, com.byazt.hes.q.PREPARED);
        }
    }

    public static void qg(String str, int i) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            qVarN.n(str, com.byazt.hes.q.PLAYED, wVar);
        }
    }

    public static void q(String str) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            qVarN.n(str, com.byazt.hes.q.BUFFERED);
        }
    }

    public static void l(String str) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            qVarN.n(str, com.byazt.hes.q.PAUSED);
        }
    }

    public static void w(String str) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            qVarN.n(str, com.byazt.hes.q.COMPLETED);
        }
    }

    public static void s(String str, int i) {
        com.byazt.id.q qVarN = n();
        if (qVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            qVarN.n(str, com.byazt.hes.q.END, wVar);
        }
    }

    public static com.byazt.id.q n() {
        return (com.byazt.id.q) com.byazt.bok.s.n(2);
    }
}
