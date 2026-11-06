package com.byazt.se;

import android.content.Context;
import com.byazt.vlj.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 5})
@Deprecated
public class uc extends hn {
    public uc(Context context, hw hwVar, x xVar) {
        super(com.byazt.vlj.hn.CUSTOM_JAVA, context, hwVar, xVar);
    }

    @Override // com.byazt.se.hn
    public com.byazt.lee.pr pr(com.byazt.lee.pr prVar) {
        com.byazt.lee.pr prVarPr = super.pr(prVar);
        com.byazt.lee.hw hwVarPr = com.byazt.lee.hw.pr(this.hw);
        hwVarPr.pr(zo.pr().pr());
        hwVarPr.pr(zo.hn().pr());
        hwVarPr.hw(this.hn.hn());
        prVarPr.pr(hwVarPr);
        return prVarPr;
    }
}
