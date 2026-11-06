package com.byazt.dc;

import com.byazt.pv.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 32, 62})
public class fw extends com.byazt.ewt.x<com.byazt.tq.fw, zo> {
    public final com.byazt.mc.fw hw = new com.byazt.mc.fw() { // from class: com.byazt.dc.fw.1
        @Override // com.byazt.mc.fw
        public void pr(zo zoVar, com.byazt.ewt.zo zoVar2) {
        }

        @Override // com.byazt.mc.fw
        public void hw(zo zoVar, com.byazt.ewt.zo zoVar2) {
        }

        @Override // com.byazt.mc.fw
        public void hn(zo zoVar, com.byazt.ewt.zo zoVar2) {
        }

        @Override // com.byazt.mc.fw
        public void x(zo zoVar, com.byazt.ewt.zo zoVar2) {
        }

        @Override // com.byazt.mc.fw
        public void c(zo zoVar, com.byazt.ewt.zo zoVar2) {
        }

        @Override // com.byazt.mc.fw
        public void uc(zo zoVar, com.byazt.ewt.zo zoVar2) {
        }

        @Override // com.byazt.mc.fw
        public void fw(zo zoVar, com.byazt.ewt.zo zoVar2) {
        }

        @Override // com.byazt.mc.fw
        public void zo(zo zoVar, com.byazt.ewt.zo zoVar2) {
            com.byazt.ewt.hn hnVar;
            if (zoVar != null && zoVar.hw() != null && (hnVar = (com.byazt.ewt.hn) fw.this.pr.remove(zoVar.hw())) != null) {
                hnVar.hw(fw.this.hw);
            }
        }
    };

    public void hw(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.ui.fw fwVar = new com.byazt.ui.fw(str, str2);
        fwVar.pr(this.hw);
        pr(str, fwVar);
    }

    public void pr(String str, com.byazt.tq.fw fwVar, com.byazt.ewt.zo zoVar) {
        com.byazt.ewt.hn<com.byazt.tq.fw, zo> hnVarPr = pr(str);
        if (hnVarPr instanceof com.byazt.ui.fw) {
            ((com.byazt.ui.fw) hnVarPr).pr(fwVar, zoVar);
        }
    }

    public void pr(String str, com.byazt.tq.fw fwVar) {
        pr(str, fwVar, null);
    }
}
