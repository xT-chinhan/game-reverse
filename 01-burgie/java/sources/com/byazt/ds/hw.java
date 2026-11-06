package com.byazt.ds;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES, 13})
public class hw {
    public void pr(final com.byazt.tia.hw hwVar, final fw fwVar, int i) {
        com.byazt.cvl.c.pr().pr(new Runnable() { // from class: com.byazt.ds.hw.1
            @Override // java.lang.Runnable
            public void run() {
                if (aj.pr(hwVar)) {
                    fwVar.pr(false);
                } else if (!uc.pr(hwVar)) {
                    fwVar.pr(false);
                } else {
                    uc.pr(hwVar, new zo() { // from class: com.byazt.ds.hw.1.1
                        @Override // com.byazt.ds.zo
                        public void pr(boolean z) {
                            fwVar.pr(z);
                        }
                    });
                }
            }
        }, i);
    }
}
