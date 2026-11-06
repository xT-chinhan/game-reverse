package com.byazt.xm;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL, 21})
public class x implements com.byazt.fb.l {
    public com.byazt.np.n n;
    public l q;
    public com.byazt.pch.n qg;
    public com.byazt.ap.q s;

    public x(Context context, com.byazt.pch.n nVar, com.byazt.ap.q qVar) {
        this.qg = nVar;
        if (nVar != null) {
            this.n = new com.byazt.np.n(context);
            this.s = qVar;
        }
    }

    @Override // com.byazt.fb.l
    public void n() {
        this.n.n(new com.byazt.qn.qg(10, this.qg.lh(), this.qg.an()), new com.byazt.ig.qg() { // from class: com.byazt.xm.x.1
            @Override // com.byazt.ig.qg
            public void n(com.byazt.mj.n nVar) {
                if (nVar == null || x.this.s == null) {
                    return;
                }
                x.this.s.n(nVar.n, nVar.qg);
            }

            @Override // com.byazt.ig.qg
            public void n() {
                if (x.this.s != null) {
                    if (x.this.q == null) {
                        x.this.q = new l(x.this.n);
                    }
                    x.this.s.n(x.this.q);
                }
            }

            @Override // com.byazt.ig.qg
            public void qg() {
                if (x.this.s != null) {
                    x.this.s.n();
                    if (x.this.q == null) {
                        x.this.q = new l(x.this.n);
                    }
                    x.this.s.qg(x.this.q);
                }
            }
        });
    }
}
