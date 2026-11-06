package com.byazt.ccr;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, 110})
public abstract class sz<V, O> implements oa<V, O> {
    public final List<com.byazt.yt.n<V>> n;

    public sz(List<com.byazt.yt.n<V>> list) {
        this.n = list;
    }

    @Override // com.byazt.ccr.oa
    public List<com.byazt.yt.n<V>> s() {
        return this.n;
    }

    @Override // com.byazt.ccr.oa
    public boolean qg() {
        return this.n.isEmpty() || (this.n.size() == 1 && this.n.get(0).l());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.n.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.n.toArray()));
        }
        return sb.toString();
    }
}
