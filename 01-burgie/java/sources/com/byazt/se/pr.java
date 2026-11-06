package com.byazt.se;

import android.content.Context;
import com.byazt.vlj.zo;
import com.byazt.wf.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.provider.ContentProviderManager;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 37})
public class pr extends hn {
    public pr(Context context, hw hwVar, x xVar) {
        super(com.byazt.vlj.hn.ANR, context, hwVar, xVar);
    }

    @Override // com.byazt.se.hn
    public com.byazt.lee.pr pr(com.byazt.lee.pr prVar) {
        com.byazt.lee.pr prVarPr = super.pr(prVar);
        com.byazt.lee.hw hwVarPr = com.byazt.lee.hw.pr(this.hw);
        hwVarPr.pr(zo.pr().pr());
        hwVarPr.pr(zo.hn().pr());
        hwVarPr.hw(this.hn.hn());
        prVarPr.pr(hwVarPr);
        prVarPr.pr(ContentProviderManager.PLUGIN_PROCESS_NAME, com.byazt.wf.pr.x(this.hw));
        w.pr(prVarPr, hwVarPr, this.pr);
        return prVarPr;
    }
}
