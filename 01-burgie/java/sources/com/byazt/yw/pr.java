package com.byazt.yw;

import android.content.Context;
import com.byazt.ik.hn;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_INFOS, 37})
public class pr extends hn<CycleSkipView> {
    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.ik.hn
    /* JADX INFO: renamed from: fw, reason: merged with bridge method [inline-methods] */
    public CycleSkipView pr() {
        return new CycleSkipView(this.hw);
    }

    @Override // com.byazt.ik.hn
    public void hw() {
        super.hw();
    }

    public void hw(int i, int i2) {
        if (this.c != 0) {
            ((CycleSkipView) this.c).pr(i, i2);
        }
    }
}
