package com.byazt.yy;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 19})
public class n implements com.byazt.mw.n.qg {
    public com.byazt.mw.n.qg n;
    public int qg;

    public n(com.byazt.mw.n.qg qgVar) {
        this.n = qgVar;
    }

    public void n(int i) {
        this.qg = i;
    }

    @Override // com.byazt.mw.n.qg
    public void n(int i, String str, com.byazt.gct.qg qgVar) {
        com.byazt.mw.n.qg qgVar2 = this.n;
        if (qgVar2 != null) {
            qgVar2.n(i, str, qgVar);
        }
    }

    @Override // com.byazt.mw.n.qg
    public void n(final com.byazt.gct.n nVar, final com.byazt.gct.qg qgVar) {
        com.byazt.iz.n.n(nVar);
        int i = this.qg;
        boolean z = true;
        boolean z2 = i == 3 || i == 4;
        if (z2) {
            z = (com.byazt.ed.q.n().d() & 1) != 1;
        }
        if (z) {
            if (this.n != null) {
                Runnable runnable = new Runnable() { // from class: com.byazt.yy.n.1
                    @Override // java.lang.Runnable
                    public void run() {
                        n.this.n.n(nVar, qgVar);
                    }
                };
                if (z2) {
                    com.byazt.ag.qg.n(runnable);
                    return;
                } else {
                    com.byazt.ag.qg.s(runnable);
                    return;
                }
            }
            return;
        }
        com.byazt.mw.n.qg qgVar2 = this.n;
        if (qgVar2 != null) {
            qgVar2.n(nVar, qgVar);
        }
    }
}
