package com.byazt.eqw;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c implements m<PointF, PointF> {
    public final List<com.byazt.cz.pr<PointF>> pr;

    public c(List<com.byazt.cz.pr<PointF>> list) {
        this.pr = list;
    }

    @Override // com.byazt.eqw.m
    public List<com.byazt.cz.pr<PointF>> hn() {
        return this.pr;
    }

    @Override // com.byazt.eqw.m
    public boolean hw() {
        return this.pr.size() == 1 && this.pr.get(0).c();
    }

    @Override // com.byazt.eqw.m
    public com.byazt.al.pr<PointF, PointF> pr() {
        if (this.pr.get(0).c()) {
            return new com.byazt.al.w(this.pr);
        }
        return new com.byazt.al.vk(this.pr);
    }
}
