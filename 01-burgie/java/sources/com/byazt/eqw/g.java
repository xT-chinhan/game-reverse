package com.byazt.eqw;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public abstract class g<V, O> implements m<V, O> {
    public final List<com.byazt.cz.pr<V>> pr;

    public g(List<com.byazt.cz.pr<V>> list) {
        this.pr = list;
    }

    @Override // com.byazt.eqw.m
    public List<com.byazt.cz.pr<V>> hn() {
        return this.pr;
    }

    @Override // com.byazt.eqw.m
    public boolean hw() {
        return this.pr.isEmpty() || (this.pr.size() == 1 && this.pr.get(0).c());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.pr.isEmpty()) {
            sb.append("values=").append(Arrays.toString(this.pr.toArray()));
        }
        return sb.toString();
    }
}
