package com.byazt.se;

import android.content.Context;
import com.byazt.vlj.zo;
import com.byazt.wf.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD, 62})
public class fw extends hn {
    public fw(Context context, hw hwVar, x xVar) {
        super(com.byazt.vlj.hn.JAVA, context, hwVar, xVar);
    }

    @Override // com.byazt.se.hn
    public com.byazt.lee.pr pr(com.byazt.lee.pr prVar) {
        com.byazt.lee.pr prVarPr = super.pr(prVar);
        prVarPr.pr("app_count", (Object) 1);
        prVarPr.pr("magic_tag", "ss_app_log");
        hn(prVarPr);
        com.byazt.lee.hw hwVarPr = com.byazt.lee.hw.pr(this.hw);
        hwVarPr.pr(zo.pr().pr());
        hwVarPr.pr(zo.hn().pr());
        hwVarPr.hw(this.hn.hn());
        prVarPr.pr(hwVarPr);
        w.pr(prVarPr, hwVarPr, this.pr);
        return prVarPr;
    }
}
