package com.byazt.dc;

import com.byazt.ewt.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 32, 20})
public class hn extends com.byazt.ewt.x<com.byazt.tq.hn, com.byazt.pv.hn> {
    public final com.byazt.mc.hn hw = new com.byazt.mc.hn() { // from class: com.byazt.dc.hn.1
        @Override // com.byazt.mc.hn
        public void pr(com.byazt.pv.hn hnVar, zo zoVar) {
        }

        @Override // com.byazt.mc.hn
        public void hw(com.byazt.pv.hn hnVar, zo zoVar) {
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
            com.byazt.ewt.hn hnVar2;
            if (hnVar != null && hnVar.hw() != null && (hnVar2 = (com.byazt.ewt.hn) hn.this.pr.remove(hnVar.hw())) != null) {
                hnVar2.hw(hn.this.hw);
            }
        }
    };

    public void hw(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.ui.hn hnVar = new com.byazt.ui.hn(str, str2);
        hnVar.pr(this.hw);
        pr(str, hnVar);
    }

    public void pr(String str, com.byazt.tq.hn hnVar, zo zoVar) {
        com.byazt.ewt.hn<com.byazt.tq.hn, com.byazt.pv.hn> hnVarPr = pr(str);
        if (hnVarPr instanceof com.byazt.ui.hn) {
            ((com.byazt.ui.hn) hnVarPr).pr(hnVar, zoVar);
        }
    }

    public void pr(String str, com.byazt.tq.hn hnVar) {
        pr(str, hnVar, null);
    }
}
