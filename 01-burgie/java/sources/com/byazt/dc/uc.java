package com.byazt.dc;

import com.byazt.ewt.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 32, 5})
public class uc extends com.byazt.ewt.x<com.byazt.tq.uc, com.byazt.pv.uc> {
    public final com.byazt.mc.uc hw = new com.byazt.mc.uc() { // from class: com.byazt.dc.uc.1
        @Override // com.byazt.mc.uc
        public void pr(com.byazt.pv.uc ucVar, zo zoVar) {
        }

        @Override // com.byazt.mc.uc
        public void hw(com.byazt.pv.uc ucVar, zo zoVar) {
        }

        @Override // com.byazt.mc.uc
        public void hn(com.byazt.pv.uc ucVar, zo zoVar) {
        }

        @Override // com.byazt.mc.uc
        public void x(com.byazt.pv.uc ucVar, zo zoVar) {
            com.byazt.ewt.hn hnVar;
            if (ucVar != null && ucVar.hw() != null && (hnVar = (com.byazt.ewt.hn) uc.this.pr.remove(ucVar.hw())) != null) {
                hnVar.hw(uc.this.hw);
            }
        }
    };

    public void hw(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.ui.uc ucVar = new com.byazt.ui.uc(str, str2);
        ucVar.pr(this.hw);
        pr(str, ucVar);
    }

    public void pr(String str, com.byazt.tq.uc ucVar, zo zoVar) {
        com.byazt.ewt.hn<com.byazt.tq.uc, com.byazt.pv.uc> hnVarPr = pr(str);
        if (hnVarPr instanceof com.byazt.ui.uc) {
            ((com.byazt.ui.uc) hnVarPr).pr(ucVar, zoVar);
        }
    }

    public void pr(String str, com.byazt.tq.uc ucVar) {
        pr(str, ucVar, null);
    }
}
