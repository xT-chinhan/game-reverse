package com.byazt.dc;

import com.byazt.ewt.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 32, 37})
public class pr extends com.byazt.ewt.x<com.byazt.tq.pr, com.byazt.pv.pr> {
    public final com.byazt.mc.pr hw = new com.byazt.mc.pr() { // from class: com.byazt.dc.pr.1
        @Override // com.byazt.mc.pr
        public void pr(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void hw(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void hn(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void x(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void c(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void uc(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void fw(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void zo(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void aj(com.byazt.pv.pr prVar, zo zoVar) {
        }

        @Override // com.byazt.mc.pr
        public void vk(com.byazt.pv.pr prVar, zo zoVar) {
            com.byazt.ewt.hn hnVar;
            if (prVar != null && prVar.hw() != null && (hnVar = (com.byazt.ewt.hn) pr.this.pr.remove(prVar.hw())) != null) {
                hnVar.hw(pr.this.hw);
            }
        }
    };

    public void hw(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.ui.pr prVar = new com.byazt.ui.pr(str, str2);
        prVar.pr(this.hw);
        pr(str, prVar);
    }

    public void pr(String str, com.byazt.tq.pr prVar, zo zoVar) {
        com.byazt.ewt.hn<com.byazt.tq.pr, com.byazt.pv.pr> hnVarPr = pr(str);
        if (hnVarPr instanceof com.byazt.ui.pr) {
            ((com.byazt.ui.pr) hnVarPr).pr(prVar, zoVar);
        }
    }

    public void pr(String str, com.byazt.tq.pr prVar) {
        pr(str, prVar, null);
    }
}
