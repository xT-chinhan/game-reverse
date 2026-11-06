package com.byazt.tg;

import com.byazt.hg.b;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 13})
public class hw extends pr {
    public Runnable uc;

    public hw(of ofVar, com.byazt.uq.pr prVar) {
        super(ofVar, prVar, b.aj(ofVar));
        this.hn = new com.byazt.fq.pr(ofVar, b.aj(ofVar));
    }

    public void pr(Runnable runnable) {
        this.uc = runnable;
    }

    @Override // com.byazt.tg.pr
    public void pr(bh bhVar) {
        super.pr(bhVar);
        if (this.hn != null) {
            this.hn.pr(bhVar);
        }
    }

    @Override // com.byazt.uq.hw
    public void hn() {
        Runnable runnable = this.uc;
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
            }
        }
    }
}
