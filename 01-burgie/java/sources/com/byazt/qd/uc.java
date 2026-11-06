package com.byazt.qd;

import com.byazt.dc.fw;
import com.byazt.hg.of;
import com.byazt.pv.zo;
import com.byazt.tb.w;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 224, 5})
public class uc {
    public static void pr(final of ofVar, final String str, final int i, final int i2, String str2) {
        if (ofVar == null) {
            return;
        }
        fw fwVarPr = pr();
        fwVarPr.hw(str2, ofVar.yn());
        fwVarPr.pr(str2, new w());
        fwVarPr.pr(str2, new com.byazt.ewt.x.pr() { // from class: com.byazt.qd.uc.1
            @Override // com.byazt.ewt.x.pr
            public void pr(com.byazt.ewt.hw hwVar) {
                if (hwVar instanceof zo) {
                    zo zoVar = (zo) hwVar;
                    zoVar.ho = ofVar;
                    zoVar.k = i;
                    zoVar.g = str;
                    zoVar.pr = i2;
                    zoVar.m = com.byazt.mn.x.pr(ofVar);
                }
            }
        });
        pr(str2);
    }

    public static void pr(String str) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            fwVarPr.pr(str, com.byazt.tq.fw.CREATED);
        }
    }

    public static void hw(String str) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            fwVarPr.pr(str, com.byazt.tq.fw.STARTED);
        }
    }

    public static void pr(String str, int i) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            fwVarPr.pr(str, com.byazt.tq.fw.LOADED, zoVar);
        }
    }

    public static void hn(String str) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            fwVarPr.pr(str, com.byazt.tq.fw.RENDER_STARTED);
        }
    }

    public static void hw(String str, int i) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            fwVarPr.pr(str, com.byazt.tq.fw.RENDERED, zoVar);
        }
    }

    public static void hn(String str, int i) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            fwVarPr.pr(str, com.byazt.tq.fw.SHOWED, zoVar);
        }
    }

    public static void x(String str) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            fwVarPr.pr(str, com.byazt.tq.fw.CLICKED);
        }
    }

    public static void x(String str, int i) {
        fw fwVarPr = pr();
        if (fwVarPr != null) {
            com.byazt.ewt.zo zoVar = new com.byazt.ewt.zo(System.currentTimeMillis());
            zoVar.pr("source", Integer.valueOf(i));
            fwVarPr.pr(str, com.byazt.tq.fw.END, zoVar);
        }
    }

    public static fw pr() {
        return (fw) com.byazt.ewt.c.pr(6);
    }
}
