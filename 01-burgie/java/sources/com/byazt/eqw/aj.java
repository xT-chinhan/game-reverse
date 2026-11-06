package com.byazt.eqw;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, 61})
public class aj implements m<PointF, PointF> {
    public final hw hw;
    public final hw pr;

    public aj(hw hwVar, hw hwVar2) {
        this.pr = hwVar;
        this.hw = hwVar2;
    }

    @Override // com.byazt.eqw.m
    public List<com.byazt.cz.pr<PointF>> hn() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.byazt.eqw.m
    public boolean hw() {
        return this.pr.hw() && this.hw.hw();
    }

    @Override // com.byazt.eqw.m
    public com.byazt.al.pr<PointF, PointF> pr() {
        return new com.byazt.al.g(this.pr.pr(), this.hw.pr());
    }
}
