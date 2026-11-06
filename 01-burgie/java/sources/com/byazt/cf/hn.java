package com.byazt.cf;

import com.byazt.ewt.zo;
import com.byazt.xlm.fw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 440, 20})
public class hn implements com.byazt.mc.hw {
    @Override // com.byazt.mc.hw
    public void pr(com.byazt.pv.hw hwVar, zo zoVar) {
        if (hwVar == null) {
            return;
        }
        final long jPr = zoVar != null ? zoVar.pr() : System.currentTimeMillis();
        final String strHw = hwVar.hw();
        final int i = hwVar.k;
        final String str = hwVar.g;
        com.byazt.zp.zo.pr(new fw("tmax_record_on_ad_started") { // from class: com.byazt.cf.hn.1
            @Override // java.lang.Runnable
            public void run() {
                uc.pr().pr(strHw, i, str, jPr);
            }
        });
    }

    @Override // com.byazt.mc.hw
    public void hw(com.byazt.pv.hw hwVar, zo zoVar) {
    }

    @Override // com.byazt.mc.hw
    public void hn(com.byazt.pv.hw hwVar, zo zoVar) {
    }

    @Override // com.byazt.mc.hw
    public void x(com.byazt.pv.hw hwVar, zo zoVar) {
        if (hwVar == null) {
            return;
        }
        final String strHw = hwVar.hw();
        if (!hwVar.hn) {
            return;
        }
        final long jPr = zoVar != null ? zoVar.pr() : System.currentTimeMillis();
        com.byazt.zp.zo.pr(new fw("tmax_record_on_ad_loaded") { // from class: com.byazt.cf.hn.2
            @Override // java.lang.Runnable
            public void run() {
                uc.pr().pr(strHw, jPr);
            }
        });
    }
}
