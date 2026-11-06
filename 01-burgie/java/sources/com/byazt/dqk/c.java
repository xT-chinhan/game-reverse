package com.byazt.dqk;

import com.byazt.jv.a;
import com.byazt.nzn.g;
import com.byazt.nzn.nt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements com.byazt.nzn.aj.pr {
    public a.pr pr;

    public c(a.pr prVar) {
        this.pr = prVar;
    }

    @Override // com.byazt.nzn.aj.pr
    public g pr() {
        return new zo(this.pr.pr());
    }

    @Override // com.byazt.nzn.aj.pr
    public nt pr(g gVar) throws IOException {
        return new aj(this.pr.pr(this.pr.pr().uc().pr(gVar.hw().toString()).pr()));
    }
}
