package com.byazt.dc;

import com.byazt.ewt.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 32, 121})
public class x extends com.byazt.ewt.x<com.byazt.tq.x, com.byazt.pv.x> {
    public final com.byazt.mc.x hw = new com.byazt.mc.x() { // from class: com.byazt.dc.x.1
        @Override // com.byazt.mc.x
        public void pr(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void hw(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void hn(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void x(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void c(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void uc(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void fw(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void zo(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void aj(com.byazt.pv.x xVar, zo zoVar) {
        }

        @Override // com.byazt.mc.x
        public void vk(com.byazt.pv.x xVar, zo zoVar) {
            com.byazt.ewt.hn hnVar;
            if (xVar != null && xVar.hw() != null && (hnVar = (com.byazt.ewt.hn) x.this.pr.remove(xVar.hw())) != null) {
                hnVar.hw(x.this.hw);
            }
        }
    };

    public void hw(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.ui.x xVar = new com.byazt.ui.x(str, str2);
        xVar.pr(this.hw);
        pr(str, xVar);
    }

    public void pr(String str, com.byazt.tq.x xVar, zo zoVar) {
        com.byazt.ewt.hn<com.byazt.tq.x, com.byazt.pv.x> hnVarPr = pr(str);
        if (hnVarPr instanceof com.byazt.ui.x) {
            ((com.byazt.ui.x) hnVarPr).pr(xVar, zoVar);
        }
    }

    public void pr(String str, com.byazt.tq.x xVar) {
        pr(str, xVar, null);
    }
}
