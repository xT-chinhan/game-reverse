package com.byazt.ccr;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, 18})
public class l implements oa<PointF, PointF> {
    public final List<com.byazt.yt.n<PointF>> n;

    public l(List<com.byazt.yt.n<PointF>> list) {
        this.n = list;
    }

    @Override // com.byazt.ccr.oa
    public List<com.byazt.yt.n<PointF>> s() {
        return this.n;
    }

    @Override // com.byazt.ccr.oa
    public boolean qg() {
        return this.n.size() == 1 && this.n.get(0).l();
    }

    @Override // com.byazt.ccr.oa
    public com.byazt.bd.n<PointF, PointF> n() {
        if (this.n.get(0).l()) {
            return new com.byazt.bd.cp(this.n);
        }
        return new com.byazt.bd.tj(this.n);
    }
}
