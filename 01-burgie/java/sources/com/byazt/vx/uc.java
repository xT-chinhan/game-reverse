package com.byazt.vx;

import com.byazt.hg.ie;
import com.byazt.zn.fw;
import com.byazt.zn.zo;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1155, 5})
public class uc {
    public hn<zo, fw> hn;
    public com.byazt.zn.hw hw;
    public com.byazt.io.pr pr;

    public uc(com.byazt.zn.hw hwVar, hn<zo, fw> hnVar) {
        if (hwVar == null || hnVar == null) {
            return;
        }
        this.hw = hwVar;
        this.hn = hnVar;
        if (hwVar.vk() == 1) {
            this.pr = new com.byazt.gj.hw();
        } else {
            this.pr = new com.byazt.gj.x();
        }
    }

    public boolean pr() {
        return this.pr instanceof com.byazt.gj.x;
    }

    public void hw() {
        com.byazt.zn.hw hwVar = this.hw;
        if (hwVar == null || this.hn == null) {
            return;
        }
        com.byazt.io.pr prVar = this.pr;
        if (prVar instanceof com.byazt.gj.hw) {
            prVar.pr(hwVar, new hn<zo, fw>() { // from class: com.byazt.vx.uc.1
                @Override // com.byazt.vx.hn
                /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                public void hn(zo zoVar) {
                    if (zoVar != null) {
                        zoVar.c(false);
                    }
                    uc.this.hn.hn(zoVar);
                }

                @Override // com.byazt.vx.hn
                public void hw(zo zoVar) {
                    if (zoVar != null) {
                        zoVar.c(true);
                    }
                    uc.this.hn.hw(zoVar);
                    com.byazt.jm.zo.pr(uc.this.hw.w());
                }

                @Override // com.byazt.vx.hn
                public void pr(fw fwVar) {
                    uc.this.hn.pr(fwVar);
                }
            });
        } else {
            prVar.pr(hwVar, new hn<zo, fw>() { // from class: com.byazt.vx.uc.2
                @Override // com.byazt.vx.hn
                /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                public void hn(zo zoVar) {
                    if (zoVar != null) {
                        zoVar.c(false);
                    }
                    uc.this.hn.hn(zoVar);
                }

                @Override // com.byazt.vx.hn
                public void hw(zo zoVar) {
                    if (zoVar != null) {
                        zoVar.c(true);
                    }
                    uc.this.hn.hw(zoVar);
                }

                @Override // com.byazt.vx.hn
                public void pr(fw fwVar) {
                    if (uc.this.hw.k() && uc.this.hw.hw() != null) {
                        ie.pr(uc.this.hw.hw(), 1);
                    }
                    new com.byazt.gj.hw().pr(uc.this.hw, uc.this.hn);
                }
            });
        }
    }
}
