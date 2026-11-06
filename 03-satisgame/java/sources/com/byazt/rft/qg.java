package com.byazt.rft;

import com.byazt.tbt.cy;
import com.byazt.tbt.rv;
import com.byazt.tbt.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 26})
public class qg implements rv.n {
    public List<rv> n;
    public sz qg;
    public int s = 0;

    public qg(List<rv> list, sz szVar) {
        this.n = list;
        this.qg = szVar;
    }

    @Override // com.byazt.tbt.rv.n
    public sz n() {
        return this.qg;
    }

    @Override // com.byazt.tbt.rv.n
    public cy n(sz szVar) throws IOException {
        this.qg = szVar;
        int i = this.s + 1;
        this.s = i;
        return this.n.get(i).n(this);
    }
}
