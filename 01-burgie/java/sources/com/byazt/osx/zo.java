package com.byazt.osx;

import com.byazt.jv.cz;
import com.byazt.jv.nl;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 442, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public final class zo extends nl {
    public final com.byazt.du.c hn;
    public final long hw;
    public final String pr;

    public zo(String str, long j, com.byazt.du.c cVar) {
        this.pr = str;
        this.hw = j;
        this.hn = cVar;
    }

    @Override // com.byazt.jv.nl
    public cz pr() {
        String str = this.pr;
        if (str != null) {
            return cz.pr(str);
        }
        return null;
    }

    @Override // com.byazt.jv.nl
    public long hw() {
        return this.hw;
    }

    @Override // com.byazt.jv.nl
    public com.byazt.du.c hn() {
        return this.hn;
    }
}
