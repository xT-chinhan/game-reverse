package com.byazt.aqe;

import android.app.Activity;
import com.byazt.gct.pk;
import com.byazt.gct.ry;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 19})
public abstract class n extends qg {
    public boolean l;
    public int n;
    public boolean q;
    public int qg;
    public boolean s;
    public boolean w;

    public n(Activity activity, pk pkVar) {
        super(activity, pkVar);
    }

    public n(Activity activity, pk pkVar, ry ryVar) {
        super(activity, pkVar, ryVar);
    }

    public void n(int i) {
        this.n = i;
    }

    public void qg(int i) {
        this.qg = i;
    }

    public void n(boolean z) {
        this.s = z;
    }

    public void qg(boolean z) {
        this.q = z;
    }

    public void s(boolean z) {
        this.w = z;
    }

    public void q(boolean z) {
        this.l = z;
    }

    @Override // com.byazt.aqe.qg
    public qg.n qg(tj tjVar) {
        oa oaVar = new oa(this.fs, this.x);
        oaVar.qg(this.q);
        oaVar.n(this.s);
        oaVar.n(this.n);
        oaVar.qg(this.qg);
        oaVar.q(this.cp);
        oaVar.s(this.d);
        oaVar.n(this.cy);
        oaVar.qg(this.k);
        oaVar.s(this.w);
        oaVar.q(this.l);
        return oaVar.qg(tjVar);
    }
}
