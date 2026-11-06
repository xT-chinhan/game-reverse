package com.byazt.tg;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.hg.bh;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c extends pr {
    public c(of ofVar, com.byazt.uq.pr prVar, bh bhVar) {
        super(ofVar, prVar, bhVar);
    }

    public void pr(View view) {
        ViewGroup viewGroupHn;
        if (view == null || this.x == null || !com.byazt.uq.x.pr(this.x.x()) || (viewGroupHn = com.byazt.uq.x.hn(view)) == null) {
            return;
        }
        hw(viewGroupHn, viewGroupHn);
    }
}
