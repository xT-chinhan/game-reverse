package com.byazt.cf;

import android.text.TextUtils;
import com.byazt.ewt.zo;
import com.byazt.xlm.fw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 440, 121})
public class x implements com.byazt.mc.hn {
    @Override // com.byazt.mc.hn
    public void pr(com.byazt.pv.hn hnVar, zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void hw(com.byazt.pv.hn hnVar, zo zoVar) {
        if (hnVar == null || TextUtils.isEmpty(hnVar.pr)) {
            return;
        }
        final String str = hnVar.pr;
        final long jPr = zoVar != null ? zoVar.pr() : System.currentTimeMillis();
        com.byazt.zp.zo.pr(new fw("tmax_record_on_ad_start") { // from class: com.byazt.cf.x.1
            @Override // java.lang.Runnable
            public void run() {
                uc.pr().hn(str, jPr);
            }
        });
    }

    @Override // com.byazt.mc.hn
    public void hn(com.byazt.pv.hn hnVar, zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void x(com.byazt.pv.hn hnVar, zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void c(com.byazt.pv.hn hnVar, zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void uc(com.byazt.pv.hn hnVar, zo zoVar) {
    }

    @Override // com.byazt.mc.hn
    public void fw(com.byazt.pv.hn hnVar, zo zoVar) {
        if (hnVar == null || TextUtils.isEmpty(hnVar.pr)) {
            return;
        }
        final String str = hnVar.pr;
        final long jPr = zoVar != null ? zoVar.pr() : System.currentTimeMillis();
        com.byazt.zp.zo.pr(new fw("tmax_record_on_ad_end") { // from class: com.byazt.cf.x.2
            @Override // java.lang.Runnable
            public void run() {
                uc.pr().x(str, jPr);
            }
        });
    }
}
