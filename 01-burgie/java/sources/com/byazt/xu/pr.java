package com.byazt.xu;

import android.app.Activity;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.byazt.wv.vk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 37})
public abstract class pr extends com.byazt.wv.hw {
    public String pr;

    public void pr(String str) {
        this.pr = str;
    }

    public pr(Activity activity, of ofVar) {
        super(activity, ofVar);
    }

    public pr(Activity activity, of ofVar, pj pjVar) {
        super(activity, ofVar, pjVar);
    }

    @Override // com.byazt.wv.hw
    public com.byazt.wv.hw.pr pr(vk vkVar) {
        x xVar = new x(this.zo, this.fw);
        xVar.x(this.w);
        xVar.hn(this.k);
        xVar.hw(this.ho);
        xVar.pr(this.pr);
        return xVar.pr(vkVar);
    }
}
