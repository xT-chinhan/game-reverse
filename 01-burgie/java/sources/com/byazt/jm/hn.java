package com.byazt.jm;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.hg.of;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 20})
public abstract class hn {
    public of hn;
    public ViewGroup hw;
    public Context pr;
    public aj.pr x;

    public abstract String pr();

    public abstract void pr(com.byazt.az.pr prVar);

    public void pr(Context context, ViewGroup viewGroup, of ofVar) {
        this.pr = context;
        this.hw = viewGroup;
        this.hn = ofVar;
    }

    public void pr(com.byazt.gz.x xVar, aj.pr prVar) {
        com.byazt.pj.pr.hn(this.hn, "splash_ad", pr());
        this.hw.setVisibility(0);
        this.x = prVar;
    }

    public void hw() {
        aj.pr prVar = this.x;
        if (prVar != null) {
            prVar.hw();
        }
    }

    public void pr(boolean z) {
    }
}
