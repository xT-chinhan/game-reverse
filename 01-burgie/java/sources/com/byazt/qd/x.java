package com.byazt.qd;

import com.byazt.hg.of;
import com.byazt.is.vk;
import com.byazt.tb.aj;
import com.byazt.tb.zo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 224, 121})
public class x {
    public static void pr(final of ofVar, final String str, final int i, String str2) {
        if (ofVar == null) {
            return;
        }
        com.byazt.dc.c cVarPr = pr();
        cVarPr.hw(str2, ofVar.yn());
        cVarPr.pr(str2, new aj());
        if (vk.zo()) {
            cVarPr.pr(str2, new zo());
        }
        cVarPr.pr(str2, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.x.1
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof com.byazt.pv.c) {
                    com.byazt.pv.c cVar = (com.byazt.pv.c) hwVar;
                    cVar.ho = ofVar;
                    cVar.k = i;
                    cVar.g = str;
                    cVar.x = ofVar.jg();
                    cVar.m = com.byazt.mn.x.pr(ofVar);
                }
            }
        });
        pr(str2);
    }

    public static void pr(String str) {
        com.byazt.dc.c cVarPr = pr();
        if (cVarPr != null) {
            cVarPr.pr(str, com.byazt.tq.c.CREATED);
        }
    }

    public static void hw(String str) {
        com.byazt.dc.c cVarPr = pr();
        if (cVarPr != null) {
            cVarPr.pr(str, com.byazt.tq.c.ATTACHED);
        }
    }

    public static void pr(String str, int i) {
        com.byazt.dc.c cVarPr = pr();
        if (cVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            cVarPr.pr(str, com.byazt.tq.c.FOCUSED, zoVar);
        }
    }

    public static void hn(String str) {
        com.byazt.dc.c cVarPr = pr();
        if (cVarPr != null) {
            cVarPr.pr(str, com.byazt.tq.c.VISIBLED);
        }
    }

    public static void x(String str) {
        com.byazt.dc.c cVarPr = pr();
        if (cVarPr != null) {
            cVarPr.pr(str, com.byazt.tq.c.INVISIBLED);
        }
    }

    public static void c(String str) {
        com.byazt.dc.c cVarPr = pr();
        if (cVarPr != null) {
            cVarPr.pr(str, com.byazt.tq.c.DETACHED);
        }
    }

    public static void hw(String str, int i) {
        com.byazt.dc.c cVarPr = pr();
        if (cVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            cVarPr.pr(str, com.byazt.tq.c.END, zoVar);
        }
    }

    public static com.byazt.dc.c pr() {
        return (com.byazt.dc.c) com.byazt.ewt.c.pr(5);
    }

    public static boolean uc(String str) {
        com.byazt.ewt.hw context = pr().getContext(str);
        return (context instanceof com.byazt.pv.c) && ((com.byazt.pv.c) context).pr != null;
    }
}
