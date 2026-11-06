package com.byazt.de;

import com.byazt.gct.pk;
import com.byazt.oi.cp;
import com.byazt.wea.fs;
import com.byazt.wea.rv;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 842, 13})
public class w {
    public static void n(final pk pkVar, final String str, final int i, final int i2, String str2) {
        if (pkVar == null) {
            return;
        }
        com.byazt.id.x xVarN = n();
        xVarN.qg(str2, pkVar.mk());
        xVarN.n(str2, new cp());
        xVarN.n(str2, new com.byazt.bok.qg.n() { // from class: com.byazt.de.w.1
            @Override // com.byazt.bok.qg.n
            public void n(fs fsVar) {
                if (fsVar instanceof rv) {
                    rv rvVar = (rv) fsVar;
                    rvVar.q = pkVar;
                    rvVar.n = i;
                    rvVar.s = str;
                    rvVar.x = i2;
                    rvVar.qg = com.byazt.yvo.q.n(pkVar);
                }
            }
        });
        n(str2);
    }

    public static void n(String str) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            xVarN.n(str, com.byazt.hes.x.CREATED);
        }
    }

    public static void qg(String str) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            xVarN.n(str, com.byazt.hes.x.STARTED);
        }
    }

    public static void n(String str, int i) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            xVarN.n(str, com.byazt.hes.x.LOADED, wVar);
        }
    }

    public static void s(String str) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            xVarN.n(str, com.byazt.hes.x.RENDER_STARTED);
        }
    }

    public static void qg(String str, int i) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            xVarN.n(str, com.byazt.hes.x.RENDERED, wVar);
        }
    }

    public static void s(String str, int i) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            xVarN.n(str, com.byazt.hes.x.SHOWED, wVar);
        }
    }

    public static void q(String str) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            xVarN.n(str, com.byazt.hes.x.CLICKED);
        }
    }

    public static void q(String str, int i) {
        com.byazt.id.x xVarN = n();
        if (xVarN != null) {
            com.byazt.bok.w wVar = new com.byazt.bok.w(System.currentTimeMillis());
            wVar.n("source", Integer.valueOf(i));
            xVarN.n(str, com.byazt.hes.x.END, wVar);
        }
    }

    public static com.byazt.id.x n() {
        return (com.byazt.id.x) com.byazt.bok.s.n(6);
    }
}
