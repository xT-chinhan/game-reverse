package com.byazt.aqe;

import android.app.Activity;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 8})
public class s extends n {
    public boolean cd;
    public com.byazt.mr.w hd;

    public s(Activity activity, pk pkVar, boolean z) {
        super(activity, pkVar);
        this.hd = null;
        this.cd = z;
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(final tj tjVar) {
        if (!this.cd) {
            qg.n nVarQg = super.qg(tjVar);
            if (nVarQg.s()) {
                return nVarQg;
            }
        }
        final com.byazt.mr.w wVar = new com.byazt.mr.w(this.fs);
        this.hd = wVar;
        wVar.l("tt_retain_gift").n(fs()).s("继续观看").q("坚持退出");
        this.hd.n(com.byazt.cb.qg.rv(this.fs));
        this.hd.n(new com.byazt.mr.w.n() { // from class: com.byazt.aqe.s.1
            @Override // com.byazt.mr.w.n
            public void n() {
                wVar.dismiss();
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
            }

            @Override // com.byazt.mr.w.n
            public void qg() {
                wVar.dismiss();
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }
        });
        this.hd.show();
        return new qg.n(true, 0, "", this.hd);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        if ((this.n <= 0) || !this.l) {
            return this.l ? "忘记点击广告领取奖励啦～" : "再看" + this.n + "s可领取奖励";
        }
        return "再看" + this.n + "s，并点击一下广告可领取奖励";
    }

    @Override // com.byazt.aqe.qg
    public boolean qg() {
        com.byazt.mr.w wVar = this.hd;
        return wVar != null && wVar.isShowing();
    }

    @Override // com.byazt.aqe.qg
    public void s() {
        com.byazt.mr.w wVar = this.hd;
        if (wVar != null) {
            wVar.dismiss();
        }
    }
}
