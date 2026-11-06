package com.byazt.dqk;

import com.byazt.jv.b;
import com.byazt.nzn.g;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1320, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME})
public class zo extends g {
    public b hw;

    public zo(b bVar) {
        this.hw = bVar;
    }

    @Override // com.byazt.nzn.g
    public Object pr() {
        return this.hw.c();
    }

    @Override // com.byazt.nzn.g
    public com.byazt.nzn.fw hw() {
        return com.byazt.nzn.fw.hn(this.hw.pr().toString());
    }

    @Override // com.byazt.nzn.g
    public String hn() {
        return this.hw.hw();
    }

    @Override // com.byazt.nzn.g
    public Map x() {
        return this.hw.hn().hn();
    }

    @Override // com.byazt.nzn.g
    public com.byazt.nzn.pr c() {
        return new com.byazt.nzn.pr.C0150pr().pr().hw();
    }

    public String toString() {
        return this.hw.toString();
    }

    @Override // com.byazt.nzn.g
    public g.pr fw() {
        return super.fw();
    }
}
