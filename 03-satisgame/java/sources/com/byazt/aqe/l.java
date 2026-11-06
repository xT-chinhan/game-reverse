package com.byazt.aqe;

import android.app.Activity;
import android.view.View;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING, 18})
public class l extends n {
    public com.byazt.mr.w hd;

    public l(Activity activity, pk pkVar) {
        super(activity, pkVar);
        this.hd = null;
    }

    @Override // com.byazt.aqe.n, com.byazt.aqe.qg
    public qg.n qg(final tj tjVar) {
        final com.byazt.mr.w wVar = new com.byazt.mr.w(this.fs);
        this.hd = wVar;
        wVar.l("tt_retain_gift").n(fs()).s("继续观看").q("坚持退出");
        wVar.n(com.byazt.cb.qg.oa(this.fs));
        this.hd.n(new com.byazt.mr.w.n() { // from class: com.byazt.aqe.l.1
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
        this.hd.n(new View.OnClickListener() { // from class: com.byazt.aqe.l.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                wVar.dismiss();
                tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.s();
                }
            }
        });
        this.hd.show();
        return new qg.n(true, 0, "", this.hd);
    }

    @Override // com.byazt.aqe.qg
    public String n() {
        return "继续观看" + this.n + "秒可获得奖励\n确定要退出吗？";
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
