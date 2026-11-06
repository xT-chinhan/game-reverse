package com.byazt.gj;

import com.byazt.hg.of;
import com.byazt.ld.nt;
import com.byazt.sd.a;
import com.byazt.wt.ho;
import com.byazt.wt.yb;
import com.byazt.zn.fw;
import com.byazt.zn.zo;
import com.byazt.zp.w;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 504, 13})
public class hw implements com.byazt.io.pr {
    public fw pr = new fw();

    @Override // com.byazt.io.pr
    public void pr(com.byazt.zn.hw hwVar, com.byazt.vx.hn<zo, fw> hnVar) {
        hw(hwVar, hnVar);
    }

    private void hw(final com.byazt.zn.hw hwVar, final com.byazt.vx.hn<zo, fw> hnVar) {
        if (hwVar == null || hnVar == null) {
            return;
        }
        this.pr.hw(hwVar.m());
        this.pr.pr(hwVar.hw());
        if (a.hw().zo(hwVar.zo()) == 4) {
            zo zoVar = new zo(hwVar.hw(), hwVar.m());
            zoVar.pr(false);
            zoVar.pr(hwVar.pr());
            zoVar.pr(hwVar.hn());
            hnVar.hw(zoVar);
            return;
        }
        com.byazt.vl.hw hwVarX = hwVar.x();
        if (hwVarX == null) {
            this.pr.hw(2);
            this.pr.pr("image request fail");
            this.pr.pr(false);
            hnVar.pr(this.pr);
            return;
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "加载图片素材 " + hwVar.hw().ny());
        yb.pr(hwVarX, hwVar.c(), hwVar.uc(), new yb.pr() { // from class: com.byazt.gj.hw.1
            @Override // com.byazt.wt.yb.pr
            public void pr(com.byazt.bd.hw hwVar2, nt ntVar) {
                zo zoVar2 = new zo(hwVar2, hwVar.hw(), hwVar.m());
                zoVar2.pr(false);
                zoVar2.pr(hwVar.pr());
                zoVar2.c(hwVar.hn());
                if (ntVar != null) {
                    zoVar2.pr(ntVar.fw());
                    zoVar2.hw(ntVar.aj());
                    zoVar2.hw(ho.pr(ntVar.fw()));
                    if (ntVar.vk() != null) {
                        zoVar2.hw(ntVar.vk().hw());
                        zoVar2.hn(ntVar.vk().pr());
                        zoVar2.x(ntVar.vk().hn());
                    }
                }
                hnVar.hw(zoVar2);
            }

            @Override // com.byazt.wt.yb.pr
            public void pr() {
                hw.this.pr.hw(2);
                hw.this.pr.pr("load image fail");
                hw.this.pr.pr(false);
                hnVar.pr(hw.this.pr);
            }
        }, w.c(), 4, new com.byazt.ld.a() { // from class: com.byazt.gj.hw.2
            @Override // com.byazt.ld.a
            public void pr(int i, Object obj) {
                if (i == 3 && hw.this.pr(hwVar)) {
                    zo zoVar2 = new zo(hwVar.hw(), hwVar.m());
                    zoVar2.pr(false);
                    zoVar2.pr(hwVar.pr());
                    zoVar2.pr(hwVar.hn());
                    zoVar2.x(true);
                    zoVar2.hw(false);
                    hnVar.hn(zoVar2);
                }
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(com.byazt.zn.hw hwVar) {
        of ofVarHw;
        if (hwVar == null || (ofVarHw = hwVar.hw()) == null) {
            return false;
        }
        int iOj = ofVarHw.oj();
        if (iOj != 3 && iOj != 4) {
            return false;
        }
        return true;
    }
}
