package com.byazt.qd;

import com.byazt.ewt.zo;
import com.byazt.hg.of;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 224, 37})
public class pr {
    public static void pr(final of ofVar, final String str, final int i, final int i2, String str2) {
        if (ofVar == null) {
            return;
        }
        com.byazt.dc.pr prVarPr = pr();
        prVarPr.hw(str2, ofVar.yn());
        prVarPr.pr(str2, new com.byazt.tb.hw());
        prVarPr.pr(str2, new com.byazt.tb.pr());
        prVarPr.pr(str2, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.pr.1
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.pr) {
                    com.byazt.pv.pr prVar = (com.byazt.pv.pr) hwVar;
                    prVar.ho = ofVar;
                    prVar.k = i;
                    prVar.g = str;
                    prVar.pr = i2;
                    prVar.m = com.byazt.mn.x.pr(ofVar);
                }
            }
        });
        pr(str2);
    }

    public static void pr(String str) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            prVarPr.pr(str, com.byazt.tq.pr.CREATED);
        }
    }

    public static void pr(String str, int i) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            prVarPr.pr(str, com.byazt.tq.pr.STARTED, zoVar);
        }
    }

    public static void hw(String str, int i) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            prVarPr.pr(str, com.byazt.tq.pr.MARKET_OPENED, zoVar);
        }
    }

    public static void hw(String str) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            prVarPr.pr(str, com.byazt.tq.pr.MARKET_CLOSED);
        }
    }

    public static void hn(String str, int i) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            prVarPr.pr(str, com.byazt.tq.pr.DOWNLOAD_STARTED, zoVar);
        }
    }

    public static void hn(String str) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            prVarPr.pr(str, com.byazt.tq.pr.DOWNLOAD_PAUSED);
        }
    }

    public static void x(String str, int i) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            prVarPr.pr(str, com.byazt.tq.pr.DOWNLOAD_FAILED, zoVar);
        }
    }

    public static void x(String str) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            prVarPr.pr(str, com.byazt.tq.pr.DOWNLOAD_CANCELED);
        }
    }

    public static void c(String str) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            prVarPr.pr(str, com.byazt.tq.pr.DOWNLOAD_FINISHED);
        }
    }

    public static void c(String str, int i) {
        com.byazt.dc.pr prVarPr = pr();
        if (prVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            prVarPr.pr(str, com.byazt.tq.pr.END, zoVar);
        }
    }

    public static com.byazt.dc.pr pr() {
        return (com.byazt.dc.pr) com.byazt.ewt.c.pr(3);
    }
}
