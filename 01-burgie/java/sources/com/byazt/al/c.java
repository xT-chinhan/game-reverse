package com.byazt.al;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 60, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends fw<com.byazt.ynb.x> {
    public final com.byazt.ynb.x x;

    public c(List<com.byazt.cz.pr<com.byazt.ynb.x>> list) {
        super(list);
        com.byazt.ynb.x xVar = list.get(0).pr;
        int iHn = xVar != null ? xVar.hn() : 0;
        this.x = new com.byazt.ynb.x(new float[iHn], new int[iHn]);
    }

    @Override // com.byazt.al.pr
    /* JADX INFO: renamed from: hw, reason: merged with bridge method [inline-methods] */
    public com.byazt.ynb.x pr(com.byazt.cz.pr<com.byazt.ynb.x> prVar, float f) {
        this.x.pr(prVar.pr, prVar.hw, f);
        return this.x;
    }
}
