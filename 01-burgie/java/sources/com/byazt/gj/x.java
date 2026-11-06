package com.byazt.gj;

import android.os.SystemClock;
import android.text.TextUtils;
import com.byazt.ca.c;
import com.byazt.ca.yb;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.ihe.m;
import com.byazt.n.uc;
import com.byazt.sd.a;
import com.byazt.zn.fw;
import com.byazt.zn.zo;
import com.byazt.zp.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 504, 121})
public class x implements com.byazt.io.pr {
    public fw pr = new fw();

    @Override // com.byazt.io.pr
    public void pr(com.byazt.zn.hw hwVar, com.byazt.vx.hn<zo, fw> hnVar) {
        hw(hwVar, hnVar);
    }

    private void hw(com.byazt.zn.hw hwVar, com.byazt.vx.hn<zo, fw> hnVar) {
        uc ucVarPr;
        if (hwVar == null || hnVar == null) {
            return;
        }
        this.pr.hw(hwVar.m());
        this.pr.pr(hwVar.hw());
        int iZo = hwVar.zo();
        com.byazt.n.x xVarFw = hwVar.fw();
        this.pr.pr(true);
        if (xVarFw == null) {
            this.pr.hw(2);
            this.pr.pr("no video info");
            hnVar.pr(this.pr);
            return;
        }
        String strK = xVarFw.k();
        if (TextUtils.isEmpty(strK)) {
            this.pr.hw(2);
            this.pr.pr("no video url");
            hnVar.pr(this.pr);
            return;
        }
        String strHo = xVarFw.ho();
        if (TextUtils.isEmpty(strHo)) {
            strHo = c.hw(strK);
        }
        if (TextUtils.isEmpty(strHo)) {
            this.pr.hw(2);
            this.pr.pr("no video cahce filename");
            hnVar.pr(this.pr);
            return;
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "加载视频素材");
        of ofVarHw = hwVar.hw();
        if (ofVarHw == null) {
            return;
        }
        boolean zAj = hwVar.aj();
        xVarFw.uc(1);
        if (xVarFw.nt() == 0) {
            xVarFw.c(307200);
        }
        if (zAj) {
            ucVarPr = qv.pr(2, ofVarHw);
        } else {
            ucVarPr = qv.pr(3, ofVarHw);
        }
        ucVarPr.pr("material_meta", ofVarHw);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (w.pr(ofVarHw.sd()).pr(ucVarPr)) {
            zo zoVar = new zo(hwVar.hw(), hwVar.m());
            zoVar.pr(true);
            zoVar.hn(true);
            zoVar.pr(hwVar.pr());
            zoVar.c(hwVar.hn());
            hnVar.hw(zoVar);
            ucVarPr.aj(1);
            com.byazt.it.hn.pr(ucVarPr, ofVarHw, SystemClock.elapsedRealtime() - jElapsedRealtime);
            return;
        }
        if (a.hw().fw(String.valueOf(iZo)) && !yb.x(a.getContext())) {
            this.pr.hw(2);
            this.pr.pr("network error");
            hnVar.pr(this.pr);
        } else {
            if (hwVar.hw() != null && hwVar.hw().sx() == 3) {
                zo zoVar2 = new zo(hwVar.hw(), hwVar.m());
                zoVar2.pr(true);
                zoVar2.hn(false);
                zoVar2.pr(hwVar.pr());
                zoVar2.c(hwVar.hn());
                zoVar2.pr(qv.pr(hwVar.hw()));
                hnVar.hw(zoVar2);
                return;
            }
            com.byazt.s.pr.pr();
            pr(ucVarPr, hwVar, hwVar.hw(), hnVar);
        }
    }

    private void pr(uc ucVar, final com.byazt.zn.hw hwVar, of ofVar, final com.byazt.vx.hn<zo, fw> hnVar) {
        if (ofVar == null || hnVar == null || hwVar == null || ucVar == null || qv.ho(ofVar) == null) {
            return;
        }
        com.byazt.it.hn.pr(ucVar, new com.byazt.e.pr() { // from class: com.byazt.gj.x.1
            @Override // com.byazt.ihe.vk.pr
            public void hw(m mVar, int i) {
                if (hnVar != null) {
                    zo zoVar = new zo(hwVar.hw(), hwVar.m());
                    zoVar.pr(true);
                    zoVar.hn(false);
                    zoVar.pr(hwVar.pr());
                    zoVar.c(hwVar.hn());
                    hnVar.hw(zoVar);
                }
            }

            @Override // com.byazt.ihe.vk.pr
            public void pr(m mVar, int i, String str) {
                if (hnVar != null) {
                    x.this.pr.hw(2);
                    x.this.pr.pr("preload video fail");
                    hnVar.pr(x.this.pr);
                }
            }
        });
    }
}
