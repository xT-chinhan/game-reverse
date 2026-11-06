package com.byazt.dc;

import com.byazt.ewt.zo;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 32, 13})
public class hw extends com.byazt.ewt.x<com.byazt.tq.hw, com.byazt.pv.hw> {
    public final com.byazt.mc.hw hw = new com.byazt.mc.hw() { // from class: com.byazt.dc.hw.1
        @Override // com.byazt.mc.hw
        public void pr(com.byazt.pv.hw hwVar, zo zoVar) {
        }

        @Override // com.byazt.mc.hw
        public void hw(com.byazt.pv.hw hwVar, zo zoVar) {
        }

        @Override // com.byazt.mc.hw
        public void hn(com.byazt.pv.hw hwVar, zo zoVar) {
        }

        @Override // com.byazt.mc.hw
        public void x(com.byazt.pv.hw hwVar, zo zoVar) {
            com.byazt.ewt.hn hnVar;
            if (hwVar != null && hwVar.hw() != null && (hnVar = (com.byazt.ewt.hn) hw.this.pr.remove(hwVar.hw())) != null) {
                hnVar.hw(hw.this.hw);
            }
        }
    };

    public void hw(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.ui.hw hwVar = new com.byazt.ui.hw(str, str2);
        hwVar.pr(this.hw);
        pr(str, hwVar);
    }

    public void pr(String str, com.byazt.tq.hw hwVar, zo zoVar) {
        com.byazt.ewt.hn<com.byazt.tq.hw, com.byazt.pv.hw> hnVarPr = pr(str);
        if (hnVarPr instanceof com.byazt.ui.hw) {
            ((com.byazt.ui.hw) hnVarPr).pr(hwVar, zoVar);
        }
    }

    public void pr(String str, com.byazt.tq.hw hwVar) {
        pr(str, hwVar, null);
    }
}
