package com.byazt.ccr;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public class rv implements oa<PointF, PointF> {
    public final qg n;
    public final qg qg;

    public rv(qg qgVar, qg qgVar2) {
        this.n = qgVar;
        this.qg = qgVar2;
    }

    @Override // com.byazt.ccr.oa
    public List<com.byazt.yt.n<PointF>> s() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.byazt.ccr.oa
    public boolean qg() {
        return this.n.qg() && this.qg.qg();
    }

    @Override // com.byazt.ccr.oa
    public com.byazt.bd.n<PointF, PointF> n() {
        return new com.byazt.bd.sz(this.n.n(), this.qg.n());
    }
}
