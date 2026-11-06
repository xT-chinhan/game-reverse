package com.byazt.jh;

import com.byazt.ea.hn;
import com.byazt.hfm.x;
import com.byazt.hg.ie;
import com.byazt.hg.of;
import com.byazt.xlm.c;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 37})
public class pr {
    public static void pr(of ofVar, final hn hnVar) {
        final x xVarVk;
        if (ofVar == null || ie.aj(ofVar) || (xVarVk = ie.vk(ofVar)) == null) {
            return;
        }
        c.pr(new fw("saveTemplate") { // from class: com.byazt.jh.pr.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.ce.fw.pr().pr(xVarVk, new com.byazt.ce.fw.pr() { // from class: com.byazt.jh.pr.1.1
                    @Override // com.byazt.ce.fw.pr
                    public void pr() {
                        if (hnVar != null) {
                            hnVar.pr(null);
                        }
                    }

                    @Override // com.byazt.ce.fw.pr
                    public void hw() {
                        if (hnVar != null) {
                            hnVar.pr();
                        }
                    }
                });
            }
        }, 10);
    }
}
