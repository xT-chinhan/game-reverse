package com.byazt.hi;

import android.text.TextUtils;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 123, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE})
public abstract class rv {
    public com.byazt.id.qg qg;
    public String s;

    public void qg() {
        com.byazt.id.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n(this.s, com.byazt.hes.qg.STARTED);
        }
    }

    public void s() {
        com.byazt.id.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n(this.s, com.byazt.hes.qg.REQED);
        }
    }

    public void n(final boolean z) {
        com.byazt.id.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n(this.s, new com.byazt.bok.qg.n() { // from class: com.byazt.hi.rv.1
                @Override // com.byazt.bok.qg.n
                public void n(com.byazt.wea.fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.s) {
                        ((com.byazt.wea.s) fsVar).fs = z;
                    }
                }
            });
            this.qg.n(this.s, com.byazt.hes.qg.RECEIVED);
        }
    }

    public void n(final String str, final boolean z, final com.byazt.di.n nVar, final pk pkVar) {
        com.byazt.id.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n(this.s, new com.byazt.bok.qg.n() { // from class: com.byazt.hi.rv.2
                @Override // com.byazt.bok.qg.n
                public void n(com.byazt.wea.fs fsVar) {
                    if (fsVar instanceof com.byazt.wea.s) {
                        com.byazt.wea.s sVar = (com.byazt.wea.s) fsVar;
                        sVar.q = pkVar;
                        sVar.rv = z;
                        sVar.tj = nVar;
                        if (TextUtils.isEmpty(str)) {
                            return;
                        }
                        sVar.cp.add(str);
                    }
                }
            });
            if (!TextUtils.isEmpty(str)) {
                ((com.byazt.id.s) com.byazt.bok.s.n(1)).n(str, new com.byazt.bok.qg.n() { // from class: com.byazt.hi.rv.3
                    @Override // com.byazt.bok.qg.n
                    public void n(com.byazt.wea.fs fsVar) {
                        if (fsVar instanceof com.byazt.wea.q) {
                            ((com.byazt.wea.q) fsVar).x = rv.this.s;
                        }
                    }
                });
            }
            this.qg.n(this.s, com.byazt.hes.qg.LOADED);
        }
    }
}
