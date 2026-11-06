package com.byazt.wv;

import android.app.Activity;
import com.byazt.hg.of;
import com.byazt.hg.pj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS, 37})
public abstract class pr extends hw {
    public boolean c;
    public boolean hn;
    public int hw;
    public int pr;
    public boolean uc;
    public boolean x;

    public pr(Activity activity, of ofVar) {
        super(activity, ofVar);
    }

    public pr(Activity activity, of ofVar, pj pjVar) {
        super(activity, ofVar, pjVar);
    }

    public void pr(int i) {
        this.pr = i;
    }

    public void hw(int i) {
        this.hw = i;
    }

    public void pr(boolean z) {
        this.hn = z;
    }

    public void hw(boolean z) {
        this.x = z;
    }

    public void hn(boolean z) {
        this.uc = z;
    }

    public void x(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.wv.hw
    public hw.pr hw(vk vkVar) {
        m mVar = new m(this.zo, this.fw);
        mVar.hw(this.x);
        mVar.pr(this.hn);
        mVar.pr(this.pr);
        mVar.hw(this.hw);
        mVar.x(this.w);
        mVar.hn(this.k);
        mVar.pr(this.nt);
        mVar.hw(this.ho);
        mVar.hn(this.uc);
        mVar.x(this.c);
        return mVar.hw(vkVar);
    }
}
