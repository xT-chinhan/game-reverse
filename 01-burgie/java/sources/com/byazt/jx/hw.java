package com.byazt.jx;

import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, 13})
public class hw implements com.byazt.wt.pr.hw {
    private hw() {
        com.byazt.wt.pr prVarHn = com.byazt.sd.zo.nt().hn();
        if (prVarHn != null) {
            prVarHn.pr(this);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD})
    private static class pr {
        public static hw pr = new hw();
    }

    public static hw c() {
        return pr.pr;
    }

    @Override // com.byazt.wt.pr.hw
    public void pr() {
    }

    @Override // com.byazt.wt.pr.hw
    public void hw() {
        com.byazt.zp.zo.pr(new com.byazt.xlm.fw("dl_work") { // from class: com.byazt.jx.hw.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.sd.zo.nt().pr(aj.pr((of) null, true));
            }
        });
    }

    @Override // com.byazt.wt.pr.hw
    public void hn() {
    }

    @Override // com.byazt.wt.pr.hw
    public void x() {
    }
}
