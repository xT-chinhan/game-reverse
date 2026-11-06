package com.byazt.de;

import com.byazt.gct.pk;
import com.byazt.wea.fs;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 842, 19})
public class n {
    public static void n(final pk pkVar, final String str, final int i, final int i2, String str2) {
        if (pkVar == null) {
            return;
        }
        com.byazt.id.n nVarN = n();
        nVarN.qg(str2, pkVar.mk());
        nVarN.n(str2, new com.byazt.oi.qg());
        nVarN.n(str2, new com.byazt.oi.n());
        nVarN.n(str2, new com.byazt.bok.qg.n() { // from class: com.byazt.de.n.1
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof com.byazt.wea.qg) {
                    com.byazt.wea.qg qgVar = (com.byazt.wea.qg) fsVar;
                    qgVar.q = pkVar;
                    qgVar.n = i;
                    qgVar.s = str;
                    qgVar.x = i2;
                    qgVar.qg = com.byazt.yvo.q.n(pkVar);
                }
            }
        });
        n(str2);
    }

    public static void n(String str) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            nVarN.n(str, com.byazt.hes.n.CREATED);
        }
    }

    public static void n(String str, int i) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            nVarN.n(str, com.byazt.hes.n.STARTED, wVar);
        }
    }

    public static void qg(String str, int i) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            nVarN.n(str, com.byazt.hes.n.MARKET_OPENED, wVar);
        }
    }

    public static void qg(String str) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            nVarN.n(str, com.byazt.hes.n.MARKET_CLOSED);
        }
    }

    public static void s(String str, int i) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            nVarN.n(str, com.byazt.hes.n.DOWNLOAD_STARTED, wVar);
        }
    }

    public static void s(String str) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            nVarN.n(str, com.byazt.hes.n.DOWNLOAD_PAUSED);
        }
    }

    public static void q(String str, int i) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            nVarN.n(str, com.byazt.hes.n.DOWNLOAD_FAILED, wVar);
        }
    }

    public static void q(String str) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            nVarN.n(str, com.byazt.hes.n.DOWNLOAD_CANCELED);
        }
    }

    public static void l(String str) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            nVarN.n(str, com.byazt.hes.n.DOWNLOAD_FINISHED);
        }
    }

    public static void l(String str, int i) {
        com.byazt.id.n nVarN = n();
        if (nVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            nVarN.n(str, com.byazt.hes.n.END, wVar);
        }
    }

    public static com.byazt.id.n n() {
        return (com.byazt.id.n) com.byazt.bok.s.n(3);
    }
}
