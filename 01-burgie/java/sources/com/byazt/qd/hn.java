package com.byazt.qd;

import com.byazt.ewt.zo;
import com.byazt.hg.of;
import com.byazt.tb.fw;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 224, 20})
public class hn {
    public static void pr(final of ofVar, final String str, final int i, final int i2, String str2) {
        if (ofVar == null) {
            return;
        }
        com.byazt.dc.x xVarPr = pr();
        xVarPr.hw(str2, ofVar.yn());
        xVarPr.pr(str2, new fw());
        xVarPr.pr(str2, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.hn.1
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.x) {
                    com.byazt.pv.x xVar = (com.byazt.pv.x) hwVar;
                    xVar.ho = ofVar;
                    xVar.k = i;
                    xVar.g = str;
                    xVar.pr = i2;
                    xVar.m = com.byazt.mn.x.pr(ofVar);
                }
            }
        });
        pr(str2);
    }

    public static void pr(String str) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            xVarPr.pr(str, com.byazt.tq.x.CREATED);
        }
    }

    public static void hw(String str) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            xVarPr.pr(str, com.byazt.tq.x.INITIALIZED);
        }
    }

    public static void pr(String str, int i) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            xVarPr.pr(str, com.byazt.tq.x.STARTED, zoVar);
        }
    }

    public static void hn(String str) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            xVarPr.pr(str, com.byazt.tq.x.PREPARED);
        }
    }

    public static void hw(String str, int i) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            xVarPr.pr(str, com.byazt.tq.x.PLAYED, zoVar);
        }
    }

    public static void x(String str) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            xVarPr.pr(str, com.byazt.tq.x.BUFFERED);
        }
    }

    public static void c(String str) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            xVarPr.pr(str, com.byazt.tq.x.PAUSED);
        }
    }

    public static void uc(String str) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            xVarPr.pr(str, com.byazt.tq.x.COMPLETED);
        }
    }

    public static void hn(String str, int i) {
        com.byazt.dc.x xVarPr = pr();
        if (xVarPr != null) {
            zo zoVar = new zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            xVarPr.pr(str, com.byazt.tq.x.END, zoVar);
        }
    }

    public static com.byazt.dc.x pr() {
        return (com.byazt.dc.x) com.byazt.ewt.c.pr(2);
    }
}
