package com.byazt.t;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL, 26})
public class qg {
    public void n(final com.byazt.h.qg qgVar, final x xVar, int i) {
        com.byazt.s.l.n().n(new Runnable() { // from class: com.byazt.t.qg.1
            @Override // java.lang.Runnable
            public void run() {
                if (rv.n(qgVar)) {
                    xVar.n(false);
                } else if (!w.n(qgVar)) {
                    xVar.n(false);
                } else {
                    w.n(qgVar, new fs() { // from class: com.byazt.t.qg.1.1
                        @Override // com.byazt.t.fs
                        public void n(boolean z) {
                            xVar.n(z);
                        }
                    });
                }
            }
        }, i);
    }
}
