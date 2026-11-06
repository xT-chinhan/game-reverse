package com.byazt.dc;

import com.byazt.ewt.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 32, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends com.byazt.ewt.x<com.byazt.tq.c, com.byazt.pv.c> {
    public final com.byazt.mc.c hw = new com.byazt.mc.c() { // from class: com.byazt.dc.c.1
        @Override // com.byazt.mc.c
        public void pr(com.byazt.pv.c cVar, zo zoVar) {
        }

        @Override // com.byazt.mc.c
        public void hw(com.byazt.pv.c cVar, zo zoVar) {
        }

        @Override // com.byazt.mc.c
        public void hn(com.byazt.pv.c cVar, zo zoVar) {
        }

        @Override // com.byazt.mc.c
        public void x(com.byazt.pv.c cVar, zo zoVar) {
        }

        @Override // com.byazt.mc.c
        public void c(com.byazt.pv.c cVar, zo zoVar) {
        }

        @Override // com.byazt.mc.c
        public void uc(com.byazt.pv.c cVar, zo zoVar) {
        }

        @Override // com.byazt.mc.c
        public void fw(com.byazt.pv.c cVar, zo zoVar) {
            com.byazt.ewt.hn hnVar;
            if (cVar != null && cVar.hw() != null && (hnVar = (com.byazt.ewt.hn) c.this.pr.remove(cVar.hw())) != null) {
                hnVar.hw(c.this.hw);
            }
        }
    };

    public void hw(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.ui.c cVar = new com.byazt.ui.c(str, str2);
        cVar.pr(this.hw);
        pr(str, cVar);
    }

    public void pr(String str, com.byazt.tq.c cVar, zo zoVar) {
        com.byazt.ewt.hn<com.byazt.tq.c, com.byazt.pv.c> hnVarPr = pr(str);
        if (hnVarPr instanceof com.byazt.ui.c) {
            ((com.byazt.ui.c) hnVarPr).pr(cVar, zoVar);
        }
    }

    public void pr(String str, com.byazt.tq.c cVar) {
        pr(str, cVar, null);
    }
}
